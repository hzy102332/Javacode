package chapter14;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class showrectangle extends Application{
	public void start (Stage primaryStage) {
		Line l1 = new Line();
		Line l2 = new Line();
		Line l3 = new Line();
		Pane pane = new Pane();
		pane.getChildren().add(l1);
		pane.getChildren().add(l2);
		pane.getChildren().add(l3);
		Scene scene =new Scene(pane,300,300);
		l1.setStartX(50);  l1.setStartY(200); l1.setEndX(250); l1.setEndY(200);
		l2.setStartX(50);  l2.setStartY(200); l2.setEndX(150); l2.setEndY(100);
		l3.setStartX(150); l3.setStartY(100); l3.setEndX(250); l3.setEndY(200);
		primaryStage.setTitle("Lines");
		primaryStage.show();
		primaryStage.setScene(scene);
	}
	public static void main (String[]args) {
		Application.launch(args);
	}
		
}
