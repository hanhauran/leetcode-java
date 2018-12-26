package annotation.utils;

import annotation.Interesting;

import java.util.Set;

/**
 * @author hr.han
 * @date 2018/12/26 11:17
 */

public class InterestingProcessExt implements ProcessExt {
    @Override
    public String process(Set<Class<?>> classes) {
        StringBuilder builder = new StringBuilder();
        builder.append("Interesting : ").append(classes.size()).append("\n");
        classes.forEach(clazz -> {
            Interesting interesting = clazz.getAnnotation(Interesting.class);
            if (interesting != null) {
                builder.append("  - ")
                        .append(clazz.getName())
                        .append(" -----> ")
                        .append(interesting.value())
                        .append("\n");
            }
        });
        return builder.toString();
    }
}
