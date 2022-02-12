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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Munyaradzi Nyamajiwa
 */
public class MembershipController implements Initializable 
{

    @FXML
    private TextField txtDiocese;
    @FXML
    private TextField txtParish;
    @FXML
    private TextField txtPlace;
    @FXML
    private TextField txtHome;
    @FXML
    private TextField txtSpouse;
    @FXML
    private RadioButton rdbBaptisedYes;
    @FXML
    private ToggleGroup Baptised;
    @FXML
    private RadioButton rdbBaptiseddNo;
    @FXML
    private RadioButton rdbMarriedYes;
    @FXML
    private ToggleGroup Married;
    @FXML
    private RadioButton rdbMarriedNo;
    @FXML
    private TextField txtChildren;
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
    private TableColumn<?, ?> colDiocese;
    @FXML
    private TableColumn<?, ?> colParish;
    @FXML
    private TableColumn<?, ?> colPlace;
    @FXML
    private TableColumn<?, ?> colHome;
    @FXML
    private TableColumn<?, ?> colSpouse;
    @FXML
    private TableColumn<?, ?> colBaptised;
    @FXML
    private TableColumn<?, ?> colMarried;
    @FXML
    private TableColumn<?, ?> colChildren;
    
    private Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
