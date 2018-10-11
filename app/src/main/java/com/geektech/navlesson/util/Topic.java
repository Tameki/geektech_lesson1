package com.geektech.navlesson.util;

import java.util.LinkedList;
import java.util.List;

public class Topic implements Observable {

    private List<Observer> observers;

    private static Topic INSTANCE;
    public static Topic getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Topic();
        }
        return INSTANCE;
    }

    private Topic() {
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer observer : observers) {
            observer.update(message);
        }
    }
}
