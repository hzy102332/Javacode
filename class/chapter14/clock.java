package chapter14;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
	import javafx.stage.Stage;
	public class clock extends Application{
		public void start(Stage ps) {
		ClockPane cp= new ClockPane();
		String time = cp.getHour()+":"+cp.getMinute()+":"+cp.getSecond();
		Label lb= new Label(time);
		BorderPane bp =new BorderPane();
		bp.setCenter(cp);
		bp.setBottom(lb);
		bp.setAlignment(lb, Pos.TOP_CENTER);
		Scene sc= new Scene (bp,400,400);
		ps.setTitle("Displaying Clock");
		ps.setScene(sc);
		ps.show();
	}
		public static void main(String[]args) {
			Application.launch(args);
		}
}
