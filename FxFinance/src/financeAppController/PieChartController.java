package financeAppController;

import javafx.collections.FXCollections;  
import javafx.collections.ObservableList;
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.chart.PieChart; 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class PieChartController implements Initializable
{
    @FXML
    private Button Terminate, GoBack; // Butonlarýn ID leri
      
    @FXML
    private AnchorPane Pie;

    @FXML
    public Stage Stage = new Stage();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	
    	      
    }  
    @FXML
    private PieChart piechart;

    @FXML
    private Button handleButton1Action;

    @FXML
    private Button handleButton2Action;
    @FXML
    private void handleButton1Action(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("January", 100),
                    new PieChart.Data("February", 200),
                    new PieChart.Data("March", 0),
                    new PieChart.Data("April", 0),
                    new PieChart.Data("May", 110),
                    new PieChart.Data("June", 300),
                    new PieChart.Data("July", 111),
                    new PieChart.Data("August", 0),
                    new PieChart.Data("September", 75),
                    new PieChart.Data("October", 55),
                    new PieChart.Data("November", 225),
                    new PieChart.Data("December", 0));
         
        piechart.setTitle("Monthly Record");
        piechart.setData(pieChartData);
    }
     
    @FXML
    private void handleButton2Action(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("Sunday", 30),
                    new PieChart.Data("Monday", 45),
                    new PieChart.Data("Tuesday", 70),
                    new PieChart.Data("Wednesday", 97),
                    new PieChart.Data("Thursday", 100),
                    new PieChart.Data("Friday", 80),
                    new PieChart.Data("Saturday", 10));
         
        piechart.setTitle("Weekly Record");
        piechart.setData(pieChartData);
    }
     
    @FXML
    private void handleButtonClearAction(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList();
        piechart.setTitle("jkkj");
        piechart.setData(pieChartData);
    }
        
    @FXML
	public void Terminate(ActionEvent event) throws IOException
	{
	    Stage.close();
	    Platform.exit();
	    System.exit(0);
	}

    @FXML
    public void GoBack(ActionEvent event) throws IOException
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
            parentContainer.getChildren().remove(Pie);
        });
        timeline.play();
    	
    }
    
}