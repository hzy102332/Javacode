package chapter15and16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Demowebview extends Application{
	public void start (Stage ps) {
		ps.setTitle("webview Example");
		WebView w = new WebView();
		w.getEngine().load("https://www.google.com/webhpe");
		VBox vb = new VBox(w);
		Scene sc = new Scene (vb,900,800);
		ps.setScene(sc);
		ps.show();
		
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
