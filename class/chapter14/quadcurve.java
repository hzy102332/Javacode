package chapter14;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
public class quadcurve extends Application{
	public void start(Stage primaryStage) {
	primaryStage.setTitle("Drawing Text");
	Group g = new Group();
	Scene sc = new Scene(g,500,250,Color.WHITE);
	primaryStage.setScene(sc);
	QuadCurve qc = new QuadCurve();
	qc.setStartX(0.0);qc.setStartY(150.0);
	qc.setEndX(150.0);qc.setEndY(150.0);
	qc.setControlX(75.0);qc.setControlY(0.0);
	g.getChildren().add(qc);
	sc.setRoot(g);
	primaryStage.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
	}