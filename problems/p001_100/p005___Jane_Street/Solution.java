package p001_100.p005___Jane_Street;

public class Solution {
    public static void main(String[] args) {
        Cons<Integer, String> cons = new Cons<>(1, "abc");
        System.out.println(cons.car(cons));
        System.out.println(cons.cdr(cons));
    }

    private record Cons<T1, T2>(T1 a, T2 b) {

        public Object car(Cons cons) {
            return cons.a;
        }

        public Object cdr(Cons cons) {
            return cons.b;
        }
    }
}
