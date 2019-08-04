package financeAppController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HelpController implements Initializable
{
	Stage HelpStage = new Stage();
	
	
	
	private double xOffset=0.0;
    private double yOffset=0.0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	}
	
	

    @FXML
    private Hyperlink Location;

    
	
	public void HelpShow() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/financeAppview/Help.fxml"));
	    Parent root =(Parent) fxmlLoader.load();
	    HelpStage.setScene(new Scene(root)); 
	    HelpStage.setResizable(false);
	    HelpStage.getIcons().add(new Image(WelcomeController.class.getResourceAsStream("/financeAppview/greed.png")));
	    root.getStylesheets().add("/financeAppView/application.css"); 
	    root.setOnMousePressed(new EventHandler<MouseEvent>() { // mouse pencereye týklayýp süreklenince pencere taþýnacak
	    public void handle(MouseEvent event)
	    {
	    		xOffset = event.getSceneX();
	    		yOffset = event.getSceneY();
	    }
	    });
	    root.setOnMouseDragged(new EventHandler<MouseEvent>()
	    {	// mouse pencereye týklayýp süreklenince pencere taþýnacak
	    	public void handle(MouseEvent event)
	    	{
	    		HelpStage.setX(event.getScreenX()-xOffset-8);
	    		HelpStage.setY(event.getScreenY()-yOffset-30);
	    	}
	    });
	    HelpStage.show();
	    
	}
}
