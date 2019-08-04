package financeAppController;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import financeAppController.HelpController;
import financeAppModel.MySQLConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class WelcomeController implements Initializable
{	
	
	@FXML
    private Button Terminate, Help, giris, kayit;
	
	@FXML
    private TextField KayitKullanciAdi,KayitSifre,KayitE_Posta;

    @FXML
    private TextField girisKullaniciAdi,girisSifre;

    @FXML
    private AnchorPane StartSceneRoot;
    
    @FXML
    private StackPane parentContainer;

    private double xOffset=0.0 , yOffset=0.0; // taþýnabilir pencere için mouse click konum saklayýcý deðiþkenler
    
    public Stage StartStage = new Stage();

    public void initialize(URL url, ResourceBundle rb)
    {
    	
    }
    
	public void move(Pane root) // sahnenin taþýnabilir olmasý için
	{
		root.setOnMousePressed(new EventHandler<MouseEvent>() { // taþýnabilir pencere için mouse click durumunda konum
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() { // taþýnabilir pencere
			public void handle(MouseEvent event) {
				StartStage.setX(event.getScreenX()-xOffset);
				StartStage.setY(event.getScreenY()-yOffset);
			}
		});
	}
	
	@FXML
	public void showStartWindow() throws IOException
	{
		FXMLLoader loader  = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/financeAppView/Welcome.fxml").openStream());
		StartStage.initStyle(StageStyle.UNDECORATED);// giriþ ekranýn pencere seçenekleri kapatýyor
		move(root);// kök sahneyi(StartScene) taþýnabilir yapýyoruz
		Scene scene = new Scene(root,1082,584);//(root,(screenWidth/1.8),(screenHeight/1.8))
		scene.getStylesheets().add("/financeAppView/application.css"); 
		//scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
		StartStage.setTitle("Fx Finance");
		StartStage.setScene(scene);
		//StartScene.setResizable(false);
		StartStage.getIcons().add(new Image(WelcomeController.class.getResourceAsStream("/financeAppView/greed.png")));
		StartStage.show();
	}
	
	@FXML
	public void hideStartWindow()
	{
	   //StartScene.hide(); // splash penceresi belli zaman sonra kapatýlacak
	   StartStage.close();// splash penceresi belli zaman sonra kapatýlacak
	}

	@FXML
    void click(ActionEvent event) {
    	try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI("https://github.com/recepkarademir/FxFinance");
			  desktop.browse(oURL);
			} catch (Exception e) {
			  e.printStackTrace();
			}
    }
	
	@FXML
	public void MySQLConnect(ActionEvent event) throws IOException
	{
	    	MySQLConnect GirisKontrol = new MySQLConnect();
	    	String StrgirisKullaniciAdi,StrgirisSifre;
	    	StrgirisKullaniciAdi  =girisKullaniciAdi.getText();
	    	StrgirisSifre		  =girisSifre.getText();
	    	if(GirisKontrol.GirisKontrol(StrgirisKullaniciAdi,StrgirisSifre))
	    	{
	    		Dashboard();
	    	}
	    	else
	    	{
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Giriþ Baþarýsýz");
	    		alert.setHeaderText(null);
	    		alert.setContentText("Kullanýcý adýnýzý veya parolanýzý doðru girmediniz.\nLütfen sisteme kayýtlý olduðunuzdan emin olun !");
	    		alert.showAndWait();
	    	}
	}
	
	@FXML
	public void Dashboard() throws IOException
	{
		DashController dash = new DashController();
		dash.LoadScene(giris,StartSceneRoot,parentContainer);
	}

	public void Help(ActionEvent event) throws IOException
	{
		HelpController HelpWindow = new HelpController();
		HelpWindow.HelpShow();
	}
		
	
	@FXML
	public void Terminate(ActionEvent event) throws IOException
	{
	    StartStage.close();
	    Platform.exit();
	    System.exit(0);
	}
}