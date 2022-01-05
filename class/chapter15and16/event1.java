package chapter15and16;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class event1 extends Application{
	public void start (Stage ps) {
		initUI(ps);
	}
	private void initUI (Stage ps) {
		Pane p =new Pane ();
		Rectangle r = new Rectangle(30,30,80,80);
		r.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle (MouseEvent e) {
				System.out.println(e.getSource());
				System.out.println(e.getTarget());
				System.out.format("x:%f, y:%f",e.getSceneX(),e.getSceneY());
				System.out.format("x:%f, y:%f",e.getScreenX(),e.getScreenY());	}
		});
		p.getChildren().add(r);
		Scene sc =new Scene(p,500,400);
		ps.setTitle("Event Displaying");
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
