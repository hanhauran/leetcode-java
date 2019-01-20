package finder.processor;

import finder.annotation.*;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hr.han
 * @date 2018/12/26 11:12
 */

public class Engine {
    public static Engine getInstance() {
        return Handler.INSTANCE;
    }
    private static class Handler {
        private static final Engine INSTANCE = new Engine();
    }

    private static final Map<Class<? extends Annotation>, Processor> EXT_MAP = new ConcurrentHashMap<>();
    private static final Reflections REFLECTIONS = new Reflections("leetcode");

    private Engine() {
        try {
            Reflections reflections = new Reflections("finder.processor");
            Set<Class<? extends Processor>> classes = reflections.getSubTypesOf(Processor.class);
            for (Class<? extends Processor> clazz : classes) {
                Annotation[] annotation = clazz.getDeclaredAnnotations();
                if (annotation.length == 1) {
                    EXT_MAP.put(annotation[0].annotationType(), clazz.newInstance());
                }
            }
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public String process(Class<? extends Annotation> anno, Object ... params) {
        Set<Class<?>> classes = REFLECTIONS.getTypesAnnotatedWith(anno);
        Processor processor = EXT_MAP.get(anno);
        return processor == null ? buildErrorMsg(anno) : processor.process(classes, params);
    }

    private static final String ERROR_MSG_CACHE = "Sorry, but there is no default processor for annotation:[";
    private String buildErrorMsg(Class<? extends Annotation> anno) {
        return ERROR_MSG_CACHE + anno.getSimpleName() + "]";
    }
}
