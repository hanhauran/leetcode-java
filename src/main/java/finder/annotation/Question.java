package finder.annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/6 21:15
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Question {
    String value() default "";
}
