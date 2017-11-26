package network;

public class Segment implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Integer size;
	private Way[] tabWay = new Way[2];

	private Segment(Integer size)
	{
		this.size = size;
		this.id = number;
		number++;
	}

	public static Segment newSegment(Integer size)
	{
		Segment s = new Segment(size);
		s.tabWay = Way.newTabWay(size);

		return s;
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
		String s = "---------------------------------------------\n\n";
		String s1 = "Segment [id=" + id + ", size=" + size + "]\n\n";
		String s2 = "";
		for (Way w : this.getTabWay())
		{
			s2 += w.printState();
		}

		return s + s1 + s2;
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	public static void main(String[] args)
	{
		Segment s = Segment.newSegment(5);
		System.out.println(s.printState());
		Segment s2 = Segment.newSegment(10);
		System.out.println(s2.printState());

	}

}
