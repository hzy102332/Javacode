package chapter15and16;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class caculator extends Application{
	public void start(Stage ps) {
		 ps.setTitle("Simple Calculator");
		 GridPane p = new GridPane();
		 p.setAlignment(Pos.CENTER);
		 p.setHgap(10);
		 p.setVgap(10);
		 p.setPadding(new Insets(25, 25, 25, 25));
		 Scene sc = new Scene(p, 300, 275);
		 Text t = new Text("Calculator to Add 2 numbers");
		 t.setFont(Font.font("Arial", FontWeight.NORMAL,15));
		 p.add(t, 0, 0, 2, 1);
		 Label l1 = new Label("Number1:");
		 p.add(l1, 0, 1);
		 final TextField num1 = new TextField();
		 p.add(num1, 1, 1);
		 Label l2 = new Label("Number2:");
		 p.add(l2,0,2);
		 final TextField num2 = new TextField();
		 p.add(num2, 1, 2);
		 Button b = new Button("Calculate");
		 HBox hb = new HBox(10);
		 hb.setAlignment(Pos.BOTTOM_RIGHT);
		 hb.getChildren().add(b);
		 p.add(hb, 1, 4);
		 final Text Total = new Text();
		 p.add(Total, 1, 6);
		 b.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent t) {
			 int a = Integer.parseInt(num1.getText());
			 int b = Integer.parseInt(num2.getText());
			 int c = a+b;
			 Total.setText("total is : "+c);
			 }
			 });
			 ps.setScene(sc);
			 ps.show();
			 }
			 public static void main(String[] args) {
			 launch(args);
			 }
}
