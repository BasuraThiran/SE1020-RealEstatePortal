import com.realestate.models.ResidentialProperty;
import com.realestate.utils.FileHandler;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Create a property
        ResidentialProperty myHouse = new ResidentialProperty("101", "Colombo", 50000.00, 3);
        ResidentialProperty myAppt = new ResidentialProperty("102", "Kandy", 25000.00, 2);

        // 2. Save them to the text file (CREATE)
        System.out.println("Saving properties...");
        FileHandler.saveProperty(myHouse.toFileFormat());
        FileHandler.saveProperty(myAppt.toFileFormat());

        // 3. Read them back from the text file (READ)
        System.out.println("\nReading from properties.txt:");
        List<String> savedData = FileHandler.getAllProperties();

        for (String dataLine : savedData) {
            System.out.println(dataLine);
        }
    }
}
