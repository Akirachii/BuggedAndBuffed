
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipTypeDAO {
    public List <ShipType> AllShipType(){
        List<ShipType> shipTypes = new ArrayList<>();
        
        String query = "SELECT * FROM ship_type";

        try (Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int size = rs.getInt("size");
                
                    ShipType shipType = new ShipType(id, name, price, size);
                    shipTypes.add(shipType);
                }
            
        } catch (SQLException e) {
            System.out.println("Error fetching ship types: " + e.getMessage());
        }
        return shipTypes;
    }

    public ShipType getShipTypeId (int id){
        String query = "SELECT * FROM ship_type WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int size = rs.getInt("size");

                    return new ShipType(id, query, id, id);
                }

        } catch (SQLException e) {
            System.out.println("Error finding ship type: " + e.getMessage());
        }

        return null;
    }
}
