package hometask040717;

import common.Utils;

/**
 * Created by Daria on 09.07.2017.
 */
public class Philosopher extends Thread {

    private static final int EATING_TIME = 10_000;

    public static final int SILLY = 0;
    public static final int SMART = 1;

    private final int id;
    private int mode;

    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    volatile private boolean dinner;

    Philosopher(int id, String name,
                Chopstick rightChopstick, Chopstick leftChopstick,
                boolean dinner) {
        this.id = id;
        setName(name);

        mode = SILLY;

        this.rightChopstick = rightChopstick;
        this.leftChopstick = leftChopstick;

        this.dinner = dinner;
    }

    void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public void run() {

        switch (mode) {
            case SILLY:
                while (dinner) {

                    synchronized (rightChopstick) {
                        System.out.println("[id = " + Integer.toString(id) + "] " + getName() +
                                " took right chopstick [id = " + Integer.toString(rightChopstick.getId()) + "]");
                        synchronized (leftChopstick) {
                            System.out.println("[id = " + Integer.toString(id) + "] " + getName() +
                                    " took left chopstick [id = " + Integer.toString(leftChopstick.getId()) + "]");

                            System.out.println(getName() + " starts to eat");
                            Utils.pause(EATING_TIME);
                            System.out.println(getName() + " finished");

                        }
                    }

                }

                System.out.println("Silly " + getName() + " finished dinner");
                break;

            case SMART: {
                Chopstick first, second;
                if (leftChopstick.getId() < rightChopstick.getId()) {
                    first = leftChopstick;
                    second = rightChopstick;
                } else {
                    first = rightChopstick;
                    second = leftChopstick;
                }

                while (dinner) {
                    synchronized (first) {
                        System.out.println("[id = " + Integer.toString(id) + "] " + getName() +
                                " took first chopstick [id = " + Integer.toString(rightChopstick.getId()) + "]");
                        synchronized (second) {
                            System.out.println("[id = " + Integer.toString(id) + "] " + getName() +
                                    " took second chopstick [id = " + Integer.toString(leftChopstick.getId()) + "]");

                            System.out.println(getName() + " starts to eat");
                            Utils.pause(EATING_TIME);
                            System.out.println(getName() + " finished");
                        }
                        Utils.pause(300);
                    }
                } // dinner cycle
            }
            break;

            default:
                System.out.println("Philosopher mode error");
        }
    }

}
