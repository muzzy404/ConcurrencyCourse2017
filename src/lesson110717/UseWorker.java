package lesson110717;

/**
 * Created by Daria on 11.07.2017.
 */
public class UseWorker {

    public static void main(String[] args) {
        SimpleWorker worker = new SimpleWorker();

        worker.process(() -> {
            System.out.println("u did it!");
        });

        worker.process(() -> {
            System.out.println("u did it!");
        });

        worker.process(() -> {
            System.out.println("u did it!");
        });
    }

}
