package annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2018/12/1 15:43
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Unsolved {

    boolean value() default true;

}
