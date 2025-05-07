
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MothershipDAO {
    public List<Mothership> getAllMotherships(){
        List<Mothership> motherships = new ArrayList<>();
        String query = "SELECT * FROM mother_ship";

        try (Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
            
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double credit = rs.getDouble("credit");
                    int totalHangar = rs.getInt("totalHangar");
                    int usedHangar = rs.getInt("usedHangar");

                    Mothership mothership = new Mothership(id, name, credit, totalHangar, usedHangar);
                    motherships.add(mothership);
                }
        } catch (SQLException e) {
            System.out.println("Error fetching motherships: " + e.getMessage());
        }

        return motherships;
    }


    public Mothership getMothership(int id){
        String query = "SELECT * FROM mother_ship WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();      
                
                if (rs.next()) {
                    String name = rs.getString("name");
                    double credit = rs.getDouble("credit");
                    int totalHangar = rs.getInt("totalHangar");
                    int usedHangar = rs.getInt("usedHangar");

                    return new Mothership(id, name, credit, totalHangar, usedHangar);
                }
        } catch (SQLException e) {
            System.out.println("Error fetching mothership: " + e.getMessage());
        }
        return null;
    }

    public Mothership updaMothership(Mothership mothership){
        String query = "UPDATE mother_ship SET credit = ?, totalHangar_size = ?, used_hangar_size = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            
                stmt.setDouble(1, mothership.getCredit());
                stmt.setInt(2, mothership.getTotalHangar());
                stmt.setInt(3, mothership.getUsedHangar());
                stmt.setInt(4, mothership.getId());

                stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating mothership: " + e.getMessage());
        }
        return null;
    }

    public void addMothership(Mothership mothership){
        String query = "INSERT INTO mother_ship (name, credit, total_hangar_size, used_hangar_size) VALUES (?,?,?,?)";

        try (Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            
                stmt.setString(1, mothership.getName());
                stmt.setDouble(2, mothership.getCredit());
                stmt.setInt(3, mothership.getTotalHangar());
                stmt.setInt(4, mothership.getUsedHangar());
                stmt.executeQuery();
            } catch (Exception e) {
            System.out.println("Error adding mothership: " + e.getMessage());
        }

    }



}
