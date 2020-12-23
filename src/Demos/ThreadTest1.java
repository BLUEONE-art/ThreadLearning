package Demos;

// 创建线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入Runnable接口的实现类，调用start方法。
public class ThreadTest1 implements Runnable{
    @Override
    public void run() {
        // run 方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // 创建一个 Runnable 接口的实现类
        ThreadTest1 threadTest1 = new ThreadTest1();

        // 创建一个线程类,通过线程对象开启我们的线程
//        Thread t1 = new Thread(threadTest1);
//        t1.start();

        new Thread(threadTest1).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
