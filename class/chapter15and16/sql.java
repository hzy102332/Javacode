package chapter15and16;
import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class sql extends Application{
	public void start(Stage ps) {
		BorderPane bp = new BorderPane();
		Scene sc = new Scene(bp,300,205,Color.WHITE);
		
		MenuBar mb = new MenuBar();
		mb.prefWidthProperty().bind(ps.widthProperty());
		bp.setTop(mb);
		// File menu - new, save, exit
		Menu file = new Menu("File");
		MenuItem newmenuitem = new MenuItem("New");
		MenuItem save = new MenuItem("Save");
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(ActionEvent->Platform.exit());
		
		file.getItems().addAll(newmenuitem,save,exit, new SeparatorMenuItem());
		
		Menu wm = new Menu("Web");
		CheckMenuItem htmlmenuitem = new CheckMenuItem("HTML");
		htmlmenuitem.setSelected(true);
		wm.getItems().add(htmlmenuitem);
		
		Menu sqlmenu =  new Menu("SQL");
		ToggleGroup tg = new ToggleGroup();
		RadioMenuItem mysql = new RadioMenuItem("MySQL");
		mysql.setToggleGroup(tg);
		
		RadioMenuItem oracleitem = new RadioMenuItem("Oracle");
		oracleitem.setToggleGroup(tg);
		oracleitem.setSelected(true);
		sqlmenu.getItems().addAll(mysql,oracleitem, new SeparatorMenuItem());
		
		Menu tm = new Menu("Tutorial");
		tm.getItems().addAll(
				new CheckMenuItem("Java"),
				new CheckMenuItem("JavaFX"),
				new CheckMenuItem("Swing"));
		sqlmenu.getItems().add(tm);
		mb.getMenus().addAll(file,wm,sqlmenu);
		ps.setScene(sc);
		ps.show();
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
}
