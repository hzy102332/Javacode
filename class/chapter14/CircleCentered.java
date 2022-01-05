package chapter14;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class CircleCentered extends Application{
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Circle c = new Circle();
		c.centerXProperty().bind(pane.widthProperty().divide(2));
		c.centerYProperty().bind(pane.heightProperty().divide(2));
		c.setRadius(50);
		c.setStroke(Color.BLACK);
		c.setFill(Color.RED);
		pane.getChildren().add(c);
		Scene s = new Scene(pane,200,200);
		primaryStage.setTitle("ShowCircleCentered");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	public static void main(String []args) {
		Application.launch(args);
	}
}
