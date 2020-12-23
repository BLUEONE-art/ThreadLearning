package Demos;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class ThreadTest implements Runnable {

    private String url;  // 网络图片的URL地址
    private String name; // 保存的文件名

    // 构造方法
    public ThreadTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片的线程的执行体
    @Override
    public void run() {
        WebDownloder webDownloder = new WebDownloder();
        webDownloder.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        ThreadTest thread1 = new ThreadTest("https://img-blog.csdnimg.cn/20200313234915684.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQzMDkxNA==,size_16,color_FFFFFF,t_70", "1.jpg");
        ThreadTest thread2 = new ThreadTest("https://img-blog.csdnimg.cn/2020031400314213.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQzMDkxNA==,size_16,color_FFFFFF,t_70", "2.jpg");
        ThreadTest thread3 = new ThreadTest("https://img-blog.csdnimg.cn/20200314003602499.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQzMDkxNA==,size_16,color_FFFFFF,t_70", "3.jpg");

        // 启动线程
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }
}

// 下载器
class WebDownloder {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Io异常，downloader方法出现问题");
        }
    }
}
