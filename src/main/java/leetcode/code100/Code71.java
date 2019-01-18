package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/18 19:16
 */

@Level(Levels.MEDIUM)
@Question("以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。")
public class Code71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        List<String> res = new ArrayList<>();

        for (String p : paths) {
            switch (p) {
                case "":
                case ".": continue;
                case "..": {
                    if (! res.isEmpty()) {
                        res.remove(res.size() - 1);
                    }
                    break;
                }
                default: {
                    res.add(p);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String s : res) {
            builder.append('/').append(s);
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        Code71 code = new Code71();
        System.out.println(code.simplifyPath("/home/"));
    }
}
