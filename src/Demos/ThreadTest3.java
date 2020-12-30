package Demos;

// 实现多个线程操作同一个对象
// 买回车票的例子
// 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class ThreadTest3 implements Runnable{

    // 票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            // 模拟延迟
            try {
                Thread.sleep(200); // 延迟两百毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        ThreadTest3 ticket = new ThreadTest3();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();
    }
}
