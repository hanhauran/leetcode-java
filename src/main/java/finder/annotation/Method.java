package finder.annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/6 20:55
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Method {
    Methods[] value() default {};
}
