package commonClasses;
/*
Name: Rajesh Upadhayaya
Class : CS351l

 */
import javafx.scene.Group;
import javafx.scene.layout.HBox;
 // constructor class.
public class Domino
{
    private int num1, num2;
    private HBox hBox;
//  domino constructor by passing i and j.
    public Domino(int n, int j, HBox hBox1) {
        this.setNum1(n);
        this.setNum2(j);
        this.setHBox(hBox1);

    }

// Domio constructor by passing  domino.
    public Domino (Domino d)
    {
        this.setNum1(d.num1);
        this.setNum2(d.num2);
        this.setHBox(d.hBox);

    }
    // get and set function
    public int getNum1()
    {
        return this.num1;
    }
    public HBox getHBox()
    {
        return this.hBox;
    }
    public int getNum2()
    {
        return this.num2;
    }
    public void setNum1(int n)
    {
        this.num1 = n;
    }
    public void setNum2(int n)
    {
        this.num2 = n;
    }
    public void setHBox(HBox h)
    {
        this.hBox = h;
    }
    // to string method.
    public String toString()
    {
        return String.format("[" + this.num1 + " | " + this.num2 + "]" );
    }

    //equal method to comapir domino.
    public Boolean equal(Domino d){
        Domino c = (Domino) d;
        return Integer.compare(num1, c.num1) == 0 || Integer.compare(num1, c.num2) == 0 || Integer.compare(num2, c.num1) == 0 || Integer.compare(num2, c.num2) == 0;
    }
    // to set equal to two domino.
    public Boolean dominoequal(Domino d){
        return Integer.compare(num1, d.num1) == 0 && Integer.compare(num2, d.num2) == 0;
    }
     // rotate domino.
    public void rotateDomino()
    {
        int holder;
        holder = this.num1;
        this.num1 = this.num2;
        this.num2 = holder;
        Group group1 = (Group) this.getHBox().getChildren().get(0);
        Group group2 = (Group) this.getHBox().getChildren().get(1);
        HBox hBox = new HBox(1,group2,group1);
        this.hBox= hBox;

    }

    // getting the value of the domino.
    public int getValue()
    {
        int total;
        total = this.num1 + this.num2;
        return total;
    }


}
