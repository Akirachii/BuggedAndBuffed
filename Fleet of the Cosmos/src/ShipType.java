public class ShipType {

    private int id;
    private String name;
    private double price;
    private int size;

    public ShipType(int id,String name,int price, int size){
        this.id=id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public ShipType(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public int getId() {return id;}
    
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public int getSize() {return size;}

    public void setSize(int size) {this.size = size;}

    @Override
    public String toString() {
        return "ShipType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }


    
}
