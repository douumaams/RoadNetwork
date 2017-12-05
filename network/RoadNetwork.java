package network;

import java.util.ArrayList;

import vehicle.Vehicle;

/* Singleton */
public final class RoadNetwork implements NetworkElement
{
    // instance unique
    private static RoadNetwork uniqueInstance = null;
    private ArrayList<Segment> al_segment;

    // Constructeur prive
    private RoadNetwork()
    {
        this.al_segment = new ArrayList<>();
    }

    public static RoadNetwork makeRoadNetWork()
    {
        if (uniqueInstance == null)
            uniqueInstance = new RoadNetwork();
        return uniqueInstance;
    }

    public boolean addSegment(Segment s)
    {
        return al_segment.add(s);
    }

    public boolean delSegment(Segment s)
    {
        return al_segment.remove(s);
    }

    public boolean addVehicle(Vehicle v, Integer numSeg, Direction dir, Integer pos)
    {
        if (numSeg - 1 < 0)
        {
            System.out.println("Impossible d'ajouter un véhicule dans un segment inférieur à 0");
            return false;
        }

        if (numSeg - 1 > this.getSize())
        {
            System.out.println(
                    "/!\\ Impossible d'ajouter un véhicule sur le segment " + numSeg + " car il n'existe pas /!\\\n");
            return false;
        }

        return this.al_segment.get(numSeg - 1).addVehicle(v, dir, pos);
    }

    public Vehicle makeVehicle(Integer maxSpeed, Integer numSeg, Direction dir, Integer pos)
    {
        if (numSeg - 1 < 0)
        {
            System.out.println("Impossible d'ajouter un véhicule dans un segment inférieur à 0");
        }

        if (numSeg - 1 > this.getSize())
        {
            System.out.println(
                    "/!\\ Impossible d'ajouter un véhicule sur le segment " + numSeg + " car il n'existe pas /!\\\n");
        }

        return this.al_segment.get(numSeg - 1).makeVehicle(maxSpeed, numSeg, dir, pos);

    }

    public Integer getSize()
    {
        return this.al_segment.size();
    }

    @Override
    public String toString()
    {
        String s = "\nRoadNetwork [size=" + this.getSize() + "]\n";
        String s1 = al_segment + "";
        return s + s1;
    }

    @Override
    public String printState()
    {
        return this.toString();
    }

    public static void main(String[] args)
    {
        RoadNetwork r = RoadNetwork.makeRoadNetWork();
        r.addSegment(Segment.makeSegment(10));
        // r.addSegment(Segment.makeSegment(15));
        // r.addSegment(Segment.makeSegment(10));

        Vehicle v = r.makeVehicle(2, 1, Direction.RIGHT, 8);
        Vehicle v2 = r.makeVehicle(1, 1, Direction.RIGHT, 4);

        System.out.println(r.printState());

        v2.move();
        v.move();
        System.out.println(r.printState());

        v2.move();
        v.move();
        System.out.println(r.printState());

        v2.move();
        v.move();
        System.out.println(r.printState());

        v2.move();
        v.move();
        System.out.println(r.printState());
    }

}
