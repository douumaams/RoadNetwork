package junctions;

import network.Segment;

public class Barrier extends Junction
{

	public Barrier(Segment segments) throws JunctionException
	{
		super(segments);
//		if(segments.length != 1)
//			throw new JunctionException("we can't have a junction that connects less than 2 segments");
	}

	@Override
	public void chooseDestination()
	{
		// TODO Auto-generated method stub
		
	}

}
