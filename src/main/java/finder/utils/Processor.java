package finder.utils;

import java.util.Set;

/**
 * @author hr.han
 * @date 2018/12/26 11:13
 */

@FunctionalInterface
public interface Processor {
    String process(Set<Class<?>> classes);
}
