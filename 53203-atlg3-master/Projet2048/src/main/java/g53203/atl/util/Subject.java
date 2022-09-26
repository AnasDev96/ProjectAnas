package g53203.atl.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Subject, subject for different class
 *
 * @author Anas Benallal  53203
 */
public abstract class Subject {

    private List<Observable> observers = new ArrayList<>();

    /**
     * for regist different observer
     *
     * @param observer observer
     */
    public void register(Observable observer) {
        observers.add(observer);
    }

    /**
     * remove one observers
     *
     * @param observer observer
     */
    public void unrigister(Observable observer) {
        observers.remove(observer);
    }

    /**
     * Give info for different Update
     */
    protected void notifiyObserver() {
        for (Observable observers : observers) {
            observers.upDate();
        }
    }
}
