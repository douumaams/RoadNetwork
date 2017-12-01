package network;

import java.util.ArrayList;

public class RoadNetwork implements NetworkElement
{
	private ArrayList<Segment> al_segment;

	// Constructeur prive
	private RoadNetwork()
	{
		this.al_segment = new ArrayList<>();
	}

	// instance unique
	private static RoadNetwork uniqueInstance = new RoadNetwork();

	public static RoadNetwork getInstance()
	{
		return uniqueInstance;
	}

	public boolean addSegment(Segment s)
	{
		return al_segment.add(s);
	}

	public boolean delSegment(Segment s)
	{
		return al_segment.remove(s);
	}

	public boolean addVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos)
	{
		if (numSeg - 1 < 0)
		{
			System.out.println("Impossible d'ajouter un véhicule dans un segment inférieur à 0");
			return false;
		}

		if (numSeg - 1 > this.getSize())
		{
			System.out.println(
					"/!\\ Impossible d'ajouter un véhicule sur le segment " + numSeg + " car il n'existe pas /!\\\n");
			return false;
		}

		return this.al_segment.get(numSeg - 1).addVehicle(dir, maxSpeed, pos);

	}

	public Integer getSize()
	{
		return this.al_segment.size();
	}

	@Override
	public String toString()
	{
		String s = "RoadNetwork [size=" + this.getSize() + "]\n";
		String s1 = al_segment + "";
		return s + s1;
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	public static void main(String[] args)
	{
		RoadNetwork r = RoadNetwork.getInstance();
		r.addSegment(Segment.makeSegment(10));
		r.addSegment(Segment.makeSegment(15));
		r.addSegment(Segment.makeSegment(10));
		r.addVehicle(10, 1, Direction.DOWN, 1);
		System.out.println(r.printState());
	}

}
