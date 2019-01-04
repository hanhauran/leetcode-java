package finder.annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/2 18:40
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Level {

    Levels value() default Levels.EASY;

}
