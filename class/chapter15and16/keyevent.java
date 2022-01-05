package chapter15and16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class keyevent extends Application{
	public void start(Stage ps) throws FileNotFoundException {
		Pane p = new Pane();
		Scene sc = new Scene(p,400,400);
		Text t = new Text(180,200,"A");
		t.setFont(Font.font("Arial",FontWeight.BOLD,30));
		p.getChildren().add(t);
		
		t.setOnKeyPressed(e->{
			switch (e.getCode()) {
				case DOWN: t.setY(t.getY() + 20); break;
				case UP: t.setY(t.getY()-20);break;
				case LEFT: t.setX(t.getX()-20); break;
				case RIGHT: t.setX(t.getX() + 20); break;
				default:
					if (e.getText().length() > 0)
						t.setText(e.getText());	
				}
		});
		
		ps.setScene(sc);
		ps.show();
		t.requestFocus();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
