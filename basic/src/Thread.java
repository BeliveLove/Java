
import java.util.concurrent.locks.LockSupport;

/**
 * @author Administrator
 */
public class Thread {
    public static void main(String[] args) {
        NEW();
        RUNNABLE();
        BLOCKED();
        WAITING();
        TERMINATED();
    }

    private static void NEW() {
        //new:new了线程，但是未start
        System.out.println("new状态");
        byte[] lock = new byte[0];
        MyThread thread = new MyThread(lock);
        //NEW
        System.out.println(thread.getName() + "        " + thread.getState());
    }

    private static void RUNNABLE() {
        //run：new了线程，启用start
        System.out.println("run状态");
        byte[] lock = new byte[0];
        java.lang.Thread thread = new MyThread(lock);
        thread.start();
        //RUNNABLE
        System.out.println(thread.getName() + "        " + thread.getState());
    }

    private static void BLOCKED() {
        System.out.println("block状态");
        //block:线程等待获取锁的状态(阻塞态)
        byte[] lock = new byte[0];
        //此时锁的优先权在thread1
        MyThread thread1 = new MyThread(lock);
        thread1.start();
        //当thread1结束时，释放所资源，thread2获取锁
        MyThread thread2 = new MyThread(lock);
        thread2.start();
        try {
            java.lang.Thread.sleep(1000);//等一会再检查状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //耗时等待态
        //TIMED_WAITING
        System.out.println(thread1.getName() + "        " + thread1.getState());
        //阻塞态    此时锁的优先权在thread1，不在thread2，thread2处于阻塞态
        //BLOCKED
        System.out.println(thread2.getName() + "        " + thread2.getState());

    }

    public static void WAITING() {
        /*
         * WAITING分为
         *   1.TIMED_WAITING：耗时等待态 限时条件往下走
         *   2.WAITING：永久等待态 符合条件往下走
         * */
        System.out.println("waiting状态");
        byte[] lock = new byte[0];
        MyThread2 Thread3 = new MyThread2(lock);
        Thread3.start();
        try {
            java.lang.Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread3.getName() + "        " + Thread3.getState());
        LockSupport.unpark(Thread3);
        try {
            java.lang.Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread3.getName() + "        " + Thread3.getState());
    }

    public static void TERMINATED() {
        System.out.println("terminated状态");
        /*
         * TIMED_WAITING:线程结束的状态
         * */
        byte[] lock = new byte[0];
        MyThread myThread = new MyThread(lock);
        myThread.start();
        try {
            java.lang.Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThread.getName() + "        " + myThread.getState());
    }

    public static class MyThread extends java.lang.Thread {
        private byte[] lock = new byte[0];

        public MyThread(byte[] lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    java.lang.Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + "     " + "done");
            }
        }
    }

    public static class MyThread2 extends java.lang.Thread {
        private byte[] lock = new byte[0];

        public MyThread2(byte[] lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            LockSupport.park();
            System.out.println(this.getName() + "        " + "done");
        }
    }
}
