package Exersice1;

public class Port {
    private volatile int shipCount = 0;

    public Port() {
    }

    public synchronized void shipUnload(Ship ship) {
        shipCount++;

        for(; shipCount > 2;) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        for(int i = 1; i <= 10; i++) {
            System.out.println(ship.getName() + ": " + (i * 10) + "%");
            try {
                wait(500);
            } catch (InterruptedException e) {
            }
        }
        shipCount--;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Port{}";
    }
}
