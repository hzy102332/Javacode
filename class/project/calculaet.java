package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class calculaet extends Application{
	public void start(Stage ps) {
		Pane p = new Pane();
		Scene sc= new Scene(p,500,200);
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		Text t11 =  new Text(50,30,"1nnnnnnnnnnnnnnnnnn");p.getChildren().add(t11);
		Text t12 =  new Text(50,60,"1");p.getChildren().add(t12);
		Text t13 =  new Text("1");p.getChildren().add(t13);
		Text t14 =  new Text("1");p.getChildren().add(t14);
		
		t1.setLayoutX(250);t1.setLayoutY(10);
		t2.setLayoutX(250);t2.setLayoutY(40);
		p.getChildren().addAll(t1,t2);
		
		Button b = new Button("ss");
		b.setLayoutY(130);b.setLayoutX(250);
		p.getChildren().add(b);
		double i = 2;
		double a = Math.pow(i, 3);		
		ps.setScene(sc);
		ps.show();
}	public static void main(String[]args) {
	Application.launch(args);
}

}
