/*
Name: Rajesh Upadhayaya
Class : CS351l

 */
package guiDomio;
import commonClasses.Domino;
import javafx.scene.layout.HBox;
import static guiDomio.guiMain.hBox;
import static guiDomio.guiMain.finalHbox;
import static consoleDomino.Main.*;
import static commonClasses.ai.computerTurn;
// this class is to add a given domino to the eamthching choose sie of the game and to also calss the ai class to paly computer turn.
public class humanGui {
    public static void humanG(Domino domino, char l_r){
        HBox hBox1= new HBox(10,domino.getHBox());
        hBox1.setRotate(180);
        Domino rotateDomino= new Domino(domino.getNum2(), domino.getNum1(), hBox1);
        System.out.println( "human : "+ human);
        // when mouse is  secondary button is pressed it add the given domino to left side when it matches the board  by rotating also.
        if(l_r=='l'){
            if(validDomino(domino,table,l_r)==true){
                table.addDomino(0,domino);
                human.removeDomino(domino);
                System.out.println("left clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }
            }else if(validDomino(rotateDomino,table,l_r)==true){
                table.addDomino(0,rotateDomino);
                human.removeDomino(domino);

                System.out.println("left clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }


            }else{
                System.out.println("not a valid domino left");
                hBox.getChildren().clear();
                for(int i=0;i< human.size();i++){
                    hBox.getChildren().addAll(human.getDomino(i).getHBox());
                }
            }
            // when mouse is  primary button is pressed it add the given domino to right side when it matches the board  by rotating also.
        }else if(l_r=='r') {
            if(validDomino(domino,table,l_r)==true){
                table.addDomino(domino);
                human.removeDomino(domino);
                System.out.println("right clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }
            }else if(validDomino(rotateDomino,table,l_r)==true){
                table.addDomino(rotateDomino);
                human.removeDomino(domino);
                System.out.println("right clicked");
                computerTurn();
                finalHbox.getChildren().clear();
                for (int i = 0; i < table.size(); i++) {
                    finalHbox.getChildren().addAll(table.getDomino(i).getHBox());
                }

            }else{
                // it also prints for invalid domino  in  terminal.
                System.out.println(" not a valid domino ar right.");
            }

        }


    }
}
