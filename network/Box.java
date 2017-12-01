package network;

import sensors.Sensor;
import vehicle.Vehicle;

public class Box implements NetworkElement, Comparable<Box>
{
	private static Integer number = 1;
	private Integer id;
	private Integer pos;
	private Vehicle vehicle;
	private Sensor sensor;

	private Box()
	{
		this.id = number;
		this.sensor = null;
		this.vehicle = null;
		number++;
	}

	private Box(Integer pos)
	{
		this.id = number;
		this.pos = pos;
		this.sensor = null;
		this.vehicle = null;
		number++;
	}

	public boolean hasSensor()
	{
		return (sensor != null);
	}

	public boolean hasVehicle()
	{
		return (vehicle != null);
	}

	public boolean addSensor(Sensor s)
	{
		if (!this.hasSensor())
		{
			this.sensor = s;
			System.out.println("Un capteur vient d'ï¿½tre ajoutï¿½ ï¿½ la case " + this.id);
			return true;
		} else
		{
			System.out.println(
					"/!\\ Impossible d'ajouter un capteur à la case " + this.id + " car elle possède déjà un capteur");

			System.out.println("Impossible d'ajouter un capteur ï¿½ la case " + this.id);
			return false;
		}
	}

	public boolean delSensor()
	{
		if (this.hasSensor())
		{
			this.sensor = null;
			System.out.println("Un capteur vient d'être supprimé de la case " + this.id);
			return true;
		} else
		{
			System.out.println("/!\\ Impossible de supprimer un capteur à la case " + this.id
					+ "car elle ne possède pas de capteur /!\\");

			return false;
		}
	}

	public boolean addVehicle(Integer maxSpeed)
	{
		if (!this.hasVehicle())
		{
			this.vehicle = Vehicle.makeVehicle(maxSpeed);
			System.out.println("Un véhicule vient d'être ajouté à la case " + this.id);
			return true;
		} else
		{
			System.out.println("/!\\ Impossible d'ajouter un véhicule de la case " + this.id
					+ " car elle possède déjà un véhicule /!\\");
			return false;
		}
	}

	public boolean delVehicle()
	{
		if (this.hasVehicle())
		{
			this.vehicle = null;
			System.out.println("Un vehicle vient d'être supprimé de la case " + this.id);
			return true;
		} else
		{
			System.out.println("Impossible de supprimer un capteur ï¿½ la case " + this.id);
			return false;
		}
	}

	public Integer getId()
	{
		return this.id;
	}

	public static Box[] makeTabBox(Integer size)
	{
		Box[] tab_box = new Box[size];

		for (int i = 0; i < size; i++)
		{
			tab_box[i] = new Box(i + 1);
		}

		return tab_box;
	}

	@Override
	public String toString()
	{
		return "Box [pos=" + this.pos + ", id=" + id + ", vehicle=" + this.hasVehicle() + ", sensor=" + this.hasSensor()
				+ "]";
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	@Override
	public int compareTo(Box b)
	{
		return (b.getId() - this.id);
	}

	public static void main(String[] args)
	{
		Box b1 = new Box();
		Box b2 = new Box();
		b2.addVehicle(10);
		b2.delVehicle();
		b2.addVehicle(15);
		b2.addVehicle(30);
		b2.delVehicle();
		b2.delVehicle();
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
