package financeAppController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class LineChartController implements Initializable
{
	
	private Button GoBack;
	
	
	@FXML
	public Stage Stage = new Stage();
	
	@FXML
    private AnchorPane OcrPhoto;
	
	
    public void initialize(URL url, ResourceBundle rb)
    {
    
    }
    
	
	
	public void OcrPhotoChoose(Button File, AnchorPane StartSceneRoot, StackPane parentContainer) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("/financeAppView/BarChart.fxml"));
	    Scene scene = File.getScene();
	    root.translateYProperty().set(scene.getHeight());
	    parentContainer.getChildren().add(root);

	    Timeline timeline = new Timeline();
	    KeyValue keyval = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
	    KeyFrame keyfr = new KeyFrame(Duration.seconds(1), keyval);
	    timeline.getKeyFrames().add(keyfr);
	    timeline.setOnFinished(t -> {
	        parentContainer.getChildren().remove(StartSceneRoot);
	    });
	    timeline.play();
	}

	@FXML
	public void Terminate(ActionEvent event) throws IOException
	{
	    Stage.close();
	    Platform.exit();
	    System.exit(0);
	}
	
	
	
	@FXML
    public void GoBack(ActionEvent event) throws IOException// (Önceki) Giriþ sahnesine döner.
    {
		
    	Parent root = FXMLLoader.load(getClass().getResource("/financeAppView/Dashboard.fxml"));
        Scene scene = GoBack.getScene();
        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) GoBack.getScene().getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(OcrPhoto);
        });
        timeline.play();
    }
}
