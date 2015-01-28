package com.annvcit.util;

public interface Observable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers(Object... objects);
	void setChanged();
}
