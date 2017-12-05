package sensors;

import observer.Observer;
import observer.Subject;

public abstract class Sensor implements Observer, Subject
{
	private Observer regulator;

	public boolean hasRegulator()
	{
		return regulator == null;
	}
	
	@Override
	public boolean register(Observer observer)
	{
		if (!this.hasRegulator())
		{
			this.regulator = observer;
			System.out.println("yyyyyy");
			return true;
		} else
		{
			System.out.println(	"/!\\ xxxx");
			return false;
		}
	}

	@Override
	public boolean unregister(Observer observer)
	{
		if (this.hasRegulator())
		{
			this.regulator = null;
			System.out.println("/!\\ yyy /!\\");
			return true;
		} else
		{
			System.out.println("/!\\ xxx /!\\");
			return false;
		}
	}
	
	@Override
	public void notifyObserver()
	{
		try
		{
			regulator.actualize();
		} catch (SensorException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
