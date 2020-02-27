

package SampleJavaCodes.DesignPatternImplementations.OberverPattern;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class ConcreteObserver implements Observer{
    public static void main(String[] args) {
        ConcreteObserver observer = new ConcreteObserver();



        ConcreteObservable observable = new ConcreteObservable();
        observable.addObserver(observer);
        
        observable.notifyObservers();
        
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I received info from" + o.getClass() + " with the message " + arg.toString());

    }
    
}

class ConcreteObservable extends Observable{
    ArrayList<Observer> observers = new ArrayList<Observer>();
    @Override
    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, "eek");
        }
        
    }
}

