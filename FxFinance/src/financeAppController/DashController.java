package financeAppController;

import financeAppModel.XmlData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class DashController implements Initializable{
	

	@FXML
	public Stage Stage = new Stage();
    @FXML
    private Label kAdi;
	@FXML
	public Button chart;
	
    @FXML
    private StackPane parentContainer;
    
    @FXML
    public AnchorPane StartSceneRoot;

	@FXML
	private Button GoBack,Terminate;
	 
    public void initialize(URL url, ResourceBundle rb)
    {
    	kAdi.setText("fvdfbdfb  fgfrgbfgbfg");
    }


	public void LoadScene(Button giris, AnchorPane StartSceneRoot, StackPane parentContainer) throws IOException
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("/financeAppView/Dashboard.fxml"));
	    Scene scene = giris.getScene();
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
	 void PieChart(ActionEvent event) throws IOException
		 {Parent root = FXMLLoader.load(getClass().getResource("/financeAppView/pieChart.fxml"));
	     Scene scene = GoBack.getScene();
	     root.translateXProperty().set(scene.getWidth());
	
	     StackPane parentContainer = (StackPane) GoBack.getScene().getRoot();
	     parentContainer.getChildren().add(root);
	
	     Timeline timeline = new Timeline();
	     KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
	     KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	     timeline.getKeyFrames().add(kf);
	     timeline.setOnFinished(t -> {
	         parentContainer.getChildren().remove(StartSceneRoot);
	     });
	     timeline.play();
	     /*
		 PieChartController chartObj = new PieChartController();
		 chartObj.Chart(chart,StartSceneRoot,parentContainer);*/
	 }
	
	@FXML
	void LineChart(ActionEvent event) throws Exception{
		
		XmlRead();
		 Parent root = FXMLLoader.load(getClass().getResource("/financeAppView/lineChart.fxml"));
	     Scene scene = GoBack.getScene();
	     root.translateXProperty().set(scene.getWidth());
	
	     StackPane parentContainer = (StackPane) GoBack.getScene().getRoot();
	     parentContainer.getChildren().add(root);
	
	     Timeline timeline = new Timeline();
	     KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
	     KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	     timeline.getKeyFrames().add(kf);
	     timeline.setOnFinished(t -> {
	         parentContainer.getChildren().remove(StartSceneRoot);
	     });
	     timeline.play();
	}
	 
	public void XmlRead() throws Exception {
	       
        
        
        

  	  DocumentBuilderFactory domFactory = 
  	  DocumentBuilderFactory.newInstance();
  	  domFactory.setNamespaceAware(true); 
  	  DocumentBuilder builder = domFactory.newDocumentBuilder();
  	  Document doc = builder.parse(new URL("C:\\Users\\RCP\\Desktop\\sc.xml").openStream());
  	  XPath xpath = XPathFactory.newInstance().newXPath();
  	   // XPath Query for showing all nodes value
  	  XPathExpression expr = xpath.compile("//person/*/text()");

  	  Object result = expr.evaluate(doc, XPathConstants.NODESET);
  	  NodeList nodes = (NodeList) result;
  	  for (int i = 0; i < nodes.getLength(); i++) {
  	 System.out.println(nodes.item(i).getNodeValue()); 
  	  }

	   
  	
  	   
  
  
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
    	Parent root = FXMLLoader.load(getClass().getResource("/financeAppView/Welcome.fxml"));
        Scene scene = GoBack.getScene();
        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) GoBack.getScene().getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(StartSceneRoot);
        });
        timeline.play();
    }
   
}
