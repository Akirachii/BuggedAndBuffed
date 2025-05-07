public class Ship {
    private int id;
    private int ownerId;
    private String name;
    private ShipType type;
    

    public Ship(int id, int ownerId, String name, ShipType type){
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public int getOwnerId() { return ownerId; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public ShipType getType() {return type;}

    public void setType(ShipType type) {this.type = type;}

    

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }

}
