import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;
    private TextField ageField;
    private ComboBox<String> countryBox;
    private TextArea notesArea;
    private Label messageLabel;
    private ObservableList<Person> people = FXCollections.observableArrayList();
    private TableView<Person> tableView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Φόρμα");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Ονοματεπώνυμο
        Label nameLabel = new Label("Ονοματεπώνυμο");
        nameField = new TextField();
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        // Email
        Label emailLabel = new Label("Email");
        emailField = new TextField();
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);

        // Τηλέφωνο
        Label phoneLabel = new Label("Τηλέφωνο");
        phoneField = new TextField();
        grid.add(phoneLabel, 0, 2);
        grid.add(phoneField, 1, 2);

        // Ηλικία
        Label ageLabel = new Label("Ηλικία");
        ageField = new TextField();
        grid.add(ageLabel, 0, 3);
        grid.add(ageField, 1, 3);

        // Χώρα
        Label countryLabel = new Label("Χώρα");
        countryBox = new ComboBox<>();
        countryBox.getItems().addAll("Ελλάδα", "Κύπρος");
        grid.add(countryLabel, 0, 4);
        grid.add(countryBox, 1, 4);

        // Σημειώσεις
        Label notesLabel = new Label("Σημειώσεις");
        notesArea = new TextArea();
        notesArea.setPrefRowCount(4);
        grid.add(notesLabel, 0, 5);
        grid.add(notesArea, 1, 5);

        // Κουμπί υποβολής
        Button submitButton = new Button("Υποβολή");
        messageLabel = new Label();
        grid.add(submitButton, 1, 6);
        grid.add(messageLabel, 1, 7);
        submitButton.setOnAction(e -> validateForm());

        // TableView
        tableView = TableViewHelper.createPersonTable(grid, people, 8);

        // Κουμπί αποθήκευσης CSV
        Button saveButton = new Button("Αποθήκευση σε CSV");
        grid.add(saveButton, 1, 9);
        saveButton.setOnAction(e -> {
            CSV csvSaver = new CSV();
            csvSaver.savetocsv(people);
            messageLabel.setText("Τα δεδομένα αποθηκεύτηκαν στο data.csv");
        });
        //dark mode button
        Button darkModeButton = new Button("Dark Mode");
        grid.add(darkModeButton, 0, 6);

        Scene scene = new Scene(grid, 700, 700);

        String css = getClass().getResource("style.css").toExternalForm();

        String darkCss = getClass().getResource("darkstyle.css").toExternalForm();

        scene.getStylesheets().add(css);

        darkModeButton.setOnAction(e -> {
        if (scene.getStylesheets().contains(css)) {
            scene.getStylesheets().remove(css);
            scene.getStylesheets().add(darkCss);
            darkModeButton.setText("Light Mode");
        } else {
            scene.getStylesheets().remove(darkCss);
            scene.getStylesheets().add(css);
            darkModeButton.setText("Dark Mode");
        }
    });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // μεθοδος για ελεγχο τον στοιχειον
    private void validateForm() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String ageText = ageField.getText().trim();
        String country = countryBox.getValue();
        
        //δομες ελεγχου
        if (name.isEmpty()) {
            messageLabel.setText("Παρακαλώ εισάγετε το ονοματεπώνυμο σας");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            messageLabel.setText("Παρακαλώ εισάγετε έγκυρο email");
        } else if (phone.isEmpty() || !phone.matches("\\d{10}")) {
            messageLabel.setText("Παρακαλώ εισάγετε σωστό 10 ψηφίο τηλέφωνο");
        } else if (ageText.isEmpty()) {
            messageLabel.setText("Παρακαλώ εισάγετε την ηλικία σας");
        } else {
            try {
                int age = Integer.parseInt(ageText);
                if (age <= 0) {
                    messageLabel.setText("Παρακαλώ εισάγετε ηλικία μεγαλύτερη από 0");
                } else if (country == null || country.isEmpty()) {
                    messageLabel.setText("Παρακαλώ επιλέξτε μια χώρα");
                } else {
                    Person p = new Person(name, email, phone, age, country, notesArea.getText());
                    people.add(p);
                    messageLabel.setText("Η καταχώριση έγινε");
                }
            } catch (NumberFormatException e) {
                messageLabel.setText("Η ηλικία πρέπει να είναι αριθμός");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
