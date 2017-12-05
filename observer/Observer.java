package observer;

import sensors.PresenceSencorException;
import sensors.SpeedSensorException;

public interface Observer
{
	public void actualize(int ... interest) throws SpeedSensorException, PresenceSencorException;

}
