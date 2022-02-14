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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MarriageController implements Initializable 
{
    @FXML
    private TextField txtBrideName;
    @FXML
    private TextField txtGroomName;
    @FXML
    private TextField txtPlace;
    @FXML
    private DatePicker dtpMarriedDate;
    @FXML
    private TextField txtWitness1;
    @FXML
    private TextField txtWitness2;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDashboard;
    @FXML
    private TableView<Marriage> tblDisplay;
    @FXML
    private TableColumn<Marriage, Integer> colID;
    @FXML
    private TableColumn<Marriage, String> colBridesName;
    @FXML
    private TableColumn<Marriage, String> colGroomsName;
    @FXML
    private TableColumn<Marriage, String> colPlace;
    @FXML
    private TableColumn<Marriage, String> colMarried;
    @FXML
    private TableColumn<Marriage, String> colWitness1;
    @FXML
    private TableColumn<Marriage, String> colWitness2;
    
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
    
    private void loadTableData()
    {
        Connection conn = DBConnection.getConnection();
        ObservableList<Marriage> list = FXCollections.observableArrayList();
        
        // Setting cell value factories to populate table with database query result set
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBridesName.setCellValueFactory(new PropertyValueFactory<>("bride"));
        colGroomsName.setCellValueFactory(new PropertyValueFactory<>("grooms_name"));
        colPlace.setCellValueFactory(new PropertyValueFactory<>("place"));
        colMarried.setCellValueFactory(new PropertyValueFactory<>("married_date"));
        colWitness1.setCellValueFactory(new PropertyValueFactory<>("witness1"));
        colWitness2.setCellValueFactory(new PropertyValueFactory<>("witness2"));
        
        try
        {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM marriage");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                list.add(new Marriage(rs.getInt("id"), rs.getString("bride"), rs.getString("grooms_name"), rs.getString("place"), rs.getString("married_date"),
                rs.getString("witness1"), rs.getString("witness2")));
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

    @FXML
    private void saveDetails(ActionEvent event) 
    {
        
    }

    @FXML
    private void clearDetails(ActionEvent event) 
    {
        
    }

    @FXML
    private void btnDashboard(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("design/ConfirmationRegister.fxml"));
        root = loader.load();
        
        // LoginController loginController = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("EquipTrack | Admin Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
