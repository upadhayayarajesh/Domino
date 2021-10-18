
/*
Name: Rajesh Upadhayaya
Class : CS351l

 */
package consoleDomino;

import commonClasses.Boneyard;
import commonClasses.Domino;

import static guiDomio.guiDomin.gDomino;
import static consoleDomino.player.humanTurn;

public class Main {

    // this  is the boneyard  consisting of 28 dominoes.
    public static Boneyard boneyard = new Boneyard();
    // human boneyard.
    public static Boneyard human = new Boneyard();
     // computer boneyard.
    public static Boneyard computer = new Boneyard();
    // boneyard to  keep track of played domino.
    public static Boneyard table = new Boneyard();
     // boolean to keep track of the game over and whose turn is it.
    public static boolean gameover= false;
    public static boolean turnComputer= false;

    // main method.
    public static void main(String[] args) {
        gDomino();
        System.out.println("Welcome Dominos!");
         //creates and shuffle the deck and give 7 dominoes to human and computer.
        boneyard.createBoneYard();
        boneyard.shuffle();
        for ( int i=0 ; i<7;i++){
            human.drawDomino(boneyard);
            computer.drawDomino(boneyard);
        }
         // calls the humanturn of the player class.
        humanTurn();

    }
     // print  for the prinbg of tray ans computer size.
    public static void print(){
        System.out.println();
        System.out.println(table.tableToString());
        System.out.println("computer has "+computer.size()+ " dominos");
        System.out.println("Boneyard contains "+boneyard.size()+ " dominos\n");


    }
    // method to check for the valid domino or not to  play game.
    public static boolean validDomino(Domino domino , Boneyard boneyard , char l_r){
        boolean result=false;
        if(boneyard.size()==0){ result= true;
        }else {
            if (l_r=='l' ){
                if(boneyard.getDomino(0).getNum1() == domino.getNum2()|| domino.getNum2()==0)
                { result = true; }
            }else if (l_r=='r' )
                if(boneyard.lastDomino().getNum2() == domino.getNum1() || domino.getNum1()==0)
                { result = true; }
        }return result;
    }
    // method to  check for winner.
    public static void winCheck(Boneyard human, Boneyard computer) {
        if (human.valueOfBoneYard(human) == computer.valueOfBoneYard(computer)) {
            if(turnComputer==true){
                System.out.println("Computer wins.");
            }else{
                System.out.println("Human wins.");
            }
        } else if (human.valueOfBoneYard(human) >= computer.valueOfBoneYard(computer)) {
            System.out.println("Computer wins.");
        } else if (human.valueOfBoneYard(human) <= computer.valueOfBoneYard(computer)) {
            System.out.println("Human wins.");
        }
    }
}
