package observer2;

public interface Subject {
    public void registerObserver(Observer o);
    public void notifyObservers();
}