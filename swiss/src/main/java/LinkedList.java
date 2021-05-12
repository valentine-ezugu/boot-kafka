//import java.util.*;
//import java.util.stream.Collectors;
//
//public class LinkedList<T> {
//
//    Node head;
//
//    public <T> LinkedList(List<T> asList) {
//    }
//
//    public void add(T value) {
//        Node node = new Node(value, null);
//        if (head == null) {
//            head = node;
//        } else {
//            Node last = head;
//            while (last.next != null) {
//                last = last.next;
//            }
//            last.next = node;
//        }
//    }
//
//    private class Node {
//
//        final T value;
//        Node next;
//
//        public Node(T value, Node next) {
//            this.value = value;
//            this.next = next;
//        }
//
//    }
//
//    public void reverse() {
//        if (head == null) {
//            return;
//        }
//        Node p1 = head;
//        Node temp;
//        while (p1.next != null) {
//            temp = p1.next;
//            p1.next = temp.next;
//            temp.next = head;
//            head = temp;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "LinkedList{" +
//                "head=" + head +
//                '}';
//    }
//}
