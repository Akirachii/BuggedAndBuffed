import java.util.ArrayList;
import java.util.List;

public class Mothership {

    private int id;
    private String name;
    private double credit;
    private int totalHangar;
    private int usedHangar;
    private List<Ship> ownedShips;

    public Mothership(int id, String name, double credit, int totalHangar, int usedHangar) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.totalHangar = totalHangar;
        this.usedHangar = usedHangar;
        this.ownedShips = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCredit() { return credit; }
    public int getTotalHangar() { return totalHangar; }
    public int getUsedHangar() { return usedHangar; }
    public List<Ship> getOwnedShips() { return ownedShips; }

    public void addShip(Ship ship){
        ownedShips.add(ship);
        usedHangar += ship.getType().getSize();
    }

    public void removeShip(Ship ship){
        if (ownedShips.remove(ship)){
            usedHangar -= ship.getType().getSize();
        }
    }

    public boolean hasspace(ShipType type){
        return usedHangar + type.getSize() <= totalHangar;
    }

    public void removeCredit(int amount){
        this.credit -= amount;
    }

    public void addCredit(int amount){
        this.credit += amount;
    }

    @Override
    public String toString() {
        return "Mothership{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", totalHangar=" + totalHangar +
                ", usedHangar=" + usedHangar +
                ", ownedShips=" + ownedShips +
                '}';
    }
    
}