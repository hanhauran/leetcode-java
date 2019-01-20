package finder.processor;

import finder.annotation.Question;

import java.util.Arrays;
import java.util.Set;

/**
 * @author hr.han
 * @date 2019/1/20 12:45
 */

@Question
public class QuestionProcessor implements Processor {
    private static final String ERROR_MSG = "Sorry, the params inputted seems wrong, allowed params:[java.lang.Class, java.lang.String ...]";

    @Override
    public String process(Set<Class<?>> classes, Object... params) {
        if (params == null || params.length == 0) {
            return ERROR_MSG;
        }

        final String[] words = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            words[i] = String.valueOf(params[i]);
        }

        final StringBuilder builder = new StringBuilder();
        builder.append("Result for words contains: ")
                .append(Arrays.toString(words))
                .append("\n");
        classes.forEach(clazz -> {
            Question question = clazz.getAnnotation(Question.class);
            for (String word : words) {
                if (question.value().contains(word)) {
                    builder.append("   - ")
                            .append(clazz.getSimpleName())
                            .append(" ")
                            .append(question.value())
                            .append("\n");
                    break;
                }
            }
        });

        return builder.toString();
    }
}
