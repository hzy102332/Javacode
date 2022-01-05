package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class shootwall extends Application{
	int i=1;
	double x1,y1,x2,y2;
	int b;	
	int dy=1;
	int dx=1;
	public void start(Stage ps) throws FileNotFoundException {
//		能否改变窗口
		ps.setResizable(false);
		
		Group g = new Group();
		Scene sc = new Scene(g,800,800);
		
//		Label l = new Label("You could click button to change bullet size");
//		l.setFont(Font.font("Arial",FontWeight.SEMI_BOLD,20));
//		g.getChildren().add(l);
		
		Rectangle r = new Rectangle(0, 100, 800, 20);
		r.setWidth(800);r.setHeight(20);
		r.setLayoutX(0);r.setLayoutY(100);
		g.getChildren().add(r);
		
		FileInputStream fi1 = new FileInputStream("G:\\tank2..png");
		Image i1 = new Image(fi1);  
		ImageView iv1 = new ImageView(i1);
		iv1.setLayoutX(380);iv1.setLayoutY(350);
		g.getChildren().add(iv1);	
		
		iv1.setOnKeyPressed(e->{
			switch (e.getCode()) {
			case A: iv1.setX(iv1.getX()-20);break;
			case D: iv1.setX(iv1.getX() + 20);break;	
			case S: iv1.setY(iv1.getY() + 20);break;
			case W: iv1.setY(iv1.getY()-20);break;
			default:
				break;
			}
			x1=iv1.getBoundsInParent().getMinX()+24;
			y1=iv1.getBoundsInParent().getMaxY();
		});
		iv1.requestFocus();
		
		
		
//		 final Circle ball = new Circle(150, 100, 50);
//		 g.getChildren().add(ball);
//		 Timeline tl = new Timeline();
//		 tl.setCycleCount(Animation.INDEFINITE);
//		 KeyFrame moveBall = new KeyFrame(Duration.seconds(.001),
//		 new EventHandler<ActionEvent>() {
//		 public void handle(ActionEvent event) {
//		 double xMin = ball.getBoundsInParent().getMinX();
//		 double yMin = ball.getBoundsInParent().getMinY();
//		 double xMax = ball.getBoundsInParent().getMaxX();
//		 double yMax = ball.getBoundsInParent().getMaxY();
//		 if (xMin < 0 || xMax > sc.getWidth()) {
//		 dx = dx * -1;
//		 }
//		 if (yMin < 0 || yMax > sc.getHeight()) {
//		 dy = dy * -1;
//		 }
//		 if(iv1.getLayoutY()==ball.getLayoutY()) {
//				g.getChildren().removeAll(iv1,ball);}
//		 
//		 ball.setTranslateX(ball.getTranslateX() + dx);
//		 ball.setTranslateY(ball.getTranslateY() + dy);
//		 }
//		 });
//		 tl.getKeyFrames().add(moveBall);
//		 tl.play();
		 
		 Circle[] c = new Circle[1000];
			for(int i =0;i<=999;i++) {
				c[i]=new Circle();
			}
		
		g.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.J) {
				double red =Math.random();
				double green =Math.random();
				double blue =Math.random();
				c[i].setFill(Color.color(red,green,blue));
				c[i].setLayoutX(x1);
				c[i].setLayoutY(y1);
				c[i].setRadius(8);
				
				g.getChildren().add(c[i]);
				
				TranslateTransition tt1 = new TranslateTransition(Duration.millis(900));
				tt1.setFromY(-50f);
				tt1.setToY(-1000f);
				tt1.setAutoReverse(true);
				SequentialTransition seqT1 = new SequentialTransition(c[i],tt1);
				seqT1.play();
				i++;
				
				
				}
		
		});	
		if(iv1.getLayoutBounds().getMinY()==100) {
			 g.getChildren().removeAll(c[i-1],r);
		Platform.exit();	 
		}
		
		ps.setScene(sc);
		ps.show();
		
	}
//	private void destroyObject(final shootwall r) {
//		FadeTransition fade = new FadeTransition(Duration.millis(200.0D), brick);
//		fade.setFromValue(1.0D);
//		fade.setToValue(0.0D);
//		fade.setOnFinished(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent t) {
//				getChildren().remove(brick);
//			}
//		});
//		this.bricks.remove((Brick) brick);
//		fade.play();
//	}
	public static void main(String[] args) {
		Application.launch(args);
		
	}
}
