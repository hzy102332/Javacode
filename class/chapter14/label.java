package chapter14;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
public class label extends Application{
	public void start(Stage primaryStage) {
		Label lb = new Label ("Welcom to WZ");
		Scene sc =new Scene(lb, 400, 200);
		primaryStage.setScene(sc);
		primaryStage.show();
}
	public static void main(String[]args) {
		Application.launch(args);
	}
	}