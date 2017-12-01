package network;

import sensors.Sensor;
import vehicle.Vehicle;

public class Box implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Vehicle vehicle;
	private Sensor sensor;

	private Box()
	{
		this.id = number;
		this.sensor = null;
		number++;
	}

	public boolean hasSensor()
	{
		return sensor == null;
	}

	public boolean hasVehicle()
	{
		return (vehicle == null) ? false : true;
	}

	public boolean addSensor(Sensor s)
	{
		if (!this.hasSensor())
		{
			this.sensor = s;
			System.out.println("Un capteur vient d'�tre ajout� � la case " + this.id);
			return true;
		} else
		{
			System.out.println("Impossible d'ajouter un capteur � la case " + this.id);
			return false;
		}
	}

	public boolean delSensor(Sensor s)
	{
		if (this.hasSensor())
		{
			this.sensor = null;
			System.out.println("Un capteur vient d'�tre supprim� � la case " + this.id);
			return true;
		} else
		{
			System.out.println("Impossible de supprimer un capteur � la case " + this.id);
			return false;
		}
	}

	public Integer getId()
	{
		return this.id;
	}

	public static Box[] newTabBox(Integer size)
	{
		Box[] tab_box = new Box[size];

		for (int i = 0; i < size; i++)
		{
			tab_box[i] = new Box();
		}

		return tab_box;
	}

	@Override
	public String toString()
	{
		return "Box [id=" + id + ", vehicle=" + this.hasVehicle() + ", sensor=" + this.hasSensor() + "]";
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	public static void main(String[] args)
	{
		Box b1 = new Box();
		Box b2 = new Box();
		Box b3 = new Box();
		Box b4 = new Box();
		Box b5 = new Box();

		System.out.println(b1.printState());
		System.out.println(b2.printState());
		System.out.println(b3.printState());
		System.out.println(b4.printState());
		System.out.println(b5.printState());
	}
}
