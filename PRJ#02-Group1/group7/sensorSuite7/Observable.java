package sensorSuite7;

import views7.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void notifyAllObservers();
    String getData();
}
