package chapter17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemoinputString extends Application{
	public void start(Stage ps) throws FileNotFoundException {
		ps.setTitle("ImageView I/O Exception");
		MenuItem m1 = new MenuItem("Option 1");
		MenuItem m2 = new MenuItem("Option 2");
		MenuItem m3 = new MenuItem("Option 3");
		FileInputStream fi = new FileInputStream("G:\\button.png");
		Image i = new Image(fi);
		ImageView iv = new ImageView(i);
		MenuButton mb = new MenuButton("Options", iv, m1,m2,m3);
		HBox hb = new HBox();
		Scene sc = new Scene (hb,400,300);
		hb.getChildren().addAll(iv,mb);
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
		
	}
}
