package chapter17;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class canvasdrawing extends Application{
	
	public void start(Stage ps) {
		StackPane sp = new StackPane();
		Scene sc = new Scene(sp,600,600);
		Canvas cs = new Canvas(600,600);
		final GraphicsContext gc = cs.getGraphicsContext2D();
		initDraw(gc);
		
		cs.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gc.beginPath();
				gc.moveTo(e.getX(), e.getY());
				gc.stroke();;
			}});
		
		cs.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
		public void handle(MouseEvent e) {
			gc.lineTo(e.getX(), e.getY());
			gc.stroke();
		}	
		});
		
		cs.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
			
			}});
		
		sp.getChildren().add(cs);
		ps.setTitle("Paint The Cnavas");
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
	private void initDraw(GraphicsContext gc) {
		double w= gc.getCanvas().getWidth();
		double h= gc.getCanvas().getHeight();
		
		gc.setFill(Color.LIGHTGRAY);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(5);
		
		gc.fill();
		gc.strokeRect(0, 0, w, h);
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(2);
	}}

