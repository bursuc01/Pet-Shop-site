package com.example.petshop.Observer;

public interface Subject {
    public void registerObserver(CustomObserver o);
    public void removeObserver(CustomObserver o);
    public boolean notifyObservers(Integer qty);

}
