package semaphores;

public class RoadSign extends Semaphore
{
	private int speedLimit;
	
	@Override
	public String toString()
	{
		return "RoadSign " + super.toString() + "speedLimit=" + speedLimit +"]";
	}

}
