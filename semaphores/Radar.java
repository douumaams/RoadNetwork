package semaphores;

public class Radar extends Semaphore
{
	private int speedLimit;
	
	@Override
	public String toString()
	{
		return "Radar " + super.toString() + "speedLimit=" + speedLimit +"]";
	}
	
}
