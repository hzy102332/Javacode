package chapter15and16;

import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class colorpicker extends Application{
	public void start(Stage ps) {
		VBox vb = new VBox(20);
		ProgressIndicator p = new ProgressIndicator();
		ColorPicker cp =new ColorPicker();
		cp.setValue(Color.RED);
		Text t = new Text("Color Picker");
		t.setFill(cp.getValue());
		cp.setOnAction((ActionEvent)->
		{t.setFill(cp.getValue());});
		
		DatePicker dt = new DatePicker();
		vb.getChildren().addAll(p,cp,t,dt);
		Scene sc= new Scene(vb,400,300);
		ps.setScene(sc);
		ps.show();
	}
	public static void  main(String[]args) {
		Application.launch(args);
	}
}
