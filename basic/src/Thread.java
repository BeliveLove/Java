/**
 * @author Administrator
 */
public class Thread {
    public static void main(String[] args) {
        NEW();
        RUNNABLE();
        BLOCKED();
    }

    private static void NEW() {
        System.out.println("new状态");
        byte[] lock = new byte[0];
        MyThread thread = new MyThread(lock);
        System.out.println(thread.getName()+"      "+thread.getState());
    }

    private static void RUNNABLE() {
        System.out.println("run状态");
        byte[] lock = new byte[0];
        java.lang.Thread thread = new MyThread(lock);
        thread.start();
        System.out.println(thread.getName() + "    " + thread.getState());
    }

    private static void BLOCKED() {
        byte[] lock = new byte[0];
        MyThread thread1 = new MyThread(lock);
        thread1.start();
        MyThread thread2 = new MyThread(lock);
        thread2.start();
        try {
            java.lang.Thread.sleep(1000);//等一会再检查状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread2.getName()+"       "+thread2.getState());
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
                System.out.println(this.getName()+"     "+"done");
            }
        }
    }
}
