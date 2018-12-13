package leetcode.code800;

import java.util.LinkedList;

/**
 * @author hr.han
 * @date 2018/12/13 15:27
 */

public class Code705 {
    private static class MyHashSet {
        private LinkedList<Integer>[] heap;
        private final int size = 10000;
        public MyHashSet() {
            heap = new LinkedList[size];
        }

        public void add(int key) {
            int index = Integer.hashCode(key) / size;
            if (heap[index] == null) {
                heap[index] = new LinkedList<>();
                heap[index].add(key);
            } else {
                if (! heap[index].contains(key)) {
                    heap[index].add(key);
                }
            }
        }

        public void remove(int key) {
            int index = Integer.hashCode(key) / size;
            if (heap[index] == null) {
                return;
            }

            heap[index].remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int index = Integer.hashCode(key) / size;
            if (heap[index] == null) {
                return false;
            }
            return heap[index].contains(key);
        }
    }
}
