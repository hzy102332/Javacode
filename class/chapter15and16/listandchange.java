package chapter15and16;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class listandchange extends Application{
	public static void main(String[] args) {
		 Application.launch(args);
		 }
		 public void start(Stage ps) {
		 ps.setTitle("Listings....");
		 Group g = new Group();
		 Scene s = new Scene(g, 400, 250, Color.WHITE);

		 GridPane gp = new GridPane();
		 gp.setPadding(new Insets(5));
		 gp.setHgap(10);
		 gp.setVgap(10);

		 Label Lbl = new Label("Province...");
		 GridPane.setHalignment(Lbl, HPos.CENTER);
		 gp.add(Lbl, 0, 0);

		 Label Lb2 = new Label("Cities...");
		 gp.add(Lb2, 2, 0);
		 GridPane.setHalignment(Lb2, HPos.CENTER);

		 final ObservableList<String> lefts =
		FXCollections.observableArrayList("Zhejian","Wenzhou","Jiagsu", "Suzhou",
		"Yunnan", "Kunming");
		 final ListView<String> leftListView = new ListView<String>(lefts);
		 leftListView.setPrefWidth(150);
		 leftListView.setPrefHeight(150);
		 gp.add(leftListView, 0, 1);

		 final ObservableList<String> rights = FXCollections.observableArrayList();
		 final ListView<String> rightListView = new ListView<String>(rights);
		 rightListView.setPrefWidth(150);
		 rightListView.setPrefHeight(150);
		 gp.add(rightListView, 2, 1);
		 Button b1 = new Button("Move >");
		 b1.setOnAction(new EventHandler<ActionEvent>() {
		 public void handle(ActionEvent event) {
		 String s = leftListView.getSelectionModel().getSelectedItem();
		 if (s != null) {
		 leftListView.getSelectionModel().clearSelection();
		 lefts.remove(s);
		 rights.add(s);
		 }}});

		 Button b2 = new Button("< Move");
		 b2.setOnAction(new EventHandler<ActionEvent>() {
		 public void handle(ActionEvent event) {
		 String s = rightListView.getSelectionModel().getSelectedItem();
		 if (s != null) {
		 rightListView.getSelectionModel().clearSelection();
		 rights.remove(s);
		 lefts.add(s);
		 }}});
		 
		 VBox vb = new VBox(5);
		 vb.getChildren().addAll(b1,b2);

		 gp.add(vb, 1, 1);
		 GridPane.setConstraints(vb, 1, 1, 1, 2,HPos.CENTER, VPos.CENTER);

		 g.getChildren().add(gp);
		 ps.setScene(s);
		 ps.show();
		 }
		 
		 
		 
		 
		 
}
