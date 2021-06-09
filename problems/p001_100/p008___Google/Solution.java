package p001_100.p008___Google;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Tree tree = new Tree();
        tree.createDefaultTree();
        return tree.count(tree.root);
    }

    private static class Tree {

        private Node<Integer> root;

        public void createDefaultTree() {
            root = new Node<>(0);
            root.left = new Node<>(1);
            root.right = new Node<>(0);
            root.right.right = new Node<>(0);
            root.right.left = new Node<>(1);
            root.right.left.right = new Node<>(1);
            root.right.left.left = new Node<>(1);
        }

        public int count(Node<Integer> node) {

            if (node == null) {
                return 0;
            }

            int count = count(node.left);
            count += count(node.right);

            return isUnivalTree(node) ? count + 1 : count;
        }

        private static boolean isUnivalTree(Node<Integer> node) {
            if (node == null)
                return true;
            if (node.left != null && node.left.data != node.data)
                return false;
            if (node.right != null && node.right.data != node.data)
                return false;
            return isUnivalTree(node.left) && isUnivalTree(node.right);
        }

        private static class Node<T> {
            private T data;
            private Node<T> left;
            private Node<T> right;

            public Node(T data, Node<T> left, Node<T> right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }

            public Node(T data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }

            public T getData() {
                return data;
            }

            public void setData(T data) {
                this.data = data;
            }

            public Node<T> getLeft() {
                return left;
            }

            public void setLeft(Node<T> left) {
                this.left = left;
            }

            public Node<T> getRight() {
                return right;
            }

            public void setRight(Node<T> right) {
                this.right = right;
            }
        }
    }
}
