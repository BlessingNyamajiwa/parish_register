package parishregister;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeathsController implements Initializable 
{
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtSurname;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtNextOfKin;
    @FXML
    private DatePicker dtpDeathDate;
    @FXML
    private DatePicker dtpBurialDate;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDashboard;
    @FXML
    private TableView<?> tblDisplay;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colFirstname;
    @FXML
    private TableColumn<?, ?> colSurname;
    @FXML
    private TableColumn<?, ?> colAge;
    @FXML
    private TableColumn<?, ?> colNextOfKin;
    @FXML
    private TableColumn<?, ?> colDeathDate;
    @FXML
    private TableColumn<?, ?> colBurialDate;
    
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
        
    }

    @FXML
    private void clearDetails(ActionEvent event) 
    {
        
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
