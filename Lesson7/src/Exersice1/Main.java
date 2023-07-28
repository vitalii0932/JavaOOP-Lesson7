package Exersice1;

public class Main {
    public static void main(String[] args) {
        Port port = new Port();

        Ship ship1 =  new Ship("Queen Anne's Revenge", port);
        Ship ship2 = new Ship("Adventure Galley", port);
        Ship ship3 = new Ship("Royal Fortune", port);

        Thread thread1 = new Thread(ship1);
        Thread thread2 = new Thread(ship2);
        Thread thread3 = new Thread(ship3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}