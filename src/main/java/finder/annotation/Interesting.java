package finder.annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2018/12/14 21:07
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Interesting {
    String value() default "";
}
