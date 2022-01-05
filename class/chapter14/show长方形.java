package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class show³¤·½ÐÎ  extends Application{
	public void start (Stage primaryStage) {
		Pane p = new StackPane();
		Rectangle r = new Rectangle();
		Scene sc = new Scene(p,300,200);
		r.setHeight(100);
		r.setWidth(150);
		r.setStroke(Color.BLACK);
		r.setFill(Color.WHITE);
		Label l =new Label("WenZhou");
		l.setFont(Font.font("Times New Roman"));
		p.getChildren().add(r);
		p.getChildren().add(l);
		primaryStage.setTitle("Rectangle");
		primaryStage.show();
		primaryStage.setScene(sc);
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
