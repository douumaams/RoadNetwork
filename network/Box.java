package network;

import observer.Observer;
import observer.Subject;
import sensors.Sensor;
import sensors.SensorException;
import sensors.SpeedSensorException;
import vehicle.Vehicle;

public class Box implements NetworkElement, Comparable<Box>, Subject
{
<<<<<<< HEAD
	private static Integer number = 1;
	private Integer id;
	private Integer pos;
	private Vehicle vehicle;
	private Observer sensor;

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
					"/!\\ Impossible d'ajouter un capteur ï¿½ la case " + this.id + " car elle possï¿½de dï¿½jï¿½ un capteur");

			System.out.println("Impossible d'ajouter un capteur ï¿½ la case " + this.id);
			return false;
		}
	}

	public boolean delSensor()
	{
		if (this.hasSensor())
		{
			this.sensor = null;
			System.out.println("Un capteur vient d'ï¿½tre supprimï¿½ de la case " + this.id);
			return true;
		} else
		{
			System.out.println("/!\\ Impossible de supprimer un capteur ï¿½ la case " + this.id
					+ "car elle ne possï¿½de pas de capteur /!\\");

			return false;
		}
	}

	public boolean addVehicle(Integer maxSpeed)
	{
		if (!this.hasVehicle())
		{
			this.vehicle = Vehicle.makeVehicle(maxSpeed);
			System.out.println("Un vï¿½hicule vient d'ï¿½tre ajoutï¿½ ï¿½ la case " + this.id);
			return true;
		} else
		{
			System.out.println("/!\\ Impossible d'ajouter un vï¿½hicule de la case " + this.id
					+ " car elle possï¿½de dï¿½jï¿½ un vï¿½hicule /!\\");
			return false;
		}
	}

	public boolean delVehicle()
	{
		if (this.hasVehicle())
		{
			this.vehicle = null;
			System.out.println("Un vehicle vient d'ï¿½tre supprimï¿½ de la case " + this.id);
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

	@Override
	public boolean register(Observer observer)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregister(Observer observer)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notifyObserver()
	{
		if(hasVehicle())
			try
			{
				sensor.actualize(vehicle.getId(), vehicle.getSpeed());
			} catch (SensorException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
=======
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
            System.out.println("Le capteur vient d'être ajouté à la case " + this.id);
            return true;
        }
        else
        {
            System.out.println(
                    "/!\\ Impossible d'ajouter un capteur à la case " + this.id + " car elle possède déjà un capteur");

            System.out.println("Impossible d'ajouter un capteur à la case " + this.id);
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
        }
        else
        {
            System.out.println("/!\\ Impossible de supprimer un capteur à la case " + this.id
                    + "car elle ne possède pas de capteur /!\\");

            return false;
        }
    }

    public boolean addVehicle(Vehicle v)
    {
        if (!this.hasVehicle())
        {
            this.vehicle = v;
            System.out.println("Le véhicule " + this.vehicle.getId() + " vient d'être ajouté dans le segment "
                    + this.vehicle.getNumSeg() + " à la case " + this.id);
            return true;
        }
        else
        {
            System.out.println("/!\\ Impossible d'ajouter le véhicule " + this.vehicle.getId() + " dans le segment "
                    + this.vehicle.getNumSeg() + " dans la case " + this.id
                    + " car elle possède déjà un véhicule /!\\");
            return false;
        }
    }

    public Vehicle makeVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos, Way way)
    {
        if (!this.hasVehicle())
        {
            this.vehicle = Vehicle.makeVehicle(maxSpeed, numSeg, dir, pos, way);
            System.out.println("Le véhicule " + this.vehicle.getId() + " vient d'être crée dans la voie "
                    + this.vehicle.getNumSeg() + " dans la case " + this.pos);

        }
        else
        {
            System.out.println("/!\\ Impossible d'ajouter le véhicule " + this.vehicle.getId() + " dans le segment "
                    + this.vehicle.getNumSeg() + " dans la case " + this.id
                    + " car elle possède déjà un véhicule /!\\");
        }
        return this.vehicle;
    }

    public boolean delVehicle()
    {
        if (this.hasVehicle())
        {
            System.out.println("Le vehicle " + this.vehicle.getId() + " vient d'être supprimé de la case " + this.id
                    + " du segment " + this.vehicle.getNumSeg());
            this.vehicle = null;
            return true;
        }
        else
        {
            System.out.println("Impossible de supprimer un véhicule de la case " + this.id + "du segment "
                    + this.vehicle.getNumSeg());
            return false;
        }
    }

    public Integer getId()
    {
        return this.id;
    }

    public static Box[] makeTabBox(Integer size, Direction dir)
    {
        Box[] tab_box = new Box[size];

        for (int i = 0; i < size; i++)
        {
            tab_box[i] = new Box(i + 1);
        }

        /*
         * if (dir == Direction.LEFT) { for (int i = 0; i < size; i++) { tab_box[i] =
         * new Box(i + 1); } }
         * 
         * if (dir == Direction.RIGHT) { int j = size; for (int i = 0; i < size; i++) {
         * tab_box[i] = new Box(j); j--;
         * 
         * } }
         */

        return tab_box;
    }

    @Override
    public String toString()
    {
        if (this.hasVehicle())
        {
            return "Box [" + this.pos + " | " + this.vehicle.getId() + "   | " + this.hasSensor() + "]";
        }
        else
        {
            return "Box [" + this.pos + " |     | " + this.hasSensor() + "]";
        }

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
        Box b3 = new Box();
        Box b4 = new Box();
        Box b5 = new Box();

        System.out.println(b1.printState());
        System.out.println(b2.printState());
        System.out.println(b3.printState());
        System.out.println(b4.printState());
        System.out.println(b5.printState());
    }
>>>>>>> ebe4b29aab4f64741ebf4767b741bcb846acb936
}
