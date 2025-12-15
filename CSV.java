import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class CSV {
    //μεθοδος savetocsv 
    public void savetocsv(List<Person> people) {
        //διμιουργια του αρχειου data.csv
        try (FileWriter fw = new FileWriter("data.csv", true);
             PrintWriter writer = new PrintWriter(fw)) {
            //διμιουργια γραμμης CSV
            for (Person p : people) {
                writer.append(p.getName()).append(",");
                writer.append(p.getEmail()).append(",");
                writer.append(p.getPhone()).append(",");
                writer.append(String.valueOf(p.getAge())).append(",");
                writer.append(p.getCountry()).append(",");
                writer.append(p.getNotes().replace(",", ";")).append("\n");
            }

            System.out.println("Τα δεδομένα αποθηκεύτηκαν στο data.csv");

        } catch (Exception e) {
            System.err.println("Σφάλμα κατά την αποθήκευση!");
            e.printStackTrace();
        }
    }
}
