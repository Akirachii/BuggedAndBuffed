public class Main {
    public static void main(String[] args) {
        MothershipDAO mothershipDAO = new MothershipDAO();

        // 1. Create a new mothership
        Mothership novaQueen = new Mothership(0, "Nova Queen", 20000.0, 50, 0);
        mothershipDAO.addMothership(novaQueen);
        System.out.println("🌟 Added new mothership: Nova Queen");

        // 2. Fetch all motherships
        System.out.println("\n🚀 All Motherships in the Galaxy:");
        for (Mothership m : mothershipDAO.getAllMotherships()) {
            System.out.println(m);
        }

        // 3. Get one by ID (let's pretend ID is 1 for now)
        System.out.println("\n🛰️ Fetching mothership with ID 1:");
        Mothership fetched = mothershipDAO.getMothership(1);
        if (fetched != null) {
            System.out.println("Found: " + fetched);
        } else {
            System.out.println("😢 No mothership found with ID 1");
        }

        // 4. Update credit and hangar (spend money, add ships, etc)
        if (fetched != null) {
            fetched.removeCredit(5000);
            fetched.addCredit(1500);
            fetched.addShip(new Ship(101, fetched.getId(), "Stinger", new ShipType("Fighter", 2, 1000)));
            mothershipDAO.updaMothership(fetched);
            System.out.println("\n💸 Updated mothership after trade and docking:");
            System.out.println(fetched);
        }

        System.out.println("\n✨ Mothership operations complete.");
    }
}
