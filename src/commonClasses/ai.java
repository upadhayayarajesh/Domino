package commonClasses;
/*
Name: Rajesh Upadhayaya
Class : CS351l

 */
import static guiDomio.guiDomin.newList;
import static guiDomio.guiMain.guiMainBoolean;
import static guiDomio.guiMain.guiWinner;
import static consoleDomino.Main.*;
import static consoleDomino.player.humanTurn;

// this class  is to  for the both version of  domino game.
// this class is basically computer class that select a domino and play a domino game
public class ai {
    // this method is for the computer to add a domino to a boneyard.
    public static void computerTurn(){
        // to check the last player is computer or not.
        turnComputer=true;
        print();
        // creating a defaul playing domino.
        Domino playingDomino= new Domino( 0,0,newList.get(0));
        System.out.println("Tray: "+ computer);
        System.out.println("Computer’s turn");
        // looping over the computer boneyard to select a domino.
        int i=0;
        int counter=0;
        while(i< computer.size()){
            // checks the  num1 of left part of table with  the computer domino.
            if(table.getDomino(table.size()-1).getNum2()==computer.getDomino(i).getNum1()){
                playingDomino= computer.getDomino(i);
                System.out.println("playing "+ playingDomino+ " at right.");
                table.addDomino(playingDomino);
                counter+=1;
            }else if (table.getDomino(table.size()-1).getNum2()==computer.getDomino(i).getNum2()){
                playingDomino= computer.getDomino(i);
                playingDomino.rotateDomino();
                counter+=1;
                System.out.println("playing "+ playingDomino+ " at right.");
                table.addDomino(playingDomino);
            }else if (table.getDomino(0).getNum1()==computer.getDomino(i).getNum2()){
                playingDomino= computer.getDomino(i);
                System.out.println("playing "+ playingDomino+ " at left.");
                counter+=1;
                table.addDomino(0,playingDomino);
            }else if(table.getDomino(0).getNum1()==computer.getDomino(i).getNum1()) {
                playingDomino = computer.getDomino(i);
                playingDomino.rotateDomino();
                System.out.println("playing " + playingDomino + " at left.");
                counter+=1;
                table.addDomino(0,playingDomino);
            }else if (computer.getDomino(i).getNum1()==0){
                playingDomino = computer.getDomino(i);
                System.out.println("playing " + playingDomino + " at right.");
                counter+=1;
                table.addDomino(playingDomino);
            }
            // this is to remove the domino from computer and added it to table.
            if(counter!=0){

                computer.removeDomino(i);
                break;
            }
            i+=1;
        }
        // this is to  draw a domino if the computer's domino doesnot matches with the table.
         if(counter==0){
             computer.drawDomino(boneyard);
             computerTurn();
         }
        // to check for winner.
        if(computer.size()==0|| human.size()==0 || boneyard.size()==0){
            winCheck(human,computer);
            gameover=true;
        }
        // this is to  check for winner.
        if(computer.size()==0|| human.size()==0 || boneyard.size()==0){
            guiWinner();
        }
        // this is to a for console only foe the human turn.
        if(gameover==false &&guiMainBoolean==false) {
            humanTurn();
        }
    }

}
