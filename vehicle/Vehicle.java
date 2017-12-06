package vehicle;

import network.Box;
import network.Direction;
import network.NetworkElement;
import network.Way;

public class Vehicle implements NetworkElement
{
    private static Integer number = 1;
    private Integer id;
    private Integer maxSpeed;
    private Integer speed;

    // emplacement de la voiture
    private Integer numSeg;
    private Direction dir;
    private Integer position;

    private Way way;

    private Vehicle(Integer maxSpeed, Way way)
    {
        this.id = number;
        number++;
        this.maxSpeed = maxSpeed;
        this.speed = maxSpeed;
        this.way = way;
    }

    private Vehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos, Way way)
    {
        this.id = number;
        number++;
        this.maxSpeed = maxSpeed;
        this.speed = maxSpeed;
        this.numSeg = numSeg;
        this.dir = dir;
        this.position = pos;
        this.way = way;
    }

    /*
     * public static Vehicle makeVehicle(Integer maxSpeed, Way way) { Vehicle v =
     * new Vehicle(maxSpeed, way); return v; }
     */

    public static Vehicle makeVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos, Way way)
    {
        Vehicle v = new Vehicle(maxSpeed, numSeg, dir, pos, way);
        return v;
    }

    // m�thode qui d�place la voiture d'une seule case
    public void elementaryMove()
    {
        // System.out.println("elementaryMove");
        // System.out.println("pos initiale : " + this.position);
        // s'assurer que la case suivante est libre
        // vider la case courante
        // faire un deplacement
        // remplir la nouvelle case
        Box[] b = way.getTabBox();

        if (this.position >= b.length)
        {
            System.out.println("Il faudra g�rer �a avec les jonctions 1");
        }
        else
        {
            if ((this.position + 1 < b.length) && !b[this.position + 1].hasVehicle()) // pos suivante
            {
                // System.out.println("TEST");
                b[this.position].delVehicle(); // pos actuelle
                this.position++; // nouvelle pos
                if (this.position >= b.length)
                {
                    System.out.println("Il faudra g�rer �a avec les jonctions 2");
                }
                else
                {
                    b[this.position].addVehicle(this);
                }

            }
        }

    }

    public void move()
    {
        // faire n deplacements elementaires
        for (int i = 0; i < this.speed; i++)
            this.elementaryMove();
    }

    public Integer getId()
    {
        return id;
    }

    public Integer getNumSeg()
    {
        return numSeg;
    }

    @Override
    public String toString()
    {
        return "Vehicle [id=" + id + ", maxSpeed=" + maxSpeed + ", speed=" + speed + ", segment=" + numSeg + ", dir="
                + dir + ", position=" + position + "]";
    }

    @Override
    public String printState()
    {
        return this.toString();
    }
    
    public Integer getSpeed()
	{
		return speed;
	}

    public static void main(String[] args)
    {
        /*
         * Vehicle v1 = Vehicle.makeVehicle(10); Vehicle v2 = Vehicle.makeVehicle(10);
         * Vehicle v3 = Vehicle.makeVehicle(10); Vehicle v4 = Vehicle.makeVehicle(10);
         * 
         * System.out.println(v1.printState()); System.out.println(v2.printState());
         * System.out.println(v3.printState()); System.out.println(v4.printState());
         */

    }
}
