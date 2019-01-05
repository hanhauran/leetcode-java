package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/5 13:19
 */

@Level(Levels.EASY)
public class Code937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> numLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for (String log : logs) {
            helper(log, numLogs, letterLogs);
        }
//        letterLogs.sort(Comparator.comparing(log -> {
//            int index = log.indexOf(" ");
//            return log.substring(index + 1);
//        }));
        letterLogs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(o1.indexOf(' ') + 1).compareTo(o2.substring(o2.indexOf(' ') + 1));
            }
        });
        letterLogs.addAll(numLogs);
        String[] res = new String[letterLogs.size()];
        letterLogs.toArray(res);
        return res;
    }

    private void helper(String log, List<String> numLogs, List<String> letterLogs) {
        int index = log.indexOf(" ");
        char cur = log.charAt(index + 1);
        if (Character.isLetter(cur)) {
            letterLogs.add(log);
        } else {
            numLogs.add(log);
        }
    }

    public static void main(String[] args) {
        System.out.println("a1".compareTo("ab1"));
    }
}
