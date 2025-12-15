import java.beans.PropertyVetoException;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class TableViewHelper {

    public static TableView<Person> createPersonTable(GridPane grid, ObservableList<Person> people, int rowIndex) {
        TableView<Person> tableView = new TableView<>();
        tableView.setItems(people);

        TableColumn<Person, String> nameCol = new TableColumn<>("Ονοματεπώνυμο");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Person, String> phoneCol = new TableColumn<>("Τηλέφωνο");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Person, Integer> ageCol = new TableColumn<>("Ηλικία");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Person, String> countryCol = new TableColumn<>("Χώρα");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Person,String> notesColumn = new TableColumn<>("Σημειωσης");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        tableView.getColumns().addAll(nameCol, emailCol, phoneCol, ageCol, countryCol,notesColumn);

        grid.add(tableView, 0, rowIndex, 2, 1); 
        tableView.setPrefHeight(150);

        return tableView;
    }
}
