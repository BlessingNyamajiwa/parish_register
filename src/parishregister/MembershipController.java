package parishregister;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static parishregister.GenericMethods.warningBox;

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
    private ToggleGroup baptised;
    @FXML
    private RadioButton rdbBaptiseddNo;
    @FXML
    private RadioButton rdbMarriedYes;
    @FXML
    private ToggleGroup married;
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
    private TableView<Membership> tblDisplay;
    @FXML
    private TableColumn<Membership, Integer> colID;
    @FXML
    private TableColumn<Membership, String> colDiocese;
    @FXML
    private TableColumn<Membership, String> colParish;
    @FXML
    private TableColumn<Membership, String> colPlace;
    @FXML
    private TableColumn<Membership, String> colHome;
    @FXML
    private TableColumn<Membership, String> colSpouse;
    @FXML
    private TableColumn<Membership, String> colBaptised;
    @FXML
    private TableColumn<Membership, String> colMarried;
    @FXML
    private TableColumn<Membership, Integer> colChildren;
    
    // private ObservableList data;
    
    private Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        loadTableData();
    }    

    @FXML
    private void saveDetails(ActionEvent event) 
    {
        if(txtDiocese.getText().equals("") || txtParish.getText().equals("") || txtPlace.getText().equals("") || txtHome.getText().equals("") || 
                txtSpouse.getText().equals("") || baptised.getSelectedToggle().equals(false) || married.getSelectedToggle().equals(false) ||
                txtChildren.getText().equals(""))
        {
            warningBox("Please fill in all fields","WARNING","Incomplete fields");
        }
        else
        {
            Connection conn = DBConnection.getConnection();
        }
    }

    @FXML
    private void clearDetails(ActionEvent event) 
    {
        txtDiocese.setText("");
        txtParish.setText("");
        txtPlace.setText("");
        txtHome.setText("");
        txtChildren.setText("");
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
    
    private void loadTableData()
    {
        Connection conn = DBConnection.getConnection();
        ObservableList<Membership> list = FXCollections.observableArrayList();
        
        // Setting cell value factories to populate table with database query result set
        colDiocese.setCellValueFactory(new PropertyValueFactory<>("colDiocese"));
        colParish.setCellValueFactory(new PropertyValueFactory<>("colParish"));
        colPlace.setCellValueFactory(new PropertyValueFactory<>("colPlace"));
        colHome.setCellValueFactory(new PropertyValueFactory<>("colHome"));
        colSpouse.setCellValueFactory(new PropertyValueFactory<>("colSpouse"));
        colBaptised.setCellValueFactory(new PropertyValueFactory<>("colBaptised"));
        colMarried.setCellValueFactory(new PropertyValueFactory<>("colMarried"));
        colChildren.setCellValueFactory(new PropertyValueFactory<>("colChildren"));
        
        try
        {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM membership");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                list.add(new Membership(rs.getInt("id"), rs.getString("diocese"), rs.getString("parish"), rs.getString("place"), rs.getString("home"),
                rs.getString("spouse"), rs.getString("baptised"), rs.getString("married"), rs.getInt("children")));
            }
            
            // Setting table data
            tblDisplay.setItems(list);
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
