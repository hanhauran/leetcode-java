package finder;

import finder.annotation.Fucked;
import finder.annotation.Interesting;
import finder.annotation.Unsolved;
import finder.utils.Engine;

import java.lang.annotation.Annotation;

/**
 * @author hr.han
 * @date 2018/12/26 11:05
 */

public class Main {
    public static void findAll(Class<? extends Annotation> anno) {
        System.out.println(Engine.getInstance().process(anno));
    }

    public static void main(String[] args) {
        findAll(Fucked.class);
        findAll(Interesting.class);
        findAll(Unsolved.class);
    }
}
