package chapter15and16;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;
public class textturnaround extends Application{
	 public void start(Stage ps) throws Exception
	 {
	 final Group gp = new Group();
	 final Scene sc = new Scene(gp, 680, 500, Color.GHOSTWHITE);
	 ps.setScene(sc);
	 ps.setTitle("Path Transition Animations");
	 ps.show();
	 final Path path = new Path();
	 path.getElements().add(new MoveTo(340,20));
	 path.getElements().add(new CubicCurveTo(65, 200, 70, 400, 510, 200));
	 path.getElements().add(new CubicCurveTo(350, 20, 250, 240, 320, 340));
	 path.setOpacity(0.0);
	 gp.getChildren().add(path);
	 final Reflection rfl = new Reflection();
	 rfl.setFraction(1.0);
	 final Shape shape = TextBuilder.create()
	 .text("Wenzhou kean University").x(30).y(20)
	 .font(Font.font(java.awt.Font.SANS_SERIF, 25))
	 .effect(rfl)
	 .build();

	 gp.getChildren().add(shape);

	 final PathTransition pt = new PathTransition();
	 pt.setDuration(Duration.seconds(8.0));
	 pt.setDelay(Duration.seconds(.5));
	 pt.setPath(path);
	 pt.setNode(shape);
	 pt.setOrientation(OrientationType.NONE);
	 pt.setCycleCount(Timeline.INDEFINITE);
	 pt.setAutoReverse(true);
	 
	 final ParallelTransition prt = new ParallelTransition(pt);
	 prt.play();
	 }
	 public static void main(final String[] arguments)
	 {
	 Application.launch(arguments);
	 }
}
