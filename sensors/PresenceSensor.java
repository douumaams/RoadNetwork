package sensors;

public class PresenceSensor extends Sensor
{

	@Override
	public void actualize(int ... interest) throws PresenceSencorException
	{
		if(interest.length < 1)
			throw new PresenceSencorException("La capteur de vitesse ne foctionne pas correctement");
		super.notifyObserver();
	}
	

}
