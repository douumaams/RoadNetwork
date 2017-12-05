package observer;

public interface Subject
{
	public boolean register(Observer observer);
	public boolean unregister(Observer observer);
	public void notifyObserver();
}
