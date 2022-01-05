package chapter17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class panechart extends Application {
	public void start(Stage ps) {
		PieChart pc = new PieChart();
		PieChart.Data d1 = new PieChart.Data("Bejing", 20);
		PieChart.Data d2 = new PieChart.Data("ShangHai",35);
		PieChart.Data d3 = new PieChart.Data("WenZhou", 85);
		pc.getData().add(d1);
		pc.getData().add(d2);
		pc.getData().add(d3);
		VBox vb = new VBox();
		Scene sc = new Scene(vb,400,400);
		vb.getChildren().add(pc);
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
