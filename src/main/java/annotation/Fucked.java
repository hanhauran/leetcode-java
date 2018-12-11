package annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2018/12/11 15:30
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Fucked {
}
