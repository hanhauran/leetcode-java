package finder.utils;

import finder.annotation.Method;
import finder.annotation.Methods;
import finder.annotation.Question;

import java.util.Arrays;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/8 16:14
 */

public class MethodsProcessor implements Processor {
    private static final String ERROR_MSG = "Sorry, the params inputted seems wrong, allowed params:[java.lang.Class, finder.annotation.Methods]";

    @Override
    public String process(Set<Class<?>> classes, Object ... params) {
        Methods method;
        if (params.length > 0) {
            method = (Methods) params[0];
        } else {
            return ERROR_MSG;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Methods : ").append(method).append("\n");
        classes.forEach(clazz -> {
            Method anno = clazz.getAnnotation(Method.class);
            if (anno == null) {
                return;
            }
            Methods[] methods = anno.value();
            for (Methods m : methods) {
                if (! method.equals(m)) {
                    continue;
                }
                Question question = clazz.getAnnotation(Question.class);
                builder.append("  - ")
                        .append(clazz.getName())
                        .append(" -----> ")
                        .append(Arrays.toString(methods));
                if (question != null) {
                    builder.append(" -----> ").append(question.value());
                }
                builder.append("\n");
                break;
            }
        });
        return builder.toString();
    }
}
