package finder.annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/17 16:57
 *
 * 前向链接
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Link {
    Class<?> value();
}
