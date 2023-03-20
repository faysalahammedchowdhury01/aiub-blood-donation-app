package server;

public class test {
    public int a;

    public void change(test t) {
        t.a = 100;
    }

    public static void main(String[] args) {
        test t = new test();
        t.a = 10000;
        System.out.println(t.a);
        t.change(t);
        System.out.println(t.a);
    }
}
