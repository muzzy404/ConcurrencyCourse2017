package lesson180717;

/**
 * Created by Daria on 18.07.2017.
 */
public class SynchLock {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        synchronized (o1) {
            synchronized (o2) {
                // need to free o1, but can not do that!
                // use locks for such situations
            }
        }

    }

}
