package finder.processor;

import finder.annotation.Fucked;

import java.util.Set;

/**
 * @author hr.han
 * @date 2018/12/26 11:14
 */

public class FuckedProcessor implements Processor {
    @Override
    public String process(Set<Class<?>> classes, Object ... params) {
        StringBuilder builder = new StringBuilder();
        builder.append("Fucked : ").append(classes.size()).append("\n");
        classes.forEach(clazz -> {
            Fucked fucked = clazz.getAnnotation(Fucked.class);
            if (fucked != null) {
                builder.append("  - ").append(clazz.getName()).append(" -----> ").append(fucked.value()).append("\n");
            }
        });
        return builder.toString();
    }
}
