package application;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Client;
import model.ClientListWrapper;
import view.ClientOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane test;
    /**
     * The data as an observable list of Clients.
     */
    private ObservableList<Client> clientData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        clientData.add(new Client("Hans"));
        clientData.add(new Client("Ruth"));
        clientData.add(new Client("Heinz"));
        clientData.add(new Client("Cornelia"));
        clientData.add(new Client("Werner"));
        clientData.add(new Client("Lydia"));
        clientData.add(new Client("Anna"));
        clientData.add(new Client("Stefan"));
        clientData.add(new Client("Martin"));
    }

    /**
     * Returns the data as an observable list of clients. 
     * @return
     */
    public ObservableList<Client> getClientData() {
        return clientData;
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ToutBois");
        
        // Set the application icon.
       // this.primaryStage.getIcons().add(new Image("/if_Address_Book_Alt_blue_86952.png"));


       // initRootLayout();
        showMainAppView();
        //showClientOverview();
    }
    /**
     * Initializes the root layout and tries to load the last opened
     * client file.
     */
    /*
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try to load last opened person file.
        File file = getPersonFilePath();
        if (file != null) {
            loadPersonDataFromFile(file);
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    /*
    public boolean showPersonEditDialog(Client client) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editer Client");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ClientEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setClient(client);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Opens a dialog to show birthday statistics.
     */
    /*
    public void showBirthdayStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the persons into the controller.
            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Shows the client overview inside the root layout.
     */
    public void showMainAppView(){
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/view/test2.fxml"));
			test = loader.load();
			 ClientOverviewController controller = loader.getController();
	         controller.setMainApp(this);
			Scene scene = new Scene(test);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
		}
    	
    }
    public void showClientOverview() {
        try {
            // Load client overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/Test2.fxml"));
            AnchorPane clientOverview = (AnchorPane) loader.load();
            Scene scene = new Scene(clientOverview);
            primaryStage.setScene(scene);
            // Set person overview into the center of root layout.
            //rootLayout.setCenter(clientOverview);

            // Give the controller access to the main app.
            ClientOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Returns the client file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getClientFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setClientFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("Toutbois - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("Toutbois");
        }
    }
    /**
     * Loads client data from the specified file. The current client data will
     * be replaced.
     * 
     * @param file
     */
    
    public void loadClientDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClientListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            ClientListWrapper wrapper = (ClientListWrapper) um.unmarshal(file);

            clientData.clear();
            clientData.addAll(wrapper.getClients());

            // Save the file path to the registry.
            setClientFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    /**
     * Saves the current client data to the specified file.
     * 
     * @param file
     */
    
    public void saveClientDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClientListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our client data.
            ClientListWrapper wrapper = new ClientListWrapper();
            wrapper.setClients(clientData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setClientFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }
    /**
     * Loads client data from the specified file. The current client data will
     * be replaced.
     * 
     * @param file
     */
   

}
