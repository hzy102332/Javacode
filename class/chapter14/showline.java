package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class showline extends Application{
	public void start (Stage primaryStage) {
		Line ln = new Line();
		Pane pane = new Pane();
		pane.getChildren().add(ln);
		Scene scene =new Scene(pane,300,300);
		ln.setStartX(50);
		ln.setStartY(150);
		ln.setEndX(250);
		ln.setEndY(150);
		primaryStage.setTitle("Line");
		primaryStage.show();
		primaryStage.setScene(scene);
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
