package Task;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class loginbox extends Application{
public void start(Stage ps) {
	ps.setTitle("Login Box");
	GridPane gp = new GridPane();
	gp.setAlignment(Pos.CENTER);
	gp.setHgap(5.5);gp.setVgap(5.5);
	Scene sc = new Scene(gp,500,200);
	
	gp.add(new Label("Username"), 0, 0);
	gp.add(new TextField(), 1, 0);
	gp.add(new Label("Password"), 0, 1);
	TextField t = new TextField();
	gp.add(new TextField(), 1, 1);
	Button b =new Button("Login");
	gp.add(b, 3, 1);
	ps.setScene(sc);
	ps.show();
}
public static void main(String[]args) {
	Application.launch(args);
}
}
