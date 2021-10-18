/*
Name: Rajesh Upadhayaya
Class : CS351l

 */
package guiDomio;
import commonClasses.Domino;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static guiDomio.guiDomin.gDomino;
import static consoleDomino.Main.*;
import static guiDomio.humanGui.humanG;

// thi class is for the gui version.  i have  use the mouse pointer as
//  to add  domino to the left and the right side of the played domino.
public class guiMain extends Application {
    public static HBox hBox = new HBox(10);
    public static HBox finalHbox = new HBox(10);
    public static VBox labelVbox = new VBox(10);
    public static HBox winShowHbox = new HBox(10);
    public static boolean guiMainBoolean = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // gui main boolean is ture.
        guiMainBoolean= true;
        VBox vBox = new VBox(20);
        winShowHbox.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Hello World");
        gDomino();
        boneyard.createBoneYard();
        boneyard.shuffle();
         // give 7 dominoes to computer .
        for (int i = 0; i < 7; i++) {
            computer.drawDomino(boneyard);
        }

        for (int i = 0; i < 6; i++) {
            human.drawDomino(boneyard);
        }
         // label for ocmputer size and  boneyard.
        Label computerLabel = new Label("Computer contains " + computer.size());
        computerLabel.setFont(Font.font(20));
        computerLabel.setAlignment(Pos.CENTER);
        Label boneyardLabel = new Label("Boneyard contains " + boneyard.size());
        boneyardLabel.setFont(Font.font(20));
        boneyardLabel.setAlignment(Pos.CENTER);
        // vbox is created for the label show.
        labelVbox.getChildren().addAll(boneyardLabel, computerLabel);
        Label playerLabel = new Label("player");
        playerLabel.setFont(Font.font(20));
             // title ofe the game.
        Label title = new Label("Domino Game");
        title.setFont(Font.font(45));
        HBox titleBox = new HBox(title);
        titleBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(25, 25, 700, 200);
         // buttons draw . quit and  play button.
        Button drawButton = new Button("Draw from Boneyard");
        Button quitButton = new Button("quit.");
        // this quit the whole program.
        quitButton.setOnAction(event -> {
            System.exit(1);
        });
        // this draws a domino.
        //  it add a domino to human deck and runs throug human  boneyard
        //  and  calls @gameplay();
        drawButton.setOnAction(event -> {

            human.drawDomino(boneyard);

            hBox.getChildren().clear();
            for( int i=0 ;i<human.size();i++){
                hBox.getChildren().addAll(human.getDomino(i).getHBox());
            }

            Label updatdBoneyardla = new Label("Boneyard contains " + boneyard.size());
            updatdBoneyardla.setFont(Font.font(20));
            updatdBoneyardla.setAlignment(Pos.CENTER);
            labelVbox.getChildren().clear();
            labelVbox.getChildren().addAll(updatdBoneyardla, computerLabel);
            gamePlay();

        });

        Button play = new Button("Play");
        HBox playhBox= new HBox(10, play);
        playhBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(playhBox );
        // when play is pressed domino game starts.
        play.setOnAction(event -> {
            drawButton.fire();
            vBox.getChildren().addAll(titleBox, labelVbox, finalHbox, playerLabel, hBox, drawButton, quitButton,winShowHbox);
            play.setDisable(true);
        });
        //  to iterate over the human boneyard and add it as the Hbox  i hbox.
        for (int i = 0; i < human.size(); i++) {
            hBox.getChildren().addAll(human.getDomino(i).getHBox());
        }
        // added to playing board.
        finalHbox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        primaryStage.show();
        // it creates a  borderpane foe adding all the pane.
        BorderPane borderPane = new BorderPane(vBox);
        primaryStage.setScene(new Scene(borderPane, 300, 275));


    }

//   play all of my GUi m=game. it will iterate over the human play and calss the computer turn foem ai class for the computer.
    public static void gamePlay(){

        for (int i = 0; i < human.size(); i++) {
            Domino domino = human.getDomino(i);
             // on primary  button of mouse is pressed it will add the domino  to the  right side of the board.
            // and it check if the playing domino matche the board domino on right side by roatting .and it add that automatically.
             // it goes same for the left side.
            domino.getHBox().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    if (e.getButton() == MouseButton.PRIMARY) {
                         // calls the huamG method  of the humanGui class. that basically add a domino to human and then
                        // computer plays a domino matching to either side of the board.
                        humanG(domino, 'r');
                    } else if (e.getButton() == MouseButton.SECONDARY) {
                        humanG(domino, 'l');
                    }
                    // it just update the human hbox and dispaly them.
                    hBox.getChildren().clear();
                    for (int i = 0; i < human.size(); i++) {
                        hBox.getChildren().addAll(human.getDomino(i).getHBox());
                    }
                    // it update the labels . however it has a bug.
                    // somethies computer  domino number is not correctly shown but they are in correct  number.
                    Label updatdBoneyardla = new Label("Boneyard contains " + boneyard.size());
                    updatdBoneyardla.setFont(Font.font(20));
                    updatdBoneyardla.setAlignment(Pos.CENTER);
                    Label updatedComputerLabel = new Label("Computer contains " + computer.size());
                    updatedComputerLabel.setFont(Font.font(20));
                    labelVbox.getChildren().clear();
                    labelVbox.getChildren().addAll(updatdBoneyardla,updatedComputerLabel);
                    // check foe the game over and calls guiWinner method.
                    if(computer.size()==0|| human.size()==0 || boneyard.size()==0){
                        guiWinner();
                    }
                }
            });

        }}
        // checks the winner of ghe game.
        public static void guiWinner (){
            Label comWinLabe = new Label("!!!!  Computer win  !!!!");
            comWinLabe.setFont(Font.font(40));
            Label humWinLabe = new Label("!!!!  Human win  !!!!");
            humWinLabe.setFont(Font.font(40));
            if (human.valueOfBoneYard(human) == computer.valueOfBoneYard(computer)) {
                if (turnComputer == true) {
                    winShowHbox.getChildren().clear();
                    winShowHbox.getChildren().addAll(comWinLabe);
                } else {
                    winShowHbox.getChildren().clear();
                    winShowHbox.getChildren().addAll(humWinLabe);
                }
            } else if (human.valueOfBoneYard(human) >= computer.valueOfBoneYard(computer)) {
                winShowHbox.getChildren().clear();
                winShowHbox.getChildren().addAll(comWinLabe);
            } else if (human.valueOfBoneYard(human) <= computer.valueOfBoneYard(computer)) {
                winShowHbox.getChildren().clear();
                winShowHbox.getChildren().addAll(humWinLabe);
            }
        }

        // I try to use this method to print the board in two line using this method but i could not.
 public static VBox twoLine( HBox hbox44){
     Rectangle rectangle1 = new Rectangle(80,40);

     VBox hbox21= new VBox(10);
     VBox hbox22= new VBox(10,rectangle1 );
     for(int i=0 ; i<hbox44.getChildren().size();i++){
         if(i%2==0){
             hbox21.getChildren().addAll(hBox.getChildren().get(i));
         }else{
             hbox22.getChildren().addAll(hBox.getChildren().get(i));
         }
     }
      return new VBox(10, hbox21,hbox22);
     }

    }





