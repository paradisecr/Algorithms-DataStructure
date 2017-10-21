package me.rui.tencent;

/**
 * Created by caorui on 2017/9/13.
 */
public class StaticTest {
    public static void test() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        StaticTest staticTest = null;
        staticTest.test();
    }
}
