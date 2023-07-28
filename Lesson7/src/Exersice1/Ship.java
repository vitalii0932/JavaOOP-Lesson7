package Exersice1;

public class Ship implements Runnable{
    private String name;
    private Port port;

    public Ship(String name, Port port) {
        this.name = name;
        this.port = port;
    }

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        port.shipUnload(this);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                '}';
    }
}
