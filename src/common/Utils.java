package common;

/**
 * Created by Daria on 09.07.2017.
 */
public class Utils {

    public static void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
