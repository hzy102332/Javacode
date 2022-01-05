package chapter14;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
public class changecolor extends Application{
	public void start(Stage primaryStage) {
		Group gp = new Group ();
		Scene sc = new Scene(gp, 600, 300);
		sc.setFill(Color.BLUE);
		primaryStage.setTitle("Group Demo");
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	public static void main(String []args) {
		Application.launch(args);
	}
}
