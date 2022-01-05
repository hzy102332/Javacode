package chapter14;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class textclass extends Application{
	public void start(Stage primaryStage) {
	primaryStage.setTitle("Drawing Text");
	Group g = new Group();
	Scene sc = new Scene(g,500,250,Color.WHITE);
	Text text= new Text(100,100,"WenZhou City");
	text.setFill(Color.rgb(30, 50, 80, 0.99));
//	set angle of text
	text.setRotate(60);
	g.getChildren().add(text);
	primaryStage.setScene(sc);
	primaryStage.show();
}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
