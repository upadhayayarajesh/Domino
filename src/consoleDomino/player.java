/*
Name: Rajesh Upadhayaya
Class : CS351l

 */
package consoleDomino;

import commonClasses.Domino;

import java.util.Scanner;

import static consoleDomino.Main.*;
import static commonClasses.ai.computerTurn;
// this calss is for the  human to play.
public class player {
    private static Scanner scanner = new Scanner(System.in);
    public static void humanTurn() {
        // quit to exuit;
        int quit = 0;
        print();
        System.out.println("Tray: " + human);
        System.out.println("Human's turn");
        System.out.println("[p] Play Domino \n[d] Draw from boneyard \n[q] Quit");
        char c = scanner.next().charAt(0);
        // to check for winner.
        if(human.size()==0 || boneyard.size()==0){
            winCheck(human,computer);
            // for play.
        }else if(c=='p'){
            System.out.println("Which domino?");
            int i= scanner.nextInt();
            Domino playingDomino= human.getDomino(i);
            System.out.println("Left or Right? (l/r)");
            char left_right = scanner.next().charAt(0);
            System.out.println("Rotate first? (y/n)");
            char y_n = scanner.next().charAt(0);
            // if rotate.
            if(y_n=='y'){
                playingDomino.rotateDomino();
            }
            // for the left play.
            if(left_right=='l'){
                // this check for the domino is valid or not.
                if(validDomino(playingDomino,table,left_right)){
                    System.out.println("playing "+playingDomino +" at left.");
                    table.addDomino(0,playingDomino);
                    human.removeDomino(i);

                }else{
                    // if  you play a invalid odmino.
                    System.out.println("please put a valid domino.");
                    humanTurn();
                }

            }else{
                if(validDomino(playingDomino,table,left_right)==true) {
                    System.out.println("playing "+playingDomino +" at right.");
                    table.addDomino(playingDomino);
                    human.removeDomino(i);
                }else{
                    System.out.println("please place a valid domino.");
                    humanTurn();
                }
            }
            // it goes to ai class for computer turn.
            computerTurn();
    // runt the class again by drawing a   domino form boneyard.
        }else if(c=='d'){
            human.drawDomino(boneyard);
            humanTurn();

        // checks  for the winner.
        }else if(c=='q'){
            winCheck(human,computer);
            gameover=true;
        }else {
            System.out.println("please Enter a valid input.");
            humanTurn();

        }

    }
}
