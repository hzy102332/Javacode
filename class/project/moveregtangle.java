package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class moveregtangle extends Application{
	public void start(Stage ps) {
		Pane p = new Pane();
		Rectangle r = new Rectangle(100,20);
		Scene sc = new Scene(p,400,400);
		p.getChildren().add(r);
		r.setLayoutY(370);
		r.setLayoutX(150);
		double i=r.getBoundsInParent().getMinX();
		
		r.setOnMouseMoved(e ->{
			r.setLayoutX(e.getSceneX()-50);
			r.setLayoutY(e.getSceneY()-10);
			if(i<0||i >sc.getWidth()) {
			r.setLayoutX(0);
		}
		});
		
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
	
}
