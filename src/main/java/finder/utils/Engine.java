package finder.utils;

import finder.annotation.Fucked;
import finder.annotation.Interesting;
import finder.annotation.Unsolved;
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
            EXT_MAP.put(Fucked.class, FuckedProcessor.class.newInstance());
            EXT_MAP.put(Interesting.class, InterestingProcessor.class.newInstance());
            EXT_MAP.put(Unsolved.class, UnsolvedProcessor.class.newInstance());
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public String process(Class<? extends Annotation> anno) {
        Set<Class<?>> classes = REFLECTIONS.getTypesAnnotatedWith(anno);
        Processor processor = EXT_MAP.get(anno);
        return processor.process(classes);
    }
}
