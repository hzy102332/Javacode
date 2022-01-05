package project;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.*;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.input.*;
public class ���� extends Application{
	private int count = 0;	// ���е�������
	private Button btStart = new Button();	//���¿�ʼ��ť
	private Button btPause = new Button();	//��ͣ��ť
	private TextField tfCount = new TextField();	//��ʾ���е�������
	private Font font1;
	//private Label label;
	private Text text = new Text();
	private Image mouse = new Image("G:\\tank3.png");	//����ͼ��
	private Image mouse1 = new Image("G:\\tank3.png");
	private Image mouse2 = new Image("G:\\tank3.png");
	private Image mole = new Image("G:\\tank2.png");	//�ض�ͼ��
	private Image hammer = new Image("G:\\tank1.png");	//����ͼ��
	private ImageView mouseView = new ImageView(mouse);
	private ImageView mouseView1 = new ImageView(mouse1);
	private ImageView mouseView2 = new ImageView(mouse2);
	private ImageView moleView = new ImageView(mole);
	private ImageView hammerView = new ImageView(hammer);
	private boolean ifHit = true; //�ж��Ƿ���Դ����trueʱ�ܻ���
	private boolean ifHit1 = true; 
	private boolean ifHit2 = true; 
	private boolean pause = false; 
	final double x1 = 256, y1 = 192, xx = 256, yy = 160; //��һ���ض�λ�ü����

	public void start(Stage primaryStage) {
	Primary(primaryStage);
	}

	public void Primary(Stage stage){
	Label view = new Label("Whac A Mole");
	//Font font = Font.loadFont("fonts/font.ttc", 100);
	//view.setFont(font);
	view.setFont(Font.font("Showcard Gothic",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,100));
	view.setStyle("-fx-text-fill:rgb(150,46,5); -fx-text-border-color:rgb(138,95,69);");
	//view.setBorder();
	GridPane gridpane = new GridPane();
	BorderPane b = new BorderPane();
	BackgroundImage back=new BackgroundImage(new Image("G:\\button.png",1024,768,false,true),
	BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
	b.setBackground(new Background(back));
	Button btStartGame = new Button("Start");

	btStartGame.setBackground(null);
	btStartGame.setStyle("-fx-text-fill:rgb(195,46,5);");
	btStartGame.setFont(Font.font("Bauhaus 93",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,90));

	gridpane.setVgap(5);
	gridpane.setHgap(5);
	gridpane.add(btStartGame, 2, 1);
	//gridpane.add(btshow, 2, 2);
	//gridpane.add(btshow1, 2, 4);
	//gridpane.add(btSetDifficult, 2, 3);

	gridpane.setAlignment(Pos.CENTER);
	view.setAlignment(Pos.BASELINE_CENTER);

	//������Ӱ����
	btStartGame.addEventHandler(MouseEvent.MOUSE_ENTERED,(e -> {
	btStartGame.setEffect(new DropShadow());
	}));
	btStartGame.addEventHandler(MouseEvent.MOUSE_EXITED,(e -> {
	btStartGame.setEffect(null);
	}));

	//������Ӧ
	btStartGame.setOnAction(e->{
	startgame(stage);
	});

	b.setTop(view);
	b.setCenter(gridpane);
	BorderPane.setAlignment(view, Pos.CENTER);
	Scene scene = new Scene(b,1000, 768);
	stage.setScene(scene);
	stage.setTitle("�����");
	stage.setX(500);
	stage.setY(200);
	stage.show();

	}


	public void startgame(Stage stage) {
	Pane pane = new Pane();

	    EventHandler<ActionEvent> eventHandler = e -> {
	    //�����˶�
	    Line line = MouseAppear();	//����1
	pane.getChildren().add(line);
	PathTransition pt = new PathTransition();
	pt.setDuration(Duration.millis(400));
	pt.setPath(line);
	pt.setNode(mouseView);
	pt.setCycleCount(2);
	pt.setAutoReverse(true);
	    pt.play();
	    
	    Line line1 = MouseAppear();	//����2
	pane.getChildren().add(line1);
	PathTransition pt1 = new PathTransition();
	pt1.setDuration(Duration.millis(800));
	pt1.setPath(line1);
	pt1.setNode(mouseView1);
	pt1.setCycleCount(2);
	pt1.setAutoReverse(true);
	    pt1.play();
	    
	    Line line2 = MouseAppear();	//����3
	pane.getChildren().add(line2);
	PathTransition pt2 = new PathTransition();
	pt2.setDuration(Duration.millis(600));
	pt2.setPath(line2);
	pt2.setNode(mouseView2);
	pt2.setCycleCount(2);
	pt2.setAutoReverse(true);
	    pt2.play();
	    
	    //���󽥱�
	    FadeTransition ft = new FadeTransition(Duration.millis(3000),this.mouseView);
	    ft.setFromValue(1.0);
	    ft.setToValue(0.1);
	    ft.setCycleCount(1);
	    ft.play();
	    
	    FadeTransition ft1 = new FadeTransition(Duration.millis(5000),this.mouseView1);
	    ft1.setFromValue(1.0);
	    ft1.setToValue(0.1);
	    ft1.setCycleCount(1);
	    ft1.play();
	    
	    FadeTransition ft2 = new FadeTransition(Duration.millis(4000),this.mouseView2);
	    ft2.setFromValue(1.0);
	    ft2.setToValue(0.1);
	    ft2.setCycleCount(1);
	    ft2.play();
	    
	    this.ifHit = true;	//��Ϊ�ܴ�
	    this.ifHit1 = true;	
	    this.ifHit2 = true;	
	    
	      //���е����¼���� ����¼�
	    pane.setOnMousePressed(e1 ->{
	        
	    if (e1.getX() < line.getEndX() + 80 && e1.getX() > line.getEndX() - 80 && this.ifHit
	    && e1.getY() < line.getStartY() + 110 && e1.getY() > line.getEndY() - 110){
	    this.count ++;
	    
	    //�ı������
	    this.tfCount.setText(String.format("%d", this.count));
	  
	    this.ifHit = false;	//��Ϊ���ܴ�
	    }
	    
	    if (e1.getX() < line1.getEndX() + 80 && e1.getX() > line1.getEndX() - 80 && this.ifHit1
	    && e1.getY() < line1.getStartY() + 110 && e1.getY() > line1.getEndY() - 110){
	    this.count ++;
	    this.count ++;
	    
	    //�ı������
	    //this.tfCount.clear();
	    this.tfCount.setText(String.format("%d", this.count));
	    
	    this.ifHit1 = false;	//��Ϊ���ܴ�
	    }
	    
	    if (e1.getX() < line2.getEndX() + 80 && e1.getX() > line2.getEndX() - 80 && this.ifHit2
	    && e1.getY() < line2.getStartY() + 110 && e1.getY() > line2.getEndY() - 110){
	    this.count ++;
	    
	    //�ı������
	    //this.tfCount.clear();
	    this.tfCount.setText(String.format("%d", this.count));
	    
	    this.ifHit2 = false;	//��Ϊ���ܴ�	   
	    }
	    
	    if (this.ifHit && this.ifHit1 && this.ifHit2) {
	    text.setText("Come on! baby!");
	}
	    else {
	    text.setText("Oh! Damn it!");
	    }
	    
	    });
	    
	    };
	    
	    //����
	    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1300),eventHandler)); //�����ٶ�
	    animation.setCycleCount(30);	//�����������
	animation.play();

	//�ض�ͼ��
	  this.moleView.setFitWidth(1024);
	  this.moleView.setFitHeight(768);
	  //this.moleView.setX(10);
	  //this.moleView.setY(10);
	  pane.getChildren().add(moleView);


	  //��ť���ı���
	  HBox hBox = new HBox(20);
	  
	  btStart.setText("Quit");
	  btPause.setText("Pause/Continue");
	  btStart.setPrefSize(400, 80);
	  btPause.setPrefSize(400, 80);
	  tfCount.setPrefSize(200, 40);
	  btStart.setStyle("-fx-text-fill:rgb(195,46,5);");	
	  btPause.setStyle("-fx-text-fill:rgb(195,46,5);");
	  tfCount.setStyle("-fx-text-fill:rgb(195,46,5);");
	  btStart.setBackground(null);
	  btPause.setBackground(null);
	  tfCount.setBackground(null);
	  btStart.setFont(Font.font("Showcard Gothic",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,40));
	  btPause.setFont(Font.font("Showcard Gothic",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,40));
	  tfCount.setFont(Font.font("Bauhaus 93",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,80));
	  //������Ӱ����
	  btStart.addEventHandler(MouseEvent.MOUSE_ENTERED,(e -> {
	  btStart.setEffect(new DropShadow());
	  }));
	  btStart.addEventHandler(MouseEvent.MOUSE_EXITED,(e -> {
	  btStart.setEffect(null);
	  }));
	  
	  btPause.addEventHandler(MouseEvent.MOUSE_ENTERED,(e -> {
	  btPause.setEffect(new DropShadow());
	  }));
	  btPause.addEventHandler(MouseEvent.MOUSE_EXITED,(e -> {
	  btPause.setEffect(null);
	  }));
	  
	  //���¿�ʼ����
	  btStart.setOnAction(e->{
	  animation.stop();
	  //animation1.stop();
	  this.count = 0;
	  this.tfCount.clear();
	  this.text.setText("");
	  Primary(stage);
	  });
	  
	  //��ͣ��ť
	  btPause.setOnAction(e->{
	  if (!this.pause) {
	  animation.pause();
	  this.pause = true;
	  }
	  else {
	  animation.play();
	  this.pause = false;
	  }
	  
	  });
	  
	  hBox.getChildren().add(btStart);
	  hBox.getChildren().add(btPause);
	  hBox.getChildren().add(tfCount);
	  hBox.setAlignment(Pos.BOTTOM_CENTER);
	  pane.getChildren().add(hBox);
	  
	  //����
	  font1 = Font.font("Kristen ITC", FontWeight.BOLD, FontPosture.ITALIC, 45);
	    
	  text.setStyle("-fx-fill:rgb(222,87,61);");
	  text.setFont(font1);
	  text.setX(280);
	  text.setY(660);
	  pane.getChildren().add(text);
	  
	  //����ͼ��
	  this.mouseView1.setFitWidth(120);
	  this.mouseView1.setFitHeight(210);
	  this.mouseView1.setX(x1 - 70);
	  this.mouseView1.setY(y1 - 90);
	  pane.getChildren().add(mouseView1);
	  
	  this.mouseView2.setFitWidth(120);
	  this.mouseView2.setFitHeight(210);
	  this.mouseView2.setX(x1 - 70);
	  this.mouseView2.setY(y1 - 90);
	  pane.getChildren().add(mouseView2);
	  
	  this.mouseView.setFitWidth(120);
	  this.mouseView.setFitHeight(210);
	  this.mouseView.setX(x1 - 70);
	  this.mouseView.setY(y1 - 90);
	  pane.getChildren().add(mouseView);
	  
	  //��괸��
	  this.hammerView.setFitWidth(160);
	  this.hammerView.setFitHeight(200);
	  pane.setOnMouseMoved(e -> {	//�¼�Դ��������pane�ϣ���������ͼƬ�ϣ��������Ҫ����ͼƬ�ϲ��ܶ�
	  this.hammerView.setX(e.getX() - 60);
	  this.hammerView.setY(e.getY() - 80);
	  });
	  pane.getChildren().add(hammerView);
	  
	      

	Scene scene = new Scene(pane,1000,768);
	stage.setTitle("�����");
	stage.setScene(scene);
	stage.show();
	}


	public Line MouseAppear() {
	int ran = (int)(Math.random() * 10 * 0.9);
	double x0 = x1, y0 = y1;
	switch (ran) {
	case 0:
	x0 = x1; y0 = y1; break;
	case 1:
	x0 = x1 + xx - 20; y0 = y1; break;
	case 2:
	x0 = x1 + xx * 2 - 20; y0 = y1; break;	
	case 3:
	x0 = x1 - 50; y0 = y1 + yy - 15; break;
	case 4:
	x0 = x1 + xx - 20; y0 = y1 + yy; break;
	case 5:
	x0 = x1 + xx * 2 - 20; y0 = y1 + yy; break;
	case 6:
	x0 = x1 - 60; y0 = y1 + yy * 2 - 10; break;
	case 7:
	x0 = x1 + xx - 20; y0 = y1 + yy * 2; break;
	case 8:
	x0 = x1 + xx * 2; y0 = y1 + yy *2; break;
	}
	Line line = new Line(x0 , y0 + 30, x0, y0 - 50);
	line.setStroke(Color.TRANSPARENT);
	return line;
	}

	public static void main(String[] args) {
	Application.launch(args);
	}
	}
