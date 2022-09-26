package Deadlock;

public class Ressource {

    private final String name;
    private boolean isLock;

    public Ressource(String name) {
        this.name = name;
        this.isLock = false;
    }

    void lock() {
        isLock = true;
    }

    void unlock() {
        isLock = false;
    }

    String getStatus() {
        String status = "(est libre)";
        if (isLock) {
            status = "(est bloquée)";
        }
        return status;
    }

    @Override
    public String toString() {
        return name;
    }

}
