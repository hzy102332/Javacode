package chapter15and16;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage; 
public class registrationpage extends Application{
	public void start(Stage ps) {
		 //Label for name
		 Text lblname = new Text("Name");
		 //Text field for name
		 TextField tname = new TextField();

		 //Label for date of birth
		 Text lbldob = new Text("Date of birth");

		 //date picker to choose date
		 DatePicker dp = new DatePicker();

		 //Label for gender
		 Text lblgndr = new Text("gender");

		 //Toggle group of radio buttons
		 ToggleGroup gGen = new ToggleGroup();
		 RadioButton rb1 = new RadioButton("male");
		 rb1.setToggleGroup(gGen);
		 RadioButton rb2 = new RadioButton("female");
		 rb2.setToggleGroup(gGen);

		 //Label for reservation
		 Text lblrsv = new Text("Reservation");

		 //Toggle button for reservation
		 ToggleButton rsv = new ToggleButton();
		 ToggleButton yes = new ToggleButton("Yes");
		 ToggleButton no = new ToggleButton("No");
		 ToggleGroup gprsv = new ToggleGroup();
		 yes.setToggleGroup(gprsv);
		 no.setToggleGroup(gprsv); 
		 Text lbltech = new Text("Technologies Familiar with");

		 CheckBox chkjava = new CheckBox("Java");
		 chkjava.setIndeterminate(false);
		 CheckBox chkdotnet = new CheckBox("DotNet");
		 chkdotnet.setIndeterminate(false);
		 Text lbledu = new Text("Educational qualification");

		 //list View for educational qualification
		 ObservableList<String> names = FXCollections.observableArrayList(
		 "Doctor's", "Master's", "Graduate", "Vocational", "Certification", "Othsd");
		 ListView<String> lvedu = new ListView<String>(names);


		 Text lblloc = new Text("location");


		 ChoiceBox chbloc = new ChoiceBox();
		 chbloc.getItems().addAll("Wenzhou", "Shanghai", "Beijing", "Guangzhou", "Shenzhen");

		 Button btreg = new Button("Register");
		 GridPane gp = new GridPane();

		 gp.setMinSize(500, 500);
		 gp.setPadding(new Insets(10, 10, 10, 10));
		 gp.setVgap(5);
		 gp.setHgap(5);

		 //Setting the Grid alignment
		 gp.setAlignment(Pos.CENTER);

		 //Arranging all the nodes in the grid
		 gp.add(lblname, 0, 0);
		 gp.add(tname, 1, 0);
		 gp.add(lbldob, 0, 1);
		 gp.add(dp, 1, 1);

		 gp.add(lblgndr, 0, 2);
		 gp.add(rb1, 1, 2);
		 gp.add(rb2, 2, 2);
		 gp.add(lblrsv, 0, 3);
		 gp.add(yes, 1, 3);
		 gp.add(no, 2, 3);

		 gp.add(lbltech, 0, 4);
		 gp.add(chkjava, 1, 4);
		 gp.add(chkdotnet, 2, 4); 
		 gp.add(lbledu, 0, 5);
		 gp.add(lvedu, 1, 5);
		 gp.add(lblloc, 0, 6);
		 gp.add(chbloc, 1, 6);
		 gp.add(btreg, 2, 8);
		 lblname.setStyle("-fx-font: normal bold 12px 'verdana' ");
		 lbldob.setStyle("-fx-font: normal bold 12px 'verdana' ");
		 lblgndr.setStyle("-fx-font: normal bold 12px 'verdana' ");
		 lblrsv.setStyle("-fx-font: normal bold 12px 'verdana' ");
		 lbltech.setStyle("-fx-font: normal bold 12px 'verdana' ");
		 lbledu.setStyle("-fx-font: normal bold 12px 'verdana'");
		 lblloc.setStyle("-fx-font: normal bold 12px 'verdana' ");

		 Scene sc = new Scene(gp);
		 ps.setTitle("Registration Page");

		 //Adding scene to the stage
		 ps.setScene(sc);

		 ps.show();
		 }
		 public static void main(String args[]){
		 launch(args); 
}
		 }
