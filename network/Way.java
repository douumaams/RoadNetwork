package network;

import semaphores.Semaphore;
import sensors.Sensor;

public class Way implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Integer size;
	private Direction dir;
	private Box[] tabBox;
	private Semaphore semaphore;

	private Way(Integer size, Direction dir)
	{
		this.dir = dir;
		this.size = size;
		this.id = number;
		number++;
	}

	public static Way[] newTabWay(Integer size)
	{
		Way[] tab_way = new Way[2];
		tab_way[0] = new Way(size, Direction.UP);
		tab_way[1] = new Way(size, Direction.DOWN);

		tab_way[0].tabBox = Box.makeTabBox(size);
		tab_way[1].tabBox = Box.makeTabBox(size);

		return tab_way;

	}

	public boolean hasSemaphore()
	{

		return (this.semaphore == null);
	}

	public boolean addSemaphore(Semaphore s)
	{
		if (!hasSemaphore())
		{
			this.semaphore = s;
			System.out.println("Un sémaphore a été ajouté sur la voie " + this.getId() + "dans le sens" + dir);
			return true;
		} else
		{
			System.out.println("/!\\ Impossible d'ajouter un sémaphore sur la voie " + this.getId() + "dans le sens"
					+ dir + " car elle possède déjà un sémaphore /!\\");
			return false;
		}
	}

	public boolean addVehicle(Integer maxSpeed, Integer pos)
	{
		return this.tabBox[pos].addVehicle(maxSpeed);
	}

	public boolean addSensor(Sensor s, Integer pos)
	{
		return this.tabBox[pos].addSensor(s);
	}

	public static Integer getNumber()
	{
		return number;
	}

	public Integer getId()
	{
		return id;
	}

	public Integer getSize()
	{
		return size;
	}

	public Direction getDir()
	{
		return dir;
	}

	public Box[] getTabBox()
	{
		return tabBox;
	}

	@Override
	public String toString()
	{
		String s = "Way " + dir + " [id=" + id + ", size=" + size + "]\n";

		for (Box b : this.getTabBox())
		{
			s += b.printState() + "\n";
		}

		return s + "\n";
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	public static void main(String[] args)
	{
		Way way = new Way(10, Direction.UP);
		way.tabBox = Box.makeTabBox(10);
		System.out.println(way.printState());
	}
}
