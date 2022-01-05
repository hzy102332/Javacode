package Task;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
public class DrawingText extends Application{
	public void start (Stage ps) {
		Group g = new Group();
		Scene sc = new Scene(g,700,250);
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		QuadCurve q = new QuadCurve();
		Text t = new Text(100,90,"Wenzhou is a beautiful city \nsituated in Zhejiang provence \ncovered by mountains and most of the time raining");
		sc.setFill(Color.AZURE);
		
		c.setCenterX(40);c.setCenterY(40);c.setRadius(30);
		c.setStroke(Color.RED);c.setFill(Color.RED);
		
		r.setFill(Color.BLUE);
		r.setWidth(80);r.setHeight(50);
		r.setLayoutX(570);r.setLayoutY(190);
		
		q.setFill(Color.BLACK);
		q.setStartX(600);q.setStartY(70);
		q.setEndX(680);q.setEndY(70);
		q.setControlX(640);q.setControlY(10);
		
		t.setFont(Font.font("Serif",FontWeight.BOLD,26));
		
		g.getChildren().add(r);
		g.getChildren().add(c);
		g.getChildren().add(q);
		g.getChildren().add(t);
		ps.setTitle("Drawing Text");
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
