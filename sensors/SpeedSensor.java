package sensors;

public class SpeedSensor extends Sensor
{
	private int speedLimit;
	
	@Override
	public void actualize(int... interest) throws SpeedSensorException
	{
		if(interest.length < 2)
			throw new SpeedSensorException("Le sensor n'arrive pas detecter toutes les informations sur la voiture");
		
		int idVoiture = interest[0];
		int speed = interest[1];
		
		if(speed > speedLimit)
		{
			super.notifyObserver();
			System.out.println("La voiture "+idVoiture +"roule a une vitesse de " + interest);
		}
		// traiter les exceptions
		
	}


}
