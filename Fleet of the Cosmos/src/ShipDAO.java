
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipDAO {
    private ShipTypeDAO shipTypeDAO = new ShipTypeDAO();

    public List<Ship> AllShipType(){
        List<Ship> ships = new ArrayList<>();
        String query = "SELECT * FROM ship";

        try (Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int ownerId = rs.getInt("owner_id");
                    String name = rs.getString("name");
                    int typeId = rs.getInt("type_id");

                    ShipType type = shipTypeDAO.getShipTypeId(typeId);
                    Ship ship = new Ship(id, ownerId, name, type);
                    ships.add(ship);
                }
            
        } catch (SQLException e) {
            System.out.println("Error fetching ships: " + e.getMessage());
        }
        return ships;
    }

    public void addShip(Ship ship){
        String query = "INSERT INTO ship (owner_id, name, type_id) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ship.getOwnerId());
            stmt.setString(2, ship.getName());
            stmt.setInt(3, ship.getType().getId());

            stmt.executeUpdate();

            
        } catch (SQLException e) {
            System.out.println("Error adding ship: " + e.getMessage());
        }
        
    }

    public Ship getShipId(int id){
        String query = "SELECT * FROM ship WHERE id = ?";

        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int owner_id = rs.getInt("owner_id");
                String name = rs.getString("name");
                int type_id = rs.getInt("type_id");

                ShipType type = shipTypeDAO.getShipTypeId(type_id);
                return new Ship(type_id, owner_id, name, type);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching ship: " + e.getMessage());
        }
        return null;
    }


    public void delShip(int id){
        String query = "DELETE FROM ship WHERE id = ?";

        try (Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, id);
            stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error deleting ship: " + e.getMessage());
        }
    }

}
