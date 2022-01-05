package project;
import static javafx.scene.input.KeyCode.SPACE;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class tankshoot extends Application{
	int  i=3;
	double x1,y1,x2,y2;
	public void start (Stage ps) throws FileNotFoundException {
		Group g = new Group();
		Scene sc = new Scene(g,800,800);
//		Button b = new Button("Start");
//		b.setLayoutX(380);   b.setLayoutY(380);
//		g.getChildren().add(b);
//		b.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			public void handle (MouseEvent e) {
//				
//				g.getChildren().remove(b);
//			}
//		});
		
		FileInputStream fi1 = new FileInputStream("G:\\tank1..png");
		FileInputStream fi2 = new FileInputStream("G:\\tank2..png");
		Image i1 = new Image(fi1);   Image i2 = new Image(fi2);
		ImageView iv1 = new ImageView(i1);
		ImageView iv2 = new ImageView(i2);
		iv1.setLayoutX(380);iv1.setLayoutY(0);
		iv2.setLayoutX(380);iv2.setLayoutY(750);
		g.getChildren().add(iv1);	g.getChildren().add(iv2);
		
		iv1.setOnKeyPressed(e->{
			switch (e.getCode()) {
			case LEFT: 	iv1.setX(iv1.getX()-20); 
						RotateTransition rt = new RotateTransition(Duration.millis(2000));
						rt.setByAngle(180f);
						rt.setNode(iv1);
						rt.setAutoReverse(true);break;
			case RIGHT: iv1.setX(iv1.getX() + 20);break;			
			case DOWN: iv1.setY(iv1.getY() + 20); break;
			case UP: iv1.setY(iv1.getY()-20);break;
			default:
				break;
			}
			x1=iv1.getBoundsInParent().getMinX()+25;
			y1=iv1.getBoundsInParent().getMaxY();
		});
		iv1.requestFocus();
		
		sc.setOnKeyPressed(e->{
			switch (e.getCode()) {
			case A: iv2.setX(iv2.getX()-10); break;
			case D: iv2.setX(iv2.getX() + 10); break;
			default:
				break;
			}
			x2=iv2.getBoundsInParent().getMinX()+24;
			y2=iv2.getBoundsInParent().getMinY();
		});
	
	
		
		g.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				
				Circle c1 = new Circle(x1,y1,2);
				g.getChildren().add(c1);
				
				TranslateTransition tt1 = new TranslateTransition(Duration.millis(900));
				 tt1.setFromY(0f);
				 tt1.setToY(800f);
				 tt1.setAutoReverse(true);
				 SequentialTransition seqT1 = new SequentialTransition(c1,tt1);
				seqT1.play();
				
			}
		});	
		
		sc.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.J) {
				
				Circle c2 = new Circle(x2,y2,2);
				g.getChildren().add(c2);
				
				TranslateTransition tt = new TranslateTransition(Duration.millis(900));
				 tt.setFromY(-100f);
				 tt.setToY(0f);
				 tt.setAutoReverse(true);
				 SequentialTransition seqT = new SequentialTransition(c2,tt);
				 seqT.play();
			}
		});	
		
		
        

		
		
		ps.setScene(sc);
		ps.show();
		
	}
	public void ball(final Scene sc) {
		
	}
	public static void main(String[]args) {
		Application.launch(args);}	
}
