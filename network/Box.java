package network;

import observer.Observer;
import observer.Subject;
import sensors.Sensor;
import sensors.SensorException;
import vehicle.Vehicle;

public class Box implements NetworkElement, Comparable<Box>, Subject
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
            System.out.println("Le capteur vient d'�tre ajout� � la case " + this.id);
            return true;
        }
        else
        {
            System.out.println(
                    "/!\\ Impossible d'ajouter un capteur � la case " + this.id + " car elle poss�de d�j� un capteur");

            System.out.println("Impossible d'ajouter un capteur � la case " + this.id);
            return false;
        }
    }

    public boolean delSensor()
    {
        if (this.hasSensor())
        {
            this.sensor = null;
            System.out.println("Un capteur vient d'�tre supprim� de la case " + this.id);
            return true;
        }
        else
        {
            System.out.println("/!\\ Impossible de supprimer un capteur � la case " + this.id
                    + "car elle ne poss�de pas de capteur /!\\");

            return false;
        }
    }

    public boolean addVehicle(Vehicle v)
    {
        if (!this.hasVehicle())
        {
            this.vehicle = v;
            System.out.println("Le v�hicule " + this.vehicle.getId() + " vient d'�tre ajout� dans le segment "
                    + this.vehicle.getNumSeg() + " � la case " + this.id);
            return true;
        }
        else
        {
            System.out.println("/!\\ Impossible d'ajouter le v�hicule " + this.vehicle.getId() + " dans le segment "
                    + this.vehicle.getNumSeg() + " dans la case " + this.id
                    + " car elle poss�de d�j� un v�hicule /!\\");
            return false;
        }
    }

    public Vehicle makeVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos, Way way)
    {
        if (!this.hasVehicle())
        {
            this.vehicle = Vehicle.makeVehicle(maxSpeed, numSeg, dir, pos, way);
            System.out.println("Le v�hicule " + this.vehicle.getId() + " vient d'�tre cr�e dans la voie "
                    + this.vehicle.getNumSeg() + " dans la case " + this.pos);

        }
        else
        {
            System.out.println("/!\\ Impossible d'ajouter le v�hicule " + this.vehicle.getId() + " dans le segment "
                    + this.vehicle.getNumSeg() + " dans la case " + this.id
                    + " car elle poss�de d�j� un v�hicule /!\\");
        }
        return this.vehicle;
    }

    public boolean delVehicle()
    {
        if (this.hasVehicle())
        {
            System.out.println("Le vehicle " + this.vehicle.getId() + " vient d'�tre supprim� de la case " + this.id
                    + " du segment " + this.vehicle.getNumSeg());
            this.vehicle = null;
            return true;
        }
        else
        {
            System.out.println("Impossible de supprimer un v�hicule de la case " + this.id + "du segment "
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

    public static Box makeBox()
    {
		return new Box();
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
