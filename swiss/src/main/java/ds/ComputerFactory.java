package ds;

public class ComputerFactory {

    Computer getComp(String type) {

        if (type.equalsIgnoreCase("PC")) {
            return new PC();
        }
        if (type.equalsIgnoreCase("SERVER")) {
            return new Server();
        }
        return null;
    }
}
