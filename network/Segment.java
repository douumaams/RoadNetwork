package network;

import java.util.Arrays;

import semaphores.Semaphore;
import sensors.Sensor;

public class Segment implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Integer size;
	private Way[] tabWay = new Way[2]; // 0: UP 1: DOWN

	private Segment(Integer size)
	{
		this.size = size;
		this.id = number;
		number++;
	}

	public static Segment makeSegment(Integer size)
	{
		Segment s = new Segment(size);
		s.tabWay = Way.newTabWay(size);
		Arrays.sort(s.tabWay[Direction.DOWN.ordinal()].getTabBox());

		return s;
	}

	public boolean addSemaphore(Semaphore s, Direction dir)
	{
		return this.tabWay[dir.ordinal()].addSemaphore(s);
	}

	public boolean addVehicle(Direction dir, Integer maxSpeed, Integer pos)
	{
		if (pos < 0)
		{
			System.out.println("/!\\ Impossible d'ajouter un v�hicule dans une position inf�rieure � 0 /!\\");
			return false;
		}

		if (pos > this.size)
		{
			System.out.println("/!\\ Impossible d'ajouter un v�hicule dans le sens " + dir + " � la position " + pos
					+ " car la taille du segment vaut " + this.size + " /!\\");
			return false;
		}

		return this.tabWay[dir.ordinal()].addVehicle(maxSpeed, pos - 1);

	}

	public boolean addSensor(Direction dir, Sensor s, Integer pos)
	{
		if (pos < 0)
		{
			System.out.println("/!\\ Impossible d'ajouter un capteur dans une position inf�rieure � 0 /!\\");
			return false;
		}

		if (pos > this.size)
		{
			System.out.println("/!\\ Impossible d'ajouter un capteur dans le sens " + dir + " � la position " + pos
					+ " car la taille du segment vaut " + this.size + " /!\\");
			return false;
		}

		return this.tabWay[dir.ordinal()].addSensor(s, pos - 1);

	}

	public Integer getSize()
	{
		return this.size;
	}

	public Integer getId()
	{
		return this.id;
	}

	public static Integer getNumber()
	{
		return number;
	}

	public Way[] getTabWay()
	{
		return tabWay;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------------------\n\n");
		sb.append("Segment [id=" + id + ", size=" + size + "]\n\n");

		for (Way w : this.getTabWay())
		{
			sb.append(w.printState());
		}

		return sb.toString();
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	public static void main(String[] args)
	{
		Segment s = Segment.makeSegment(5);
		s.addVehicle(Direction.UP, 10, 4);
		s.addVehicle(Direction.UP, 10, 6);
		System.out.println(s.printState());
		Segment s2 = Segment.makeSegment(10);
		System.out.println(s2.printState());

	}

}
