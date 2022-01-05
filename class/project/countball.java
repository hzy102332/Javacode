package project;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class countball extends Application{
		int i=0;
		double time;
		double time2;
		String ts;double x =30+Math.random()*740;
		double y =30+Math.random()*740;
	public static void main(String[]args) {
		Application.launch(args);
	}
	public void start(Stage ps) {
		
		double red =Math.random();
		double green =Math.random();
		double blue =Math.random();
		Calendar c = new GregorianCalendar();
		time =c.get(Calendar.MILLISECOND);
		Pane p = new Pane();
		Scene sc = new Scene(p,800,800);
		Circle circle = new Circle(y,x,30);
//				i+=1;
//		if (i==10) {
//				time2=c.get(Calendar.MILLISECOND);
//				ts=time2-time+"";
//				Text t = new Text("You have finished.\n Times spentis "+ts+"milliseconds");
//				p.getChildren().add(t);
//				}
		circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				p.getChildren().remove(circle);
				
				Circle circle = new Circle(x,y,30);
				circle.setFill(Color.color(red,green,blue));
				p.getChildren().add(circle);
			}
		});
		p.getChildren().add(circle);
		ps.setScene(sc);
		ps.show();
	}
}
