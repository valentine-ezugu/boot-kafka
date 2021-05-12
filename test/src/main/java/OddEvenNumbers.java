
public class OddEvenNumbers implements Runnable {

    final Object o;

    public OddEvenNumbers(Object o) {
        this.o = o;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            synchronized (o) {
                if (i % 2 == 0 && Thread.currentThread().getName().equals("t1")) {
                    try {
                        System.out.println("thread 1 " + i);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (i % 2 != 0 && Thread.currentThread().getName().equals("t2")) {
                    try {
                        System.out.println("thread 2 " + i);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        OddEvenNumbers odev = new OddEvenNumbers(lock);

        Thread t1 = new Thread(odev, "t1");
        Thread t2 = new Thread(odev, "t2");

        t1.start();
        t2.start();
    }


}
