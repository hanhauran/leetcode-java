package finder.utils;

import finder.annotation.Unsolved;

import java.util.Set;

/**
 * @author hr.han
 * @date 2018/12/26 11:18
 */

public class UnsolvedProcessor implements Processor {
    @Override
    public String process(Set<Class<?>> classes) {
        StringBuilder builder = new StringBuilder();
        int unsolved = 0;
        for (Class<?> clazz : classes) {
            Unsolved tag = clazz.getAnnotation(Unsolved.class);
            if (tag != null && tag.value()) {
                builder.append("  - ").append(clazz.getName()).append("\n");
                unsolved++;
            }
        }
        builder.insert(0,
                "Unsolved : total=" + classes.size()
                        + ", unsolved=" + unsolved
                        + ", solved=" + (classes.size() - unsolved)
                        + "\n");
        return builder.toString();
    }
}
