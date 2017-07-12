package hometask040717;

import common.Utils;

/**
 * Created by Daria on 09.07.2017.
 */
public class DiningPhilosophersProblem {

    static boolean dinner = true;

    static Chopstick chopstick_1 = new Chopstick(1);
    static Chopstick chopstick_2 = new Chopstick(2);
    static Chopstick chopstick_3 = new Chopstick(3);
    static Chopstick chopstick_4 = new Chopstick(4);
    static Chopstick chopstick_5 = new Chopstick(5);

    static Philosopher Socrates   = new Philosopher(1, "Socrates",
            chopstick_5, chopstick_1, dinner);
    static Philosopher Plato      = new Philosopher(2, "Plato",
            chopstick_1, chopstick_2, dinner);
    static Philosopher Aristotle  = new Philosopher(3, "Aristotle",
            chopstick_2, chopstick_3, dinner);
    static Philosopher Confucius  = new Philosopher(4, "Confucius",
            chopstick_3, chopstick_4, dinner);
    static Philosopher Democritus = new Philosopher(5, "Democritus",
            chopstick_4, chopstick_5, dinner);

    public static void deadlock() {

        Socrates.setMode(Philosopher.SILLY);
        Plato.setMode(Philosopher.SILLY);
        Aristotle.setMode(Philosopher.SILLY);
        Confucius.setMode(Philosopher.SILLY);
        Democritus.setMode(Philosopher.SILLY);

        startDinner();
    }

    public static void noDeadlock() {

        Socrates.setMode(Philosopher.SMART);
        Plato.setMode(Philosopher.SMART);
        Aristotle.setMode(Philosopher.SMART);
        Confucius.setMode(Philosopher.SMART);
        Democritus.setMode(Philosopher.SMART);

        startDinner();
    }

    private static void startDinner() {
        new Thread(Socrates, Socrates.getName()).start();
        Utils.pause(300);

        new Thread(Plato, Plato.getName()).start();
        Utils.pause(300);

        new Thread(Aristotle, Aristotle.getName()).start();
        Utils.pause(300);

        new Thread(Confucius, Confucius.getName()).start();
        Utils.pause(300);

        new Thread(Democritus, Democritus.getName()).start();
        Utils.pause(300);
    }

    public static void main(String[] args) {

        //deadlock();
        noDeadlock();

    }

}
