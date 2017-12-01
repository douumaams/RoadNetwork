package semaphores;

public class TraficL <T extends IState> extends Semaphore
{
	private T state;
	
	public TraficL(T state)
	{
		this.state = state;
	}
	
	public void setState(T state)
	{
		this.state = state;
	}
	
	public T getState()
	{
		return state;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
