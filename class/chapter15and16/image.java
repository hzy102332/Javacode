package chapter15and16;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class image extends Application{
	public void start (Stage ps) {
		String s="https://www.bing.com/th?id=OIP.O-9q78SUgXXTIfrk1eEVSwHaLE&w=170&h=160&c=7&o=5&dpr=1.25&pid=1.7";
		Image i = new Image(s,560,380,false,true);
		ImageView iv = new ImageView(i);
		Group hb = new Group();
//		HBox hb = new HBox();
		hb.getChildren().add(iv);
//		hb.setPrefSize(300, 200);
		Scene sc =new Scene (hb);
		ps.setTitle("picture");
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}