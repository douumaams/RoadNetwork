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

	@Override
	public String toString()
	{
		String s = "RoadNetwork [size=" + this.al_segment.size() + "]\n";
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
		r.addSegment(Segment.newSegment(10));
		r.addSegment(Segment.newSegment(15));
		r.addSegment(Segment.newSegment(10));
		System.out.println(r.printState());
	}

}
