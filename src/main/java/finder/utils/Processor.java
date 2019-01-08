package finder.utils;

import java.util.Set;

/**
 * @author hr.han
 * @date 2018/12/26 11:13
 */

@FunctionalInterface
public interface Processor {
    /**
     * process
     * @param classes 被处理的类
     * @param params 可能需要其他参数
     * @return 结果
     */
    String process(Set<Class<?>> classes, Object ... params);
}
