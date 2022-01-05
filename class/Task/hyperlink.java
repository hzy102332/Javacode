package Task;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class hyperlink extends Application{
	public static void main(String[]args) {
		Application.launch(args);
	}
public void start (Stage ps) {
	VBox vb = new VBox();
	Scene sc = new Scene(vb,500,200);
	vb.setSpacing(15);
	vb.setPadding(new Insets(10, 0, 0, 10));
	
	Hyperlink h = new Hyperlink("Go to WKU home Page");
	vb.getChildren().add(h);
//	h.setOnAction(ActionEvent e)->{
//		h.setText("Go to WKU home Page");
//		WebView w = new WebView();
//		w.getEngine().load("https://www.google.com/webhpe");
//	};
	
	Button b1 = new Button("On/Off Visited");
	Button b2 = new Button("On/Off Underline");
	vb.getChildren().add(b2);
	vb.getChildren().add(b1);
	vb.setOnMouseClicked(new EventHandler<MouseEvent>() {
		public void handle (MouseEvent e) {
			
		}
	});
	
	
	ps.setScene(sc);
	ps.show();
}
}
