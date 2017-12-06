package sensors;

public abstract class SensorException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6070420302617522385L;

	public SensorException(String msg)
	{
		super(msg);
	}
	
	public SensorException()
	{
		super();
	}
}
