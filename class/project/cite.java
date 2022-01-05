package project;

import javafx.application.Application;
import javafx.stage.Stage;

public class cite extends Application{
	public void start (Stage ps) {
		clickball c = new clickball();
		c.start(ps);
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
