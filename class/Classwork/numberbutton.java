package Classwork;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class numberbutton extends Application{
	public void start (Stage ps) {
		Group g =new Group();
		Scene sc = new Scene(g,400,400);
		ps.setScene(sc);
		for (int i=1;i<21;i++) {
			String a=i+"";
			int x=50*i;int y=100;
			if (i>5 & i<=10) {
				y=150;x=50*(i-5);
			}
			else if (i>10 & i<=15) {
				y=200;x=50*(i-10);
			}
			else if(i>15){
				y=250;x=50*(i-15);
			}
			Button b=new Button(a);
			b.setLayoutX(x);
			b.setLayoutY(y);
			g.getChildren().add(b);
		}
		ps.setTitle("numberbutton");
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
