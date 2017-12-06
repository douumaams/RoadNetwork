package network;

import semaphores.Semaphore;
import sensors.Sensor;
import vehicle.Vehicle;

public class Way implements NetworkElement
{

    private static Integer number = 1;
    private Integer id;
    private Integer size;
    private Direction dir;
    private Box[] tabBox;
    private Semaphore semaphore;

    private Way(Integer size, Direction dir)
    {
        this.dir = dir;
        this.size = size;
        this.id = number;
        number++;
    }

    public static Way[] newTabWay(Integer size)
    {
        Way[] tab_way = new Way[2];
        tab_way[Direction.LEFT.ordinal()] = new Way(size, Direction.LEFT);
        tab_way[Direction.RIGHT.ordinal()] = new Way(size, Direction.RIGHT);

        tab_way[Direction.LEFT.ordinal()].tabBox = Box.makeTabBox(size, Direction.LEFT);
        tab_way[Direction.RIGHT.ordinal()].tabBox = Box.makeTabBox(size, Direction.RIGHT);

        return tab_way;

    }

    public boolean hasSemaphore()
    {

        return (this.semaphore == null);
    }

    public boolean addSemaphore(Semaphore s)
    {
        if (!hasSemaphore())
        {
            this.semaphore = s;
            System.out.println("Un s�maphore a �t� ajout� sur la voie " + this.getId() + "dans le sens" + dir);
            return true;
        }
        else
        {
            System.out.println("/!\\ Impossible d'ajouter un s�maphore sur la voie " + this.getId() + "dans le sens"
                    + dir + " car elle poss�de d�j� un s�maphore /!\\");
            return false;
        }
    }

    public boolean addVehicle(Vehicle v, Integer pos)
    {
        return this.tabBox[pos].addVehicle(v);
    }

    public Vehicle makeVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos)
    {
        return this.tabBox[pos].makeVehicle(maxSpeed, numSeg, dir, pos, this);
    }

    public boolean addSensor(Sensor s, Integer pos)
    {
        return this.tabBox[pos].addSensor(s);
    }

    public static Integer getNumber()
    {
        return number;
    }

    public Integer getId()
    {
        return id;
    }

    public Integer getSize()
    {
        return size;
    }

    public Direction getDir()
    {
        return dir;
    }

    public Box[] getTabBox()
    {
        return tabBox;
    }

    @Override
    public String toString()
    {
        String s = "Way " + dir + " [id=" + id + ", size=" + size + "]\n";

        if (this.dir == Direction.LEFT)
        {
            for (Box b : this.getTabBox())
            {
                s += b.printState() + "\n";
            }
        }
        if (this.dir == Direction.RIGHT)
        {
            Box[] b = this.getTabBox();
            for (int i = this.size - 1; i >= 0; i--)
            {
                s += b[i].printState() + "\n";
            }
        }

        return s + "\n";
    }

    @Override
    public String printState()
    {
        return this.toString();
    }

    public static void main(String[] args)
    {
        Way way = new Way(10, Direction.LEFT);
        way.tabBox = Box.makeTabBox(10, Direction.LEFT);
        System.out.println(way.printState());
    }

}
