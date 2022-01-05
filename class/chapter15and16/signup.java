package chapter15and16;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signup extends Application{
	public void start(Stage ps) {
		Group g = new Group();
		Scene sc = new Scene(g,600,600);
	    Rectangle r = new Rectangle(600,600);
		r.setArcHeight(200);
		r.setArcWidth(200);
		r.setFill(Color.LIGHTGREEN);
		g.getChildren().add(r);
		
		GridPane hb = new GridPane();
		hb.setAlignment(Pos.CENTER);
		hb.setHgap(80);hb.setVgap(40);
		
		Text t = new Text("Sign Up");
		DropShadow ds = new DropShadow();
		DropShadow ds1 = new DropShadow();	
		ds1.setColor(Color.BLACK);ds1.setOffsetY(-1.0f);
		ds.setColor(Color.RED);ds.setOffsetY(0.0f);
		
		t.setUnderline(true);
		t.setFont(Font.font("Arial",FontWeight.BOLD,50));
		t.setCache(true);
		t.setFill(Color.BLACK);
		t.setEffect(ds);
		hb.add(t, 1, 2);
		
		Label l= new Label("First Name");Label l2= new Label("Last Name");
		Label l3= new Label("Email ID");Label l4= new Label("Password");
		hb.add(l, 1, 3);hb.add(l2, 1,4);
		hb.add(l3, 1, 5);hb.add(l4, 1, 6);
		
		TextField tf = new TextField();TextField tf2 =new TextField();
		TextField tf3 =new TextField();TextField tf4 =new TextField();
		hb.add(tf4, 2,6);hb.add(tf3,2, 5);
		hb.add(tf2, 2,4);hb.add(tf, 2, 3);
		
		Button b = new Button("Submit");Button b1= new Button("Reset");
		b.setEffect(ds1);b1.setEffect(ds1);
		hb.add(b1, 2, 7);hb.add(b, 1, 7);
		
		g.getChildren().add(hb);
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
