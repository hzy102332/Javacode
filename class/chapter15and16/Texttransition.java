package chapter15and16;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Texttransition extends Application{
	public void start(Stage ps) {
		ps.setTitle("Text  Transition");
		Scene sc= new Scene(new  Group());
		ps.setWidth(300);
		ps.setHeight(200);
		VBox vb = new VBox();
		vb.setLayoutX(20);vb.setLayoutY(20);
		final String s="WenZhou Kean University";
		Text t = new Text(10,20,"");
		Animation a = new Transition() {
			{ setCycleDuration(Duration.millis(2500));}
		protected void interpolate(double p) {
			int l = s.length();
			int n = (int) Math.round(l);
			t.setText(s.substring(0,n));
		}};
		a.play();
		vb.getChildren().add(t);
		vb.setSpacing(10);
		((Group)sc.getRoot()).getChildren().add(vb);
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args){
		Application.launch(args);
	}
}
