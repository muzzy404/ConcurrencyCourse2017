package lesson180717;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Daria on 18.07.2017.
 */
public class LockUnlockSeparateExample {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        System.out.println(lock.getHoldCount());
        lock.lock();
        lock.lock();
        System.out.println(lock.getHoldCount());

        new Thread(() -> {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            } else {
                System.out.println("can not do that");
            }
        }).start();


    }

}
