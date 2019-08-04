package financeAppController;

import javafx.application.Application;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage)
	{
		
		try
		{
			Pane root = FXMLLoader.load(getClass().getResource("/financeAppview/SplashScreen.fxml"));
			Scene scene = new Scene(root,582,501);
			scene.getStylesheets().add(getClass().getResource("/financeAppview/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);// splash ekraný pencere seçenekleri kapatýr.
			//primaryStage.initStyle(StageStyle.TRANSPARENT); // splash ekraný pencere seçenekleri kapatýr.
			primaryStage.centerOnScreen();// splash baþlangýç pozisyonunu ortalayabilmek için
			primaryStage.getIcons().add(new Image(WelcomeController.class.getResourceAsStream("/financeAppview/greed.png")));
			primaryStage.setAlwaysOnTop(false);
			primaryStage.show();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		WelcomeController splash = new WelcomeController();
		splash.hideStartWindow();// Giriþ ekraný splashten önce gizlendi.
		
		PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(2)); // 2sn splash ekraný gözükecek
		splashScreenDelay.setOnFinished(f ->
		{
		    primaryStage.hide();
		    try
		    {
				splash.showStartWindow();
			}
		    catch (IOException e)
		    {
				e.printStackTrace();
			}
		});
		splashScreenDelay.playFromStart();
	}

	public static void main(String[] args)
	{	
		Application.launch(args);
	}
}
