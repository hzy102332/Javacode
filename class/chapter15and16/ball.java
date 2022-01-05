package chapter15and16;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class ball extends Application{
	static int dx = 1;
	 static int dy = 1;
	 public static void main(String[] args) {
	 Application.launch(args);
	 }
	 public void start(final Stage ps1) {
	 ps1.setTitle("Frame and TimeLine Animation");
	 Group g = new Group();
	 Scene sc = new Scene(g, 700, 600, Color.WHITE);
	 ps1.setScene(sc);
	 Ball(sc);
	 ps1.show();
	 }
	 private void Ball(final Scene sc) {
	 final Circle ball = new Circle(100, 100, 20);
	 final Group g = (Group) sc.getRoot();
	 g.getChildren().add(ball);
	 Timeline tl = new Timeline();
	 tl.setCycleCount(Animation.INDEFINITE);
	 KeyFrame moveBall = new KeyFrame(Duration.seconds(.0004),
	 new EventHandler<ActionEvent>() {
	 public void handle(ActionEvent event) {
	 double xMin = ball.getBoundsInParent().getMinX();
	 double yMin = ball.getBoundsInParent().getMinY();
	 double xMax = ball.getBoundsInParent().getMaxX();
	 double yMax = ball.getBoundsInParent().getMaxY();
	 if (xMin < 0 || xMax > sc.getWidth()) {
	 dx = dx * -1;
	 }
	 if (yMin < 0 || yMax > sc.getHeight()) {
	 dy = dy * -1;
	 }
	
	 ball.setTranslateX(ball.getTranslateX() + dx);
	 ball.setTranslateY(ball.getTranslateY() + dy);
	 }
	 });
	 tl.getKeyFrames().add(moveBall);
	 tl.play();
	 }
}
