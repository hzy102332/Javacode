package chapter15and16;
import chapter14.ClockPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class clockAnimation extends Application{
	public void start (Stage ps) {
		ClockPane c =  new ClockPane();
		EventHandler<ActionEvent> eventHandler = e -> {
			c.setCurrentTime();
			};
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
		Scene sc = new Scene(c,250,250);
		ps.setTitle("ClockAnimation");
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
