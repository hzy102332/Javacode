package chapter14;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
public class SmallButton extends Application{
	public void start (Stage primaryStage) {
		StackPane pane =new StackPane();
		pane.getChildren().add(new Button ("OK"));
		Scene scene = new Scene(pane,300,250);
		primaryStage.setTitle("Button in a pane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
