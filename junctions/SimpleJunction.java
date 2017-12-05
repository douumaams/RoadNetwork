package junctions;

import network.Segment;

public class SimpleJunction extends Junction
{

	public SimpleJunction(Segment ... segments) throws JunctionException
	{
		super(segments);
		
		if(segments.length != 2)
			throw new SimpleJunctionException("A simple junction contains can only have 2 segment");
		
	}

	@Override
	public void chooseDestination()
	{
		// TODO Auto-generated method stub
		
	}
	
}
