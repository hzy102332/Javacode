package chapter15and16;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloWKU extends Application{
	public static void main(String[] args) {
		 Application.launch(args);
	}
		 public void start(Stage ps) {
		  String message =
		 "Wenzhou Kean University: " +
		 "Wenzhou-Kean University is a Chinese-American jointly established " +
		 "higher education institution with Independent legal person " +
		 "On November 16th 2011, the Ministry of Education of the" +
		 "People¡¯s Republic of China approved the application of preparation" +
		 "on establishing Wenzhou-Kean University that is cooperatively " +
		 "run by Wenzhou University and Kean University USA " ;
		 Text t = TextBuilder.create()
				 .layoutY(100)
				 .textOrigin(VPos.TOP)
				 .textAlignment(TextAlignment.JUSTIFY)
				 .wrappingWidth(400).text(message)
		 .fill(Color.rgb(187, 195, 107))
		 .font(Font.font("SansSerif", FontWeight.BOLD, 24))
		 .build();
		 TranslateTransition tt = TranslateTransitionBuilder.create()
				 .duration(new Duration(75000))
				 .node(t)
				 .toY(-820)
				 .interpolator(Interpolator.LINEAR)
				 .cycleCount(Timeline.INDEFINITE)
				 .build();
		 Scene sc = SceneBuilder.create()
				 .width(800)
				 .height(700)
				 .root(
				 GroupBuilder.create()
				 .children(
				 ImageViewBuilder.create()
				 .image(new Image("http://www.wku.edu.cn/wp-content/uploads/2016/03/tab-img-1.jpg"))
				 .build(),
				 ScrollPaneBuilder.create()
				 .layoutX(200)
				 .layoutY(300)
				 .prefWidth(440)
				 .prefHeight(85)
				 .hbarPolicy(ScrollBarPolicy.NEVER)
				 .vbarPolicy(ScrollBarPolicy.NEVER)
				 .pannable(true)
				 .content(t)
				 .style("-fx-background-color: transparent;").build())
				 .build()).build();
		 ps.setScene(sc);
		 ps.setTitle("Hello WKU");
		 ps.show();
		 tt.play();
		 }
		

}
