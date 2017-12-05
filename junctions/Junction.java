package junctions;

import network.Box;
import network.Segment;
import vehicle.Vehicle;

public abstract class Junction
{
	private int id;
	private Segment[] segments;
	private Box box;
	public Junction(Segment ... segments) throws JunctionException
	{
		if(segments == null)
			throw new JunctionException("The junction must have segments");
		this.segments = segments;
		this.box = Box.makeBox();
	}
	
	public boolean addVehicule(Vehicle vehicle)
	{
		return box.addVehicle(vehicle);
	}
	
	public boolean delVehicule()
	{
		return box.delVehicle();
	}
	
	public abstract void chooseDestination();
}
