package junctions;

import network.Segment;

public class Intersection extends Junction
{

	public Intersection(Segment... segments) throws JunctionException
	{
		super(segments);
		
		if(segments.length < 3)
			throw new IntersectionException("a barrier has only one segment");
	}

	@Override
	public void chooseDestination()
	{
		// TODO Auto-generated method stub
		
	}

}
