package chapter14;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Circle1 extends Application{
	public void start (Stage primaryStage) {
		Pane p =new Pane();
		Circle circle =new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStroke(Color.RED);
		circle.setFill(null);
		p.getChildren().add(circle);
		Scene sc= new Scene(p,400,200);
		primaryStage.setTitle("Circle Drowing");
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
