package finder.annotation;

import java.lang.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/19 21:51
 */

@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Wrong {
}
