package chapter15and16;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class sighup2 extends Application{
	public void start(Stage ps) {
		Pane h = new Pane();
		Scene sc = new Scene(h,600,600);
		
		DropShadow ds = new DropShadow();
		DropShadow ds1 = new DropShadow();	
		ds.setColor(Color.RED);ds.setOffsetY(2.0f);
		ds1.setColor(Color.BLACK);ds1.setOffsetY(-1.0f);
		
		
	    Circle c = new Circle(); Circle c1 =new Circle();
	    Circle c2 =new Circle(); Circle c3 =new Circle();
	    c.setCenterX(450);c.setCenterY(450);c.setRadius(150);c.setFill(Color.LIGHTGREEN);
	    c1.setCenterX(150);c1.setCenterY(150);c1.setRadius(150);c1.setFill(Color.LIGHTGREEN);
	    c2.setCenterX(450);c2.setCenterY(150);c2.setRadius(150);c2.setFill(Color.LIGHTGREEN);
	    c3.setCenterX(150);c3.setCenterY(450);c3.setRadius(150);c3.setFill(Color.LIGHTGREEN);
		h.getChildren().addAll(c,c1,c2,c3);
		
		Rectangle r = new Rectangle(600,300);
		Rectangle r2 = new Rectangle(300,600);
		r.setFill(Color.LIGHTGREEN);r2.setFill(Color.LIGHTGREEN);
		r2.setLayoutX(150);r2.setLayoutY(0);
		r.setLayoutX(0);r.setLayoutY(150);
		h.getChildren().addAll(r,r2);

//		Another method*
//		Rectangle r1 = new Rectangle(600,600);
//		r1.setArcHeight(200);
//		r1.setArcWidth(200);
//		r1.setFill(Color.LIGHTGREEN);
//		h.getChildren().add(r1);
		
		Text t = new Text("Sign Up");
		t.setUnderline(true);
		t.setFont(Font.font("Arial",FontWeight.BOLD,50));
		t.setCache(true);
		t.setFill(Color.BLACK);
		t.setEffect(ds);
		t.setLayoutX(75);t.setLayoutY(125);
		h.getChildren().add(t);
		
		Label l= new Label("First Name");Label l2= new Label("Last Name");
		Label l3= new Label("Email ID");Label l4= new Label("Password");
	    l.setFont(Font.font(null,FontWeight.BOLD,20));
	    l2.setFont(Font.font(null,FontWeight.BOLD,20));
	    l3.setFont(Font.font(null,FontWeight.BOLD,20));
	    l4.setFont(Font.font(null,FontWeight.BOLD,20));
		l.setLayoutX(75);l.setLayoutY(175);
		l2.setLayoutX(75);l2.setLayoutY(250);
		l3.setLayoutX(75);l4.setLayoutY(325);
		l4.setLayoutX(75);l3.setLayoutY(400);
		h.getChildren().addAll(l,l2,l3,l4);
		
		TextField tf = new TextField();TextField tf2 =new TextField();
		TextField tf3 =new TextField();TextField tf4 =new TextField();
		tf.setLayoutX(325);tf.setLayoutY(175);
		tf2.setLayoutX(325);tf2.setLayoutY(250);
		tf3.setLayoutX(325);tf3.setLayoutY(325);
		tf4.setLayoutX(325);tf4.setLayoutY(400);
		h.getChildren().addAll(tf,tf2,tf3,tf4);
		
		Button b = new Button("Submit");Button b1= new Button("Reset");
		b.setMinHeight(30);b.setMinWidth(75);
		b.setLayoutX(75);b.setLayoutY(475);
		b.setEffect(ds1);b1.setEffect(ds1);
		b1.setLayoutX(325);b1.setLayoutY(475);
		h.getChildren().addAll(b,b1);
		
		
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}

