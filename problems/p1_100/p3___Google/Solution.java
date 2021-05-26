package p1_100.p3___Google;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        Node<String> node1 = new Node<>("root",
                new Node<>("left",
                        new Node<>("left.left", null, null), null),
                new Node<>("right", null, null));

        Node<Integer> node2 = new Node<>(1,
                new Node<>(2,
                        new Node<>(3, null, null), null),
                new Node<>(4, null, null));

        System.out.println(node1.serialize().equals(node1.deserialize(node1.serialize()).toString()));
        System.out.println(node2.serialize().equals(node2.deserialize(node2.serialize()).toString()));

    }

    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value) { this.value = value; }

        public String serialize() { return toString(); }

        public Node<T> deserialize(String s) {
            int currentNode = -1;
            int nodesCount = 0;
            Map<Integer, Node<T>> nodeMap = new HashMap<>();
            String[] strings = s.split(" ");

            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals("Node")) {
                    Node<T> node = new Node<>((T) strings[i + 4]);
                    nodeMap.put(nodesCount, node);
                    if (i > 1) {
                        if (strings[i - 2].equals("left")) {
                            nodeMap.get(currentNode).left = node;
                        }
                        else if (strings[i - 2].equals("right")) {
                            nodeMap.get(currentNode).right = node;
                        }
                    }

                    currentNode++;
                    nodesCount++;
                }
                else if (strings[i].equals("}")) {
                    currentNode--;
                }
            }
            return nodeMap.get(0);
        }

        @Override
        public String toString() {
            return "Node { " +
                    "value = " + value +
                    " , left = " + left +
                    " , right = " + right +
                    " } ";
        }
    }
}
