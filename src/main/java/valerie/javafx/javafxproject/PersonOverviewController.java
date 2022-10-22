package valerie.javafx.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import valerie.javafx.javafxproject.MainApp;
import valerie.javafx.javafxproject.model.Person;
import valerie.javafx.javafxproject.util.DateUtil;


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

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());

            // We convert the birthday into a String by using the DateUtil helper class
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }
}
