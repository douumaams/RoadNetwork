package network;

import semaphores.Semaphore;

public class Way implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Integer size;
	private Direction dir;
	private Box[] tabBox;
	private Semaphore[] semaphore = new Semaphore[2]; // 0: UP 1: DOWN

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

		tab_way[0].tabBox = Box.newTabBox(size);
		tab_way[1].tabBox = Box.newTabBox(size);

		return tab_way;

	}

	public boolean hasSemaphore(Direction dir)
	{
		if (dir == Direction.UP)
		{
			return (this.semaphore[0] == null) ? false : true;
		} else
		{
			return (this.semaphore[1] == null) ? false : true;
		}

	}

	public boolean addSemaphore(Semaphore s, Direction dir)
	{
		if (dir == Direction.UP)
		{
			if (!hasSemaphore(dir))
			{
				this.semaphore[0] = s;
				System.out.println("Un sémaphore a été ajouté sur la voie " + this.getId() + "dans le sens" + dir);
				return true;
			} else
			{
				System.out.println(
						"Impossible d'ajouter un sémaphore sur la voie " + this.getId() + "dans le sens" + dir);
				return false;
			}
		} else
		{
			if (!hasSemaphore(dir))
			{
				this.semaphore[1] = s;
				System.out.println("Un sémaphore a été ajouté sur la voie " + this.getId() + "dans le sens" + dir);
				return true;
			} else
			{
				System.out.println(
						"Impossible d'ajouter un sémaphore sur la voie " + this.getId() + "dans le sens" + dir);
				return false;
			}
		}
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
		way.tabBox = Box.newTabBox(10);
		System.out.println(way.printState());
	}
}
