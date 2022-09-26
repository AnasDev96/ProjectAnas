
package g53203.atl.fx.bmr.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Subject, subject for different class
 * @author Anas Benallal - 53203
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    /**
     * for refist different observer
     * @param observer 
     */
    public void register(Observer observer) {
        observers.add(observer);
    }
    /**
     *  remove one observers
     * @param observer 
     */
    public void unrigister(Observer observer) {
        observers.remove(observer);
    }
    /**
     * Give info for different Update
     */
    protected void notifiyObserver() {
        for (Observer observers : observers) {
            observers.upDate();
        }
    }
}
