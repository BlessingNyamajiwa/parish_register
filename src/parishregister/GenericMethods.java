package parishregister;

import javafx.scene.control.Alert;

public class GenericMethods 
{
    public static void errorBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    public static void warningBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    public static void infoBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    public static void confirmBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
