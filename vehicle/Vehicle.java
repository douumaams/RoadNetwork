package vehicle;

import network.Direction;
import network.NetworkElement;

public class Vehicle implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Integer maxSpeed;
	private Integer speed;

	// emplacement de la voiture
	private Integer segment;
	private Direction dir;
	private Integer position;

	private Vehicle(Integer maxSpeed)
	{
		this.id = number;
		number++;
		this.maxSpeed = maxSpeed;
		this.speed = maxSpeed;
	}

	/*
	 * private Vehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos)
	 * { this.id = number; number++; this.maxSpeed = maxSpeed; this.speed =
	 * maxSpeed; this.segment = segment; this.dir = dir; this.position = pos; }
	 */

	public static Vehicle makeVehicle(Integer maxSpeed)
	{
		Vehicle v = new Vehicle(maxSpeed);
		return v;
	}

	/*
	 * public static Vehicle newVehicle(Integer maxSpeed, Integer segment, Direction
	 * dir, Integer pos) { Vehicle v = new Vehicle(maxSpeed, segment, dir, pos);
	 * return v; }
	 */

	public void move()
	{

	}

	@Override
	public String toString()
	{
		return "Vehicle [id=" + id + ", maxSpeed=" + maxSpeed + ", speed=" + speed + ", segment=" + segment + ", dir="
				+ dir + ", position=" + position + "]";
	}

	@Override
	public String printState()
	{
		return this.toString();
	}
	
	
	public int getSpeed()
	{
		return speed;
	}
	
	
	public Integer getId()
	{
		return id;
	}

	public static void main(String[] args)
	{
		Vehicle v1 = Vehicle.makeVehicle(10);
		Vehicle v2 = Vehicle.makeVehicle(10);
		Vehicle v3 = Vehicle.makeVehicle(10);
		Vehicle v4 = Vehicle.makeVehicle(10);

		System.out.println(v1.printState());
		System.out.println(v2.printState());
		System.out.println(v3.printState());
		System.out.println(v4.printState());

	}
}
