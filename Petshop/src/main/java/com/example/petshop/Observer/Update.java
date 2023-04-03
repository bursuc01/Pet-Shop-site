package com.example.petshop.Observer;

import java.util.ArrayList;

public class Update implements Subject {
    private ArrayList<CustomObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(CustomObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(CustomObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public boolean notifyObservers(Integer qty) {
        System.out.println("I am here 3 " +qty);
        for (CustomObserver customObserver : observers) {
            ((CustomObserver) customObserver).update(qty);
        }
        return true;
    }
}
