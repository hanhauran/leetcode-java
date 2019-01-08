package finder;

import finder.annotation.*;
import finder.processor.Engine;

import java.lang.annotation.Annotation;

/**
 * @author hr.han
 * @date 2018/12/26 11:05
 */

public class Main {
    public static void findAll(Class<? extends Annotation> anno, Object ... params) {
        System.out.println(Engine.getInstance().process(anno, params));
    }

    public static void main(String[] args) {
        findAll(Fucked.class);
        findAll(Interesting.class);
        findAll(Unsolved.class);
        findAll(Method.class, Methods.RECURSE);
        findAll(Method.class, Methods.BFS);
        findAll(Level.class);
    }
}
