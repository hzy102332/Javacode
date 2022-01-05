package chapter14;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
public class OkButton extends Application{
	public void start (Stage primaryStage) {
		Button btok=new Button("OK");
		Scene scene=new Scene(btok,300,200);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
