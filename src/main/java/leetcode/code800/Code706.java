package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/13 15:38
 */

public class Code706 {
    @SuppressWarnings("all")
    private static class MyHashMap {
        private static final int SIZE = 1000001;
        private boolean[] keys;
        private int[] values;
        public MyHashMap() {
            keys = new boolean[SIZE];
            values = new int[SIZE];
        }

        public void put(int key, int value) {
            keys[key] = true;
            values[key] = value;
        }

        public int get(int key) {
            if (! keys[key]) {
                return -1;
            }
            return values[key];
        }

        public void remove(int key) {
            keys[key] = false;
        }
    }
}
