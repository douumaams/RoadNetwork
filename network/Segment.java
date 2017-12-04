package network;

import semaphores.Semaphore;
import sensors.Sensor;
import vehicle.Vehicle;

public class Segment implements NetworkElement
{
    private static Integer number = 1;
    private Integer id;
    private Integer size;
    private Way[] tabWay = new Way[2]; // 0: UP 1: DOWN

    private Segment(Integer size)
    {
        this.size = size;
        this.id = number;
        number++;
    }

    public static Segment makeSegment(Integer size)
    {
        Segment s = new Segment(size);
        s.tabWay = Way.newTabWay(size);
        // Arrays.sort(s.tabWay[Direction.DOWN.ordinal()].getTabBox());

        return s;
    }

    public boolean addSemaphore(Semaphore s, Direction dir)
    {
        return this.tabWay[dir.ordinal()].addSemaphore(s);
    }

    public boolean addVehicle(Vehicle v, Direction dir, Integer pos)
    {
        if (pos < 0)
        {
            System.out.println("/!\\ Impossible d'ajouter un véhicule dans une position inférieure à 0 /!\\");
            return false;
        }

        if (pos > this.size)
        {
            System.out.println("/!\\ Impossible d'ajouter un véhicule dans le sens " + dir + " à la position " + pos
                    + " car la taille du segment vaut " + this.size + " /!\\");
            return false;
        }

        return this.tabWay[dir.ordinal()].addVehicle(v, pos - 1);
    }

    public Vehicle makeVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos)
    {
        if (pos < 0)
        {
            System.out.println("/!\\ Impossible d'ajouter un véhicule dans une position inférieure à 0 /!\\");
        }

        if (pos > this.size)
        {
            System.out.println("/!\\ Impossible d'ajouter un véhicule dans le sens " + dir + " à la position " + pos
                    + " car la taille du segment vaut " + this.size + " /!\\");
        }

        return this.tabWay[dir.ordinal()].makeVehicle(maxSpeed, numSeg, dir, pos - 1);
    }

    public boolean addSensor(Direction dir, Sensor s, Integer pos)
    {
        if (pos < 0)
        {
            System.out.println("/!\\ Impossible d'ajouter un capteur dans une position inférieure à 0 /!\\");
            return false;
        }

        if (pos > this.size)
        {
            System.out.println("/!\\ Impossible d'ajouter un capteur dans le sens " + dir + " à la position " + pos
                    + " car la taille du segment vaut " + this.size + " /!\\");
            return false;
        }

        return this.tabWay[dir.ordinal()].addSensor(s, pos - 1);

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
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------------------------------------------\n\n");
        sb.append("Segment [id=" + id + ", size=" + size + "]\n\n");

        for (Way w : this.getTabWay())
        {
            sb.append(w.printState());
        }

        return sb.toString();
    }

    @Override
    public String printState()
    {
        return this.toString();
    }

    public static void main(String[] args)
    {
        Segment s = Segment.makeSegment(5);

        System.out.println(s.printState());
        Segment s2 = Segment.makeSegment(10);
        System.out.println(s2.printState());

    }

}
