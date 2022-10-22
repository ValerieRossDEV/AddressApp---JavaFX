package valerie.javafx.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import valerie.javafx.javafxproject.MainApp;
import valerie.javafx.javafxproject.model.Person;


public class PersonOverviewController {

     @FXML
     TableView<Person> personTable;
     @FXML
     TableColumn<Person, String> firstNameColumn;
     @FXML
     TableColumn<Person, String> lastNameColumn;

     @FXML
     Label firstNameLabel;
     @FXML
     Label lastNameLabel;
     @FXML
     Label streetLabel;
     @FXML
     Label postalCodeLabel;
     @FXML
     Label cityLabel;
     @FXML
     Label birthdayLabel;

        // Reference to the main application.
    private MainApp mainApp;

        /**
         * The constructor.
         * The constructor is called before the initialize() method.
         */
        public PersonOverviewController() {
        }

        /**
         * Initializes the controller class. This method is automatically called
         * after the fxml file has been loaded.
         */
        @FXML
        private void initialize() {
            // Initialize the person table with the two columns.
            firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
            lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        }

        /**
         * Is called by the main application to give a reference back to itself.
         *
         * @param mainApp
         */
        public void setMainApp(MainApp mainApp) {
            this.mainApp = mainApp;

            // Add observable list data to the table
            personTable.setItems(mainApp.getPersonData());
        }
}
