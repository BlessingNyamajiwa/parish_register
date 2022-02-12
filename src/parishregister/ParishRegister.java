package parishregister;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParishRegister extends Application 
{
    
    @Override
    public void start(Stage loginWindow) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("design/ParishRegisterLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        loginWindow.setScene(scene);
        loginWindow.setTitle("Parish Register | Login");
        loginWindow.setResizable(false);
        loginWindow.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
