import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.application.Platform;

public class Game extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws FileNotFoundException {    
    Pane pane = new Pane();
    Rectangle rectangle = new Rectangle(0, 0, 500, 650);
    rectangle.setFill(Color.BLACK);
    rectangle.setStroke(Color.BLACK);
    pane.getChildren().add(rectangle);
    
    Circle circle = null;
    for(int i=1;i<=60;i++) {
    	circle = new Circle((Math.random()*491),(Math.random()*641),0.5);
    	circle.setFill(Color.WHITE);
    	circle.setStroke(Color.WHITE);
    	pane.getChildren().add(circle);
    }
    
    //Initializing score
    int totalScore = 0;
    
    //Creating an image 
    Image image = new Image(new FileInputStream("C:/Users/Adams/Downloads/SpaceShooter-java-main/SpaceShooter/src/Spaceship.png"));  
    
    //Setting the image view 
    ImageView spaceship = new ImageView(image); 
    Image smallEnemyShipImage = new Image(new FileInputStream("C:/Users/Adams/Downloads/SpaceShooter-java-main/SpaceShooter/src/smallEnemyShip.png")); 
    Image laserImage = new Image(new FileInputStream("C:/Users/Adams/Downloads/SpaceShooter-java-main/SpaceShooter/src/Laser.png"));    
    
    //Add text for wave completed
    Text finishText = new Text();
    finishText.setText("Wave Complete!");
    finishText.setX(150);
    finishText.setY(200);
    finishText.setFont(Font.font("Roboto", 30));
    finishText.setFill(Color.WHITE);
    finishText.setOpacity(0.0);
    
    //Add button to restart game
    Button restartButton = new Button();
    restartButton.setText("Restart Wave");
    restartButton.setTranslateX(200);
    restartButton.setTranslateY(400);
    restartButton.setOpacity(0.0);
    
    //Setting the position and size of the spaceship
    spaceship.setX(220); 
    spaceship.setY(590);
    spaceship.setFitWidth(60);
    spaceship.setFitHeight(60);
    
    //Add hitbox for the ship
    Rectangle shipHitBox = new Rectangle(57,57);
    shipHitBox.setX(220);
    shipHitBox.setY(590);
    shipHitBox.setOpacity(0);
    
    //Create enemy ships
    ImageView smallEnemyShip1 = new ImageView(smallEnemyShipImage);
    smallEnemyShip1.setX(400);
    smallEnemyShip1.setY(-35);
    smallEnemyShip1.setFitWidth(35);
    smallEnemyShip1.setFitHeight(35);
    
    ImageView smallEnemyShip2 = new ImageView(smallEnemyShipImage);
    smallEnemyShip2.setX(400);
    smallEnemyShip2.setY(-35);
    smallEnemyShip2.setFitWidth(35);
    smallEnemyShip2.setFitHeight(35);
    
    ImageView smallEnemyShip3 = new ImageView(smallEnemyShipImage);
    smallEnemyShip3.setX(400);
    smallEnemyShip3.setY(-35);
    smallEnemyShip3.setFitWidth(35);
    smallEnemyShip3.setFitHeight(35);
    
    ImageView smallEnemyShip4 = new ImageView(smallEnemyShipImage);
    smallEnemyShip4.setX(400);
    smallEnemyShip4.setY(-35);
    smallEnemyShip4.setFitWidth(35);
    smallEnemyShip4.setFitHeight(35);
    
    ImageView smallEnemyShip5 = new ImageView(smallEnemyShipImage);
    smallEnemyShip5.setX(400);
    smallEnemyShip5.setY(-35);
    smallEnemyShip5.setFitWidth(35);
    smallEnemyShip5.setFitHeight(35);
    
    ImageView smallEnemyShip6 = new ImageView(smallEnemyShipImage);
    smallEnemyShip6.setX(400);
    smallEnemyShip6.setY(-35);
    smallEnemyShip6.setFitWidth(35);
    smallEnemyShip6.setFitHeight(35);
    
    ImageView smallEnemyShip7 = new ImageView(smallEnemyShipImage);
    smallEnemyShip7.setX(400);
    smallEnemyShip7.setY(-35);
    smallEnemyShip7.setFitWidth(35);
    smallEnemyShip7.setFitHeight(35);
    
    ImageView smallEnemyShip8 = new ImageView(smallEnemyShipImage);
    smallEnemyShip8.setX(400);
    smallEnemyShip8.setY(-35);
    smallEnemyShip8.setFitWidth(35);
    smallEnemyShip8.setFitHeight(35);
    
    ImageView smallEnemyShip9 = new ImageView(smallEnemyShipImage);
    smallEnemyShip9.setX(400);
    smallEnemyShip9.setY(-35);
    smallEnemyShip9.setFitWidth(35);
    smallEnemyShip9.setFitHeight(35);
    
    ImageView smallEnemyShip10 = new ImageView(smallEnemyShipImage);
    smallEnemyShip10.setX(400);
    smallEnemyShip10.setY(-35);
    smallEnemyShip10.setFitWidth(35);
    smallEnemyShip10.setFitHeight(35);
    
    //Create enemy ship hitboxes
    Rectangle smallEnemyShipHitBox1 =new Rectangle(35,35);
    smallEnemyShipHitBox1.setX(300);
    smallEnemyShipHitBox1.setY(800);
    smallEnemyShipHitBox1.setOpacity(0);
    smallEnemyShipHitBox1.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox2 = new Rectangle(35,35);
    smallEnemyShipHitBox2.setX(300);
    smallEnemyShipHitBox2.setY(800);
    smallEnemyShipHitBox2.setOpacity(0);
    smallEnemyShipHitBox2.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox3 = new Rectangle(35,35);
    smallEnemyShipHitBox3.setX(300);
    smallEnemyShipHitBox3.setY(800);
    smallEnemyShipHitBox3.setOpacity(0);
    smallEnemyShipHitBox3.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox4 = new Rectangle(35,35);
    smallEnemyShipHitBox4.setX(300);
    smallEnemyShipHitBox4.setY(800);
    smallEnemyShipHitBox4.setOpacity(0);
    smallEnemyShipHitBox4.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox5 = new Rectangle(35,35);
    smallEnemyShipHitBox5.setX(300);
    smallEnemyShipHitBox5.setY(800);
    smallEnemyShipHitBox5.setOpacity(0);
    smallEnemyShipHitBox5.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox6 = new Rectangle(35,35);
    smallEnemyShipHitBox6.setX(300);
    smallEnemyShipHitBox6.setY(800);
    smallEnemyShipHitBox6.setOpacity(0);
    smallEnemyShipHitBox6.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox7 = new Rectangle(35,35);
    smallEnemyShipHitBox7.setX(300);
    smallEnemyShipHitBox7.setY(800);
    smallEnemyShipHitBox7.setOpacity(0);
    smallEnemyShipHitBox7.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox8 = new Rectangle(35,35);
    smallEnemyShipHitBox8.setX(300);
    smallEnemyShipHitBox8.setY(800);
    smallEnemyShipHitBox8.setOpacity(0);
    smallEnemyShipHitBox8.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox9 = new Rectangle(35,35);
    smallEnemyShipHitBox9.setX(300);
    smallEnemyShipHitBox9.setY(800);
    smallEnemyShipHitBox9.setOpacity(0);
    smallEnemyShipHitBox9.setFill(Color.BLACK);
    
    Rectangle smallEnemyShipHitBox10 = new Rectangle(35,35);
    smallEnemyShipHitBox10.setX(300);
    smallEnemyShipHitBox10.setY(800);
    smallEnemyShipHitBox10.setOpacity(0);
    smallEnemyShipHitBox10.setFill(Color.BLACK);
    
    //Add laser hitboxes
    Rectangle laserHitBox = new Rectangle(12, 15);
    laserHitBox.setX(100);
    laserHitBox.setY(800);
    Rectangle laserHitBox2 = new Rectangle(12, 15);
    laserHitBox2.setX(100);
    laserHitBox2.setY(800);
    Rectangle laserHitBox3 = new Rectangle(12, 15);
    laserHitBox3.setX(100);
    laserHitBox3.setY(800);
    
    //Transitions for enemy ships
    Circle cp1 = new Circle();
    cp1.setRadius(250);
    cp1.setCenterX(200);
    cp1.setCenterY(-20);
    cp1.setStroke(Color.BLACK);
    cp1.setFill(null);
    
    Circle cp2 = new Circle();
    cp2.setRadius(250);
    cp2.setCenterX(220);
    cp2.setCenterY(-20);
    cp2.setStroke(Color.BLACK);
    cp2.setFill(null);
    
    Line cp3 = new Line(-15,300,650,600);
    cp3.setStroke(Color.BLACK);
    
    Line cp4 = new Line(650,300,-15,600);
    cp4.setStroke(Color.BLACK);
    
    Circle cp5 = new Circle();
    cp5.setRadius(300);
    cp5.setCenterX(300);
    cp5.setCenterY(-20);
    cp5.setStroke(Color.BLACK);
    cp5.setFill(null);
    
    PathTransition pt1 = new PathTransition(Duration.seconds(8.5), cp1, smallEnemyShip1);
    pt1.setDelay(Duration.seconds(0.5));
    pt1.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip1);
    });
    
    PathTransition ptHitBox1 = new PathTransition(Duration.seconds(8.5), cp1, smallEnemyShipHitBox1);
    ptHitBox1.setDelay(Duration.seconds(0.5));
    ptHitBox1.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox1);
    });
    
    PathTransition pt2 = new PathTransition(Duration.seconds(9), cp1, smallEnemyShip2);
    pt2.setDelay(Duration.seconds(1));
    pt2.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip2);
    });
    
    PathTransition ptHitBox2 = new PathTransition(Duration.seconds(9), cp1, smallEnemyShipHitBox2);
    ptHitBox2.setDelay(Duration.seconds(1));
    ptHitBox2.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox2);
    });
    
    PathTransition pt3 = new PathTransition(Duration.seconds(8), cp2, smallEnemyShip3);
    pt3.setDelay(Duration.seconds(1));
    pt3.jumpTo(Duration.seconds(8));
    pt3.setRate(-1.0);
    pt3.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip3);
    });
    
    PathTransition ptHitBox3 = new PathTransition(Duration.seconds(8), cp2, smallEnemyShipHitBox3);
    ptHitBox3.setDelay(Duration.seconds(1));
    ptHitBox3.jumpTo(Duration.seconds(8));
    ptHitBox3.setRate(-1.0);
    ptHitBox3.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox3);
    });
    
    PathTransition pt4 = new PathTransition(Duration.seconds(8), cp2, smallEnemyShip3);
    pt4.setDelay(Duration.seconds(3));
    pt4.jumpTo(Duration.seconds(8));
    pt4.setRate(-1.0);
    pt4.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip4);
    });
    
    PathTransition ptHitBox4 = new PathTransition(Duration.seconds(8), cp2, smallEnemyShipHitBox3);
    ptHitBox4.setDelay(Duration.seconds(3));
    ptHitBox4.jumpTo(Duration.seconds(8));
    ptHitBox4.setRate(-1.0);
    ptHitBox4.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox4);
    });
    
    PathTransition pt5 = new PathTransition(Duration.seconds(4), cp3, smallEnemyShip5);
    pt5.setDelay(Duration.seconds(11));
    pt5.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip5);
    });
    
    PathTransition ptHitBox5 = new PathTransition(Duration.seconds(4), cp3, smallEnemyShipHitBox5);
    ptHitBox5.setDelay(Duration.seconds(11));
    ptHitBox5.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox5);
    });
    
    PathTransition pt6 = new PathTransition(Duration.seconds(4), cp4, smallEnemyShip6);
    pt6.setDelay(Duration.seconds(12));
    pt6.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip6);
    });
    
    PathTransition ptHitBox6 = new PathTransition(Duration.seconds(4), cp4, smallEnemyShipHitBox6);
    ptHitBox6.setDelay(Duration.seconds(12));
    ptHitBox6.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox6);
    });
    
    PathTransition pt7 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShip7);
    pt7.setDelay(Duration.seconds(15));
    pt7.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip7);
    });
    
    PathTransition ptHitBox7 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShipHitBox7);
    ptHitBox7.setDelay(Duration.seconds(15));
    ptHitBox7.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox7);
    });
    
    PathTransition pt8 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShip8);
    pt8.setDelay(Duration.seconds(16));
    pt8.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip8);
    });
    
    PathTransition ptHitBox8 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShipHitBox8);
    ptHitBox8.setDelay(Duration.seconds(16));
    ptHitBox8.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox8);
    });
    
    PathTransition pt9 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShip9);
    pt9.setDelay(Duration.seconds(17));
    pt9.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip9);
    });
    
    PathTransition ptHitBox9 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShipHitBox9);
    ptHitBox9.setDelay(Duration.seconds(17));
    ptHitBox9.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox9);
    });
    
    PathTransition pt10 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShip10);
    pt10.setDelay(Duration.seconds(18));
    pt10.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShip10);
    });
    
    PathTransition ptHitBox10 = new PathTransition(Duration.seconds(6), cp5, smallEnemyShipHitBox10);
    ptHitBox10.setDelay(Duration.seconds(18));
    ptHitBox10.setOnFinished(evt -> {
    	pane.getChildren().remove(smallEnemyShipHitBox10);
    	finishGame(pane, totalScore, finishText, restartButton);
    });
    
    //Play enemy ship movements
    pt1.play();
    ptHitBox1.play();
    pt2.play();
    ptHitBox2.play();
    pt3.play();
    ptHitBox3.play();
    pt4.play();
    ptHitBox4.play();
    pt5.play();
    ptHitBox5.play();
    pt6.play();
    ptHitBox6.play();
    pt7.play();
    ptHitBox7.play();
    pt8.play();
    ptHitBox8.play();
    pt9.play();
    ptHitBox9.play();
    pt10.play();
    ptHitBox10.play();
    
    //Add text for a player score
    Text score = new Text("Score: " + totalScore);
    score.setFont(Font.font("Roboto", 20));
    score.setFill(Color.WHITE);
    score.setX(10);
    score.setY(20);
    
    //Add images to pane
    pane.getChildren().add(spaceship);
    pane.getChildren().add(shipHitBox);
    pane.getChildren().addAll(cp1,cp2,cp3,cp4,cp5);
    pane.getChildren().addAll(smallEnemyShip1,smallEnemyShip2,smallEnemyShip3,smallEnemyShip4,smallEnemyShip5,smallEnemyShip6,smallEnemyShip7,smallEnemyShip8,smallEnemyShip9,smallEnemyShip10);
    pane.getChildren().addAll(smallEnemyShipHitBox1,smallEnemyShipHitBox2,smallEnemyShipHitBox3,smallEnemyShipHitBox4,smallEnemyShipHitBox5,smallEnemyShipHitBox6,smallEnemyShipHitBox7,smallEnemyShipHitBox8,smallEnemyShipHitBox9,smallEnemyShipHitBox10);
    pane.getChildren().addAll(score,finishText,restartButton);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 500, 650);
    primaryStage.setTitle("Space Shooter"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    	
    // Listener for mouse to move ship and ship hitbox where mouse is
    borderPane.setOnMouseMoved(evt -> {
    	spaceship.setX(evt.getX()-25);
    	shipHitBox.setX(evt.getX()-25);
    });
    
    //Set up transitions
    TranslateTransition tt = new TranslateTransition(Duration.seconds(0.55));
    TranslateTransition tl = new TranslateTransition(Duration.seconds(0.55));
    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.55));
    TranslateTransition tl2 = new TranslateTransition(Duration.seconds(0.55));
    TranslateTransition tt3 = new TranslateTransition(Duration.seconds(0.55));
    TranslateTransition tl3 = new TranslateTransition(Duration.seconds(0.55));
	ImageView laser = new ImageView(laserImage);
//	ImageView laser2 = new ImageView(laserImage);
//	ImageView laser3 = new ImageView(laserImage);
	
    //Add timeline to check for collisions
    HashMap<Integer, Rectangle> enemies = new HashMap<Integer, Rectangle>();
    enemies.put(1, smallEnemyShipHitBox1);
    enemies.put(2, smallEnemyShipHitBox2);
    enemies.put(3, smallEnemyShipHitBox3);
    enemies.put(4, smallEnemyShipHitBox4);
    enemies.put(5, smallEnemyShipHitBox5);
    enemies.put(6, smallEnemyShipHitBox6);
    enemies.put(7, smallEnemyShipHitBox7);
    enemies.put(8, smallEnemyShipHitBox8);
    enemies.put(9, smallEnemyShipHitBox9);
    enemies.put(10, smallEnemyShipHitBox10);
    
    Timeline animation = new Timeline();
    KeyFrame keyframe = new KeyFrame(Duration.seconds(1000/60), e -> checkCollision(enemies, laserHitBox, shipHitBox, totalScore, score, pane));
    animation.getKeyFrames().addAll(keyframe);
    animation.setCycleCount(Animation.INDEFINITE);
    animation.play();
    
    AnimationTimer timer;
    
    //Random number for shooting enemy lasers
    double randomNumber = Math.random() * 7 + 1;
    
    //Animation Timer to run game events
    timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int hitCheck = checkCollision(enemies, laserHitBox, shipHitBox, totalScore, score, pane);
            if(hitCheck < 0) {
            	animation.stop();
            	tt.stop();
            	tl.stop();
            	pt1.stop();
                ptHitBox1.stop();
                pt2.stop();
                ptHitBox2.stop();
                pt3.stop();
                ptHitBox3.stop();
                pt4.stop();
                ptHitBox4.stop();
                pt5.stop();
                ptHitBox5.stop();
                pt6.stop();
                ptHitBox6.stop();
                pt7.stop();
                ptHitBox7.stop();
                pt8.stop();
                ptHitBox8.stop();
                pt9.stop();
                ptHitBox9.stop();
                pt10.stop();
                ptHitBox10.stop();
            }
            try {
				fireEnemyLaser(randomNumber, pane);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        }
    };
    timer.start();

    boolean hasFired = false;
    // Listener to shoot ship laser
    borderPane.setOnMouseClicked(evt -> 
    {
    	if(!pane.getChildren().contains(laser) && !hasFired) {
    		//Cleanup of previously fired laser
        	pane.getChildren().remove(laser);
        	pane.getChildren().remove(laserHitBox);
        	tt.stop();
        	tl.stop();
	        //Placing laser on screen
	        laser.setX(evt.getX());
	        laser.setY(575);
	        laser.setFitWidth(10);
	        laser.setFitHeight(15);
	        
	        //Placing laser hit box on screen
	        laserHitBox.setX(evt.getX());
	        laserHitBox.setY(575);
	        laserHitBox.setOpacity(0);
	        
	        //Add laser and hitbox to pane
	        pane.getChildren().add(laser);
	        pane.getChildren().add(laserHitBox);
	        
	        //Use TranslateTransition to move laser
	        tt.setFromY(0);
	        tt.setByY(-600);
	        tt.setAutoReverse(false);
	        tt.setCycleCount(1);
	        tt.setNode(laser);
	        tt.setOnFinished(event -> {
	        	pane.getChildren().remove(laser);
	        });
	        
	        //TranslateTransition to move laser hitbox
	        tl.setFromY(0);
	        tl.setByY(-600);
	        tl.setAutoReverse(false);
	        tl.setCycleCount(1);
	        tl.setNode(laserHitBox);
	        tl.setOnFinished(event -> {
	        	pane.getChildren().remove(laserHitBox);
	        });
	        
	        //Play Animations
	        tt.play();
	        tl.play();
    	}
//    	  } else if(!pane.getChildren().contains(laser2) && !hasFired) {
//    		//Cleanup of previously fired laser
//          	pane.getChildren().remove(laser2);
//          	pane.getChildren().remove(laserHitBox2);
//          	tt2.stop();
//          	tl2.stop();
//    		//Placing laser on screen
//  	        laser2.setX(evt.getX());
//  	        laser2.setY(575);
//  	        laser2.setFitWidth(10);
//  	        laser2.setFitHeight(15);
//  	        
//  	        //Placing laser hit box on screen
//  	        laserHitBox2.setX(evt.getX());
//  	        laserHitBox2.setY(575);
//  	        laserHitBox2.setOpacity(0);
//  	        
//  	        //Add laser and hitbox to pane
//  	        pane.getChildren().add(laser2);
//  	        pane.getChildren().add(laserHitBox2);
//  	        
//  	        //Use TranslateTransition to move laser
//  	        tt2.setFromY(0);
//  	        tt2.setByY(-600);
//  	        tt2.setAutoReverse(false);
//  	        tt2.setCycleCount(1);
//  	        tt2.setNode(laser);
//  	        tt2.setOnFinished(event -> {
//  	        	pane.getChildren().remove(laser);
//  	        });
//  	        
//  	        //TranslateTransition to move laser hitbox
//  	        tl2.setFromY(0);
//  	        tl2.setByY(-600);
//  	        tl2.setAutoReverse(false);
//  	        tl2.setCycleCount(1);
//  	        tl2.setNode(laserHitBox);
//  	        tl2.setOnFinished(event -> {
//  	        	pane.getChildren().remove(laserHitBox);
//  	        });
//  	        
//  	        //Play Animations
//  	        tt2.play();
//  	        tl2.play();
//    	  } else if(!hasFired) {
//    		//Cleanup of previously fired laser
//          	pane.getChildren().remove(laser3);
//          	pane.getChildren().remove(laserHitBox3);
//          	tt3.stop();
//          	tl3.stop();
//    		//Placing laser on screen
//	        laser3.setX(evt.getX());
//	        laser3.setY(575);
//	        laser3.setFitWidth(10);
//	        laser3.setFitHeight(15);
//	        
//	        //Placing laser hit box on screen
//	        laserHitBox3.setX(evt.getX());
//	        laserHitBox3.setY(575);
//	        laserHitBox3.setOpacity(0);
//	        
//	        //Add laser and hitbox to pane
//	        pane.getChildren().add(laser3);
//	        pane.getChildren().add(laserHitBox3);
//	        
//	        //Use TranslateTransition to move laser
//	        tt3.setFromY(0);
//	        tt3.setByY(-600);
//	        tt3.setAutoReverse(false);
//	        tt3.setCycleCount(1);
//	        tt3.setNode(laser);
//	        tt3.setOnFinished(event -> {
//	        	pane.getChildren().remove(laser);
//	        });
//	        
//	        //TranslateTransition to move laser hitbox
//	        tl3.setFromY(0);
//	        tl3.setByY(-600);
//	        tl3.setAutoReverse(false);
//	        tl3.setCycleCount(1);
//	        tl3.setNode(laserHitBox);
//	        tl3.setOnFinished(event -> {
//	        	pane.getChildren().remove(laserHitBox);
//	        });
//	        
//	        //Play Animations
//	        tt3.play();
//	        tl3.play();
//    	  }
    });
    
    //Listener for pushing restart button
    restartButton.setOnMouseClicked(evt -> {
    	primaryStage.close();
    	Platform.runLater( () -> {
			try {
				new Game().start( new Stage() );
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		} );
    });
  }
  
  //Collision Detection Sample
  // Collision scenarios: laser hitting enemy, enemy laser hitting ship
  // enemy hitting ship
  // hitboxes: laserHitBox, shipHitBox, smallEnemyShipHitBox
  public int checkCollision(HashMap<Integer, Rectangle> enemies, Rectangle laserHitBox, Rectangle shipHitBox, int totalScore, Text score, Pane pane) {
	  int enemiesHit = 0;
	  for (int i = 1; i <= 10; i++) {
		  Object currentCheck = enemies.get(i);
		  Node currentCheck1 = (Node) currentCheck;
		  if (laserHitBox.getBoundsInParent().intersects(currentCheck1.getBoundsInParent())) {
			  //Make a fade transition to show enemy is gone
			  FadeTransition ft = new FadeTransition();
			  ft.setNode(currentCheck1);
			  ft.setDuration(Duration.millis(50));
			  ft.setFromValue(0.0);
			  ft.setToValue(1.0);
			  
			  ft.play();
		  }
		  if (shipHitBox.getBoundsInParent().intersects(currentCheck1.getBoundsInParent())) {
			  totalScore = -1;
		  }
		  if(enemies.get(i).getOpacity() == 1.0) {
			  enemiesHit++;
		  }
	  }
	  totalScore = 100 * enemiesHit;
	  score.setText("Score: " + totalScore);
	  return totalScore;
  }
  
  //Method to fire enemy lasers
  public void fireEnemyLaser(double randomNumber, Pane pane) throws FileNotFoundException {
	  //Setting up laser and hitbox
	  Image laserImage = new Image(new FileInputStream("C:/Users/Adams/Downloads/SpaceShooter-java-main/SpaceShooter/src/Laser.png"));
	  ImageView laser = new ImageView(laserImage);
	  laser.setX(400);
	  laser.setY(800);
	  Rectangle laserHitBox = new Rectangle(4, 15);
      laserHitBox.setX(400);
      laserHitBox.setY(800);
      laserHitBox.setFill(Color.BLUE);
      
      //Creating a randomly timed transition
      TranslateTransition tt = new TranslateTransition(Duration.seconds(0.75));
      //Use TranslateTransition to move laser
      tt.setFromY(0);
      tt.setByY(800);
      tt.setAutoReverse(false);
      tt.setCycleCount(1);
      tt.setNode(laser);
      tt.setOnFinished(event -> {
      	pane.getChildren().remove(laser);
      });
  }
  
  public void finishGame(Pane pane, int totalScore, Text finishText, Button restartButton) {
	  finishText.setOpacity(1.0);
	  restartButton.setOpacity(1.0);
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
