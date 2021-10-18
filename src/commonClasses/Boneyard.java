package commonClasses;
/*
Name: Rajesh Upadhayaya
Class : CS351l
 */
import java.util.ArrayList;
import java.util.Random;

import static guiDomio.guiDomin.newList;
// boneyard  to create the 28 dominos.
public class Boneyard {
    private ArrayList<Domino> dominos;
    // boneyard constructor.
    public Boneyard(){
        this.dominos= dominos;
        dominos= new ArrayList<Domino>();
    }
    // creating 28 dominos.
    public  void createBoneYard(){

            int flag=0;
        for ( int num1=0;num1<7;num1++){
          for( int num2=num1;num2<7;num2++){
                  dominos.add(new Domino(num1, num2, newList.get(flag)));
                  flag += 1;
          }
        }

    }
    // method to print for two line.
    public String tableToString(){
        String tray= " ";
        String tray1= "       ";
        for(int i=0; i<dominos.size();i++){
            if(i%2==0){
                tray+=dominos.get(i);
            }else{
                tray1+=dominos.get(i);
            }
        }
        tray+="\n";
        return tray+tray1;
    }
     // toString for print.
    public String toString(){
        String tray="[";
        for(Domino aDomino: dominos){
            tray+= aDomino+ " ";
        }

        return tray+" ]";
    }
    // shuffle the boneyard.
    public void shuffle(){
        ArrayList<Domino> newBoneYard = new ArrayList<Domino>();
        Random rand= new Random();
        int randomCardIndex;
        int originaSize=dominos.size();
        for(int i=0; i<originaSize;i++){
            randomCardIndex =rand.nextInt((dominos.size()-1)+1);
            newBoneYard.add(dominos.get(randomCardIndex));
            dominos.remove(randomCardIndex);
        }
        dominos=newBoneYard;
    }
    // get domino by passing  int.
    public Domino getDomino(int i){
        return dominos.get(i);
    }
    //  method to add doinot by passing a domino to boneyard.
    public void addDomino(Domino addDomino){
        dominos.add(addDomino);
    }
     //adding the domino to given index method.
    public void addDomino(int index, Domino domino){
        dominos.add(index,domino);
    }
    // draw Domino from boneyard.

    public void drawDomino(Boneyard boneyard){
        dominos.add(boneyard.getDomino(0));
        boneyard.removeDomino(0);
    }

    // size of domino.
    public int size(){
        return dominos.size();
    }
    public void removeDomino(int i ){
         dominos.remove(i);

    }
     // method to get last domino.
    public Domino lastDomino(){
        return dominos.get(dominos.size()-1);
    }
    // method to remove domino.
    public void removeDomino(Domino domino ){
         dominos.remove(domino);

    }
    // method to get the value of boneyard.
    public int valueOfBoneYard( Boneyard boneyard){
        int value=0;
        for(int i=0 ;i<boneyard.size();i++){
            value+=boneyard.getDomino(i).getValue();

        }
        return value;
    }
}
