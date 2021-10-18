I have created the  three package.They are commonClasses, consoleDomino and guiDomino.
package:Commonclasses 
In commonclasses ,I have written three classes ai, Boneyard, Domino. In ai class,
  is for the computer to play domino.Created  computer turn method that will add a mathcing domino to the given  board on eather side.
 for Domino class. takes three  value num1, num2 and a Hbox containing the domino .
  many different  method to use when needed. like drawDomino to take a domino from boneyard, eqyals to compair domino.
In the boneyard class, take an array consists of 28 dominoes. boneyard class consists of several other method that is used  in other static methods.
package:consoleDomino
In  console Domino there are two calsses main and player.
Class:main, it consistes of  print,validDomino,winCheck. print method print the tray and computer size. 
wincheck method check for the winner providing the human and computer boneyard. and finally 
validDomino method takes a domino and boneyard and a char  to show if it is in right or left.
 it checks if the given domino matches the boneyard  at the given corner.

Class:player,
 HumanTurn. it asks for the play or draw or quit. on play it will place a domino in the table and then also checks for
 if it is the valid domino or not. and also for the draw form boneyard part. it  draw a card from bomneyard and then it
 runs that mehtod again and on quit it quit the program.

package: guidomino
  It consists of all the code to run the guiDomino in three class.
CLASS:guiDomino,
 in Gui domino class it creates the 28 dominoes.by adding the 7 half dominos in  all the cases.
  first, it creats the 7 half dominoes in group. then it add those group in hbox of spacing1 
 it creates a full domino and 28 other domino are created and then it is added to a arraylist.

CLASS:guiMain,
 consists of 3 method
guiMain: main,
 it first creats all the labe and then dispaly the human dominoes and then it is added to a scence
 on  your  click to a primary button on mouse it add the h box  right side and on secondary press it add the 
domino to the left side of the table.  and rotatate the domino as needed.

CLASS: humanGui,
 it consists of only one method that is humangG. it will add the given domino in to the table by checks if it matches the domino befoere it.
it also calls validDOmino method from main. and after adding that  domino it calls the  method computerturn of ai class.
 foe the computer play.

Bugg:
 two bugg in my program: 
1) I am not able to print board of gui in two different line. i create a twoline method but 
it didnot worlkout.
2) somtime, my computer size list display the wong number but program is working fine. 
you can check it in terminal. 


