package chapter14;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class ShowCircle extends Application{
	public void start(Stage primatyStage) {
		Circle circle = new Circle();
		circle.setCenterX(300);
		circle.setCenterY(300);
		circle.setRadius(100);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		Scene scene =new Scene(pane,600,600);
		primatyStage.setTitle("ShowCircle");
		primatyStage.setScene(scene);
		primatyStage.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
