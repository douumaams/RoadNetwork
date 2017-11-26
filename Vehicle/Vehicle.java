package vehicle;

import network.NetworkElement;

public class Vehicle implements NetworkElement
{
	private static Integer number = 1;
	private Integer id;
	private Integer maxSpeed;
	private Integer speed;
	private Integer position;

	private Vehicle(Integer maxSpeed, Integer position)
	{
		this.id = number;
		number++;
		this.maxSpeed = maxSpeed;
		this.speed = maxSpeed;
		this.position = position;
	}

	public static Vehicle newVehicle(Integer maxSpeed, Integer position)
	{
		Vehicle v = new Vehicle(maxSpeed, position);
		return v;
	}

	public void move()
	{

	}

	@Override
	public String toString()
	{
		return "Vehicle [id=" + id + ", maxSpeed=" + maxSpeed + ", speed=" + speed + ", position=" + position + "]";
	}

	@Override
	public String printState()
	{
		return this.toString();
	}

	public static void main(String[] args)
	{
		Vehicle v1 = Vehicle.newVehicle(10, 1);
		Vehicle v2 = Vehicle.newVehicle(10, 2);
		Vehicle v3 = Vehicle.newVehicle(10, 3);
		Vehicle v4 = Vehicle.newVehicle(10, 4);

		System.out.println(v1.printState());
		System.out.println(v2.printState());
		System.out.println(v3.printState());
		System.out.println(v4.printState());

	}
}
