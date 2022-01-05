package project;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class clickball extends Application{
	static int dx1 = 1;
	 static int dy1 = 1;
	 int i =0;
	 public static void main(String[] args) {
	 Application.launch(args);
	 }
	 public void start(final Stage ps) {
	 ps.setTitle("Frame and TimeLine Animation");
	 Group g = new Group();
	 Scene sc = new Scene(g, 600, 500, Color.WHITE);
	 Text l = new Text("You have clicked the ball ");
	 l.setFont(Font.font("Arial",FontWeight.BOLD ,20));
	 l.setFill(Color.GREENYELLOW);
	 l.setLayoutX(25);
	 l.setLayoutY(50);
	 g.getChildren().add(l);
	 ps.setScene(sc);
	 Ball(sc);
	 ps.show();
	 }
	 private void Ball(final Scene sc) {
	 final Circle ball = new Circle(100, 100, 30);
	 final Group g = (Group) sc.getRoot();
	 g.getChildren().add(ball);
	 Timeline tl = new Timeline();
	 tl.setCycleCount(Animation.INDEFINITE);
	 KeyFrame moveBall = new KeyFrame(Duration.seconds(.004),
	 new EventHandler<ActionEvent>() {
	 public void handle(ActionEvent event) {
	 double xMin = ball.getBoundsInParent().getMinX();
	 double yMin = ball.getBoundsInParent().getMinY();
	 double xMax = ball.getBoundsInParent().getMaxX();
	 double yMax = ball.getBoundsInParent().getMaxY();
	 if (xMin < 0 || xMax > sc.getWidth()) {
	 dx1 = dx1 * -1;
	 }
	 if (yMin < 0 || yMax > sc.getHeight()) {
	 dy1 = dy1 * -1;
	 }
	 ball.setTranslateX(ball.getTranslateX() + dx1);
	 ball.setTranslateY(ball.getTranslateY() + dy1);
	 ball.setOnMouseClicked(new EventHandler<MouseEvent>() {
		 public void handle (MouseEvent e) {
			 ArrayList<String> a = new ArrayList<String>();
			 for (int i=0; i<=5;i++) { String z=""+i; a.add(z);}
			 i+=1;
			 double red =Math.random();
				double green =Math.random();
				double blue =Math.random();
			 ball.setFill(Color.color(red, green, blue));
			 Text l = new Text(a.get(i)+" time(s)");
			 l.setFont(Font.font("Arial",FontWeight.BOLD ,20));
			 l.setFill(Color.GREENYELLOW);
			 l.setLayoutX(270);
			 l.setLayoutY(30+i*20);
			 if (i==5) {
			 g.getChildren().remove(ball);
			 l.setText("YOU WIN !");
			 }
			 g.getChildren().add(l);
		 }
	});
	 }
	 });
	 tl.getKeyFrames().add(moveBall);
	 tl.play();
	 }
	 
}
