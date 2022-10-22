package valerie.javafx.javafxproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import valerie.javafx.javafxproject.model.Person;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;
        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Sample JavaFX App");
        //2) Initialize RootLayout
        initRootLayout();
        //3) Display the PersonOperations View
        showPersonOperationsView();
    }
    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Shows the person operations controller inside the root layout.
    public void showPersonOperationsView() {
        try {
            //First, load PersonOperationsView from PersonOperations.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("PersonOperations.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();
            // Set Person Operations controller into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        launch();

    }
}