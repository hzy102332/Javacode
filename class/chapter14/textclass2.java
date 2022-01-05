package chapter14;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class textclass2 extends Application{
	public void start(Stage primaryStage) {
	primaryStage.setTitle("Drawing Text");
	Group g = new Group();
	Scene sc = new Scene(g,500,250,Color.WHITE);
	Group g2 =new Group();
	Text text= new Text();
	text.setCache(true);
	text.setX(10.0);text.setY(70.0);
	text.setFill(Color.BLUE);text.setText("WenZhou City");
	text.setFill(Color.RED);
	text.setFont(Font.font(null, FontWeight.BOLD,32));
	g.getChildren().add(text);
	primaryStage.setScene(sc);
	primaryStage.show();
}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
