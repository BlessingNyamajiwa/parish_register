package parishregister;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static parishregister.GenericMethods.warningBox;

/**
 * FXML Controller class
 *
 * @author Munyaradzi Nyamajiwa
 */
public class ConfirmationRegisterController implements Initializable {

    @FXML
    private Label lblHeading;
    @FXML
    private Label lblFirstName;
    @FXML
    private TextField txtFirstName;
    @FXML
    private Label lblSurname;
    @FXML
    private TextField txtSurname;
    @FXML
    private Label lblFathers;
    @FXML
    private TextField txtFathers;
    @FXML
    private Label lblMothers;
    @FXML
    private TextField txtMothers;
    @FXML
    private Label lblPlace;
    @FXML
    private TextField txtPlace;
    @FXML
    private Label lblDate;
    @FXML
    private DatePicker dtpDate;
    @FXML
    private Label lblSponsor;
    @FXML
    private TextField txtSponsor;
    @FXML
    private Label lblLocation;
    @FXML
    private TextField txtBaptismLocation;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnDashboard;
    @FXML
    private TableView<?> tblDisplay;
    @FXML
    private TableColumn<?, ?> colFirstName;
    @FXML
    private TableColumn<?, ?> colSurname;
    @FXML
    private TableColumn<?, ?> colFathersName;
    @FXML
    private TableColumn<?, ?> colMothersName;
    @FXML
    private TableColumn<?, ?> colPlace;
    @FXML
    private TableColumn<?, ?> colDate;
    @FXML
    private TableColumn<?, ?> colSponsor;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void saveDetails(ActionEvent event) 
    {
   
        if(txtFirstName.getText().equals("") || txtSurname.getText().equals("") || txtFathers.getText().equals("") || txtMothers.getText().equals("") || txtPlace.getText().equals("") ||
                dtpDate.equals("") || txtSponsor.getText().equals("") || txtBaptismLocation.getText().equals(""))
        {
            warningBox("Please fill in all fields", "WARNING", "Incomplete Details");
        }
        else
        {
            String firstName, surname, fathersName, mothersName, place, sponsor, baptismLocation;
            firstName = txtFirstName.getText();
            surname = txtSurname.getText();
            fathersName = txtFathers.getText();
            mothersName = txtMothers.getText();
            place = txtPlace.getText();
            sponsor = txtSponsor.getText();
            baptismLocation = txtBaptismLocation.getText();
            // dtpDate.setValue(LocalDate.now());
            
            Connection conn = DBConnection.getConnection();
        }
    }

    @FXML
    private void clearTextBoxes(ActionEvent event) 
    {
        txtFirstName.setText("");
        txtSurname.setText("");
        txtFathers.setText("");
        txtMothers.setText("");
        txtPlace.setText("");
        txtSponsor.setText("");
        txtBaptismLocation.setText("");
    }

    @FXML
    private void backToDash(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("design/ParishRegisterLogin.fxml"));
        root = loader.load();
        
        // LoginController loginController = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("EquipTrack | Admin Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
