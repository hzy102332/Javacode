package Task;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
public class BorderPaneDemo extends Application{
public void start(Stage ps) {
	BorderPane bp = new BorderPane();
	Scene sc = new Scene (bp,500,300);
	
	TextArea ta = new TextArea("TEXR AREA");
	Button b1 = new Button("TOP BUTTION");
	Button b2 = new Button("LEFT BUTTON");
	Button b3 = new Button("RIGHT BUTTON");
	Button b4 = new Button("BOTTOM BUTTON");
	bp.setTop(b1);bp.setAlignment(b1, Pos.CENTER);
	bp.setLeft(b2);bp.setAlignment(b2, Pos.CENTER);
	bp.setRight(b3);bp.setAlignment(b3, Pos.CENTER);
	bp.setBottom(b4);bp.setAlignment(b4, Pos.CENTER);
	bp.setCenter(ta);bp.setAlignment(ta, Pos.CENTER);
	ps.setScene(sc);
	ps.show();
	}
	public static void main(String[]args) {
	Application.launch(args);
	}
}
