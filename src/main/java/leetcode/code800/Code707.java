package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/13 15:45
 */

public class Code707 {
    private static class MyLinkedList {
        private static class Node {
            public int val;
            public Node next;
            public Node prev;
            public Node() {}
            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private Node tail;
        private int size;
        public MyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            return to(index).val;
        }

        public void addAtHead(int val) {
            Node tmp = head.next;
            Node cur = new Node(val);
            head.next = cur;
            cur.prev = head;
            cur.next = tmp;
            tmp.prev = cur;
            size++;
        }

        public void addAtTail(int val) {
            Node tmp = tail.prev;
            Node cur = new Node(val);
            tail.prev = cur;
            cur.next = tail;
            tmp.next = cur;
            cur.prev = tmp;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index == size) {
                addAtTail(val);
                return;
            }

            Node cur = to(index);

            Node tmp = new Node(val);
            tmp.prev = cur.prev;
            tmp.next = cur;
            cur.prev.next = tmp;
            cur.prev = tmp;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            Node cur = to(index);

            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }

        private Node to(int index) {
            int mid = size / 2;
            if (index <= mid) {
                Node cur = head.next;
                while (index != 0) {
                    cur = cur.next;
                    index--;
                }
                return cur;
            } else {
                index = size - index - 1;
                Node cur = tail.prev;
                while (index != 0) {
                    cur = cur.prev;
                    index--;
                }
                return cur;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("head -> ");
            Node cur = head.next;
            while (cur.next != null) {
                builder.append(cur.val).append(" -> ");
                cur = cur.next;
            }
            builder.append("tail");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        System.out.println(list);
        list.addAtHead(1);
        System.out.println(list);
        list.addAtTail(3);
        System.out.println(list);
        list.addAtIndex(1, 2);
        System.out.println(list);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list);
    }
}
