package view;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Client;


public class ClientOverviewController {
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nomEnseigneColumn;
    @FXML
    private TableColumn<Client, Number> idClientColumn;

    @FXML
    private Label idClientLabel;
    @FXML
    private Label enseigneLabel;
    @FXML
    private Label siretLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label telLabel;
    @FXML
    private Label numRueLabel;
    @FXML
    private Label adresseLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label villeLabel;
    @FXML
    private Label paysLabel;
    @FXML
    private Label suiviLabel;
    @FXML
    private Label nbCommandeLabel;
   

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ClientOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	nomEnseigneColumn.setCellValueFactory(cellData -> cellData.getValue().nomEnseigneProperty());
    	//nomEnseigneColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	idClientColumn.setCellValueFactory(cellData -> cellData.getValue().idClientProperty());
    	//idClientColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        clientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }


    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        clientTable.setItems(mainApp.getClientData());
    }
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Client client) {
        if (client != null) {
            // Fill the labels with info from the client object.
        	idClientLabel.setText(Integer.toString(client.getIdClient()));
        	enseigneLabel.setText(client.getNomEnseigne());
        	siretLabel.setText(client.getSiret());
        	mailLabel.setText(client.getMail());
        	telLabel.setText(client.getTel());
        	numRueLabel.setText(Integer.toString(client.getNRue()));
        	adresseLabel.setText(client.getAdresse());
        	codePostalLabel.setText(Integer.toString(client.getCodePostal()));
        	villeLabel.setText(client.getVille());
        	paysLabel.setText(client.getPays());
        	suiviLabel.setText(Integer.toString(client.getIdRepresentant()));
        	nbCommandeLabel.setText(Integer.toString(client.getNbCommande()));
          
        } else {
            // Person is null, remove all the text.
        	idClientLabel.setText("");
        	enseigneLabel.setText("");
        	siretLabel.setText("");
        	mailLabel.setText("");
        	telLabel.setText("");
        	numRueLabel.setText("");
        	adresseLabel.setText("");
        	codePostalLabel.setText("");
        	villeLabel.setText("");
        	paysLabel.setText("");
        	suiviLabel.setText("");
        	nbCommandeLabel.setText("");
        	
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    /*
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = clientTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            clientTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    */
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    /*
    @FXML
    private void handleNewPerson() {
        Client tempPerson = new Client();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }
    */

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    /*
    @FXML
    private void handleEditPerson() {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedClient);
            if (okClicked) {
                showPersonDetails(selectedClient);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

*/

}
