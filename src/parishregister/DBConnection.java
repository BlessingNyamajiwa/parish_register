package parishregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class DBConnection
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/parish_register";
    
    public static Connection getConnection()
    {
        Connection conn;
        try
        {
            conn = DriverManager.getConnection(DB_URL,"root","");
            // infoBox("Connection Established", "Success", "Database Connection");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            if(e.getErrorCode() == 0)
            {
                
            }
            return null;
        }
        return conn;
    }
    
    public static void infoBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
