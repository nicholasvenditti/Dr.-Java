/* Nicholas Venditti
 * 2 October 2024
 */

import java.util.*; //Imports

public class Baccarat { //Public class
  
  /* Method that randomizes array */
  public static void randomize(int[] deck) {
  
    Random rnd = new Random();
    
    for (int length = deck.length - 1; length > 0; length--) {
      int random = rnd.nextInt(length + 1);
      int array = deck[random];
      deck[random] = deck[length];
      deck[length] = array;
    }
        
  }
  
  /* Method that declares result */
  public static void result(String playersBet, int playersHand, int bankersHand) {
    
    String winner;
    
    if (playersHand > bankersHand) {
      winner = "P";
    } else if (bankersHand > playersHand) {
      winner = "B";
    } else {
      winner = "T";
    }
    
    delay();
    
    System.out.println("\nPLAYERs total is " + playersHand + ".");
    System.out.println("BANKERs total is " + bankersHand + ".\n");
    
    delay();
    
    if (playersBet.equalsIgnoreCase(winner)) {
      System.out.print("You win!\n");
    } else {
      System.out.print("You lose!\n");
    }
    
    delay();
    System.exit(1);
  }
  
  /* Method that delays program */
  public static void delay() {
    try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
  }
  
  /* Main method */
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in); //Opens keyboard
    
    /* Array */
    int[] card = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    randomize(card); //Activates method that randomizes array
    
    /* Introduction */
    System.out.println("Welcome to Baccarat!\n");
    
    /* Player's bet */
    String playersBet = "N";
    do {
      System.out.print("Would you like to bet on PLAYER (P), BANKER (B), or TIE (T)?");
      playersBet = keyboard.next();
    } while (!playersBet.equalsIgnoreCase("P") && !playersBet.equalsIgnoreCase("B") && !playersBet.equalsIgnoreCase("T"));
    
    int playersHand = (card[0] + card[2]) % 10; //Value of player's hand
    int bankersHand = (card[1] + card[3]) % 10; //Value of the banker's hand
    
    System.out.println("PLAYER gets a " + card[0] + " and a " + card[2] + ".");
    System.out.println("PLAYERs total is " + playersHand + ".\n");
    
    delay();
    
    System.out.println("BANKER gets a " + card[1] + " and a " + card[3] + ".");
    System.out.println("BANKERs total is " + bankersHand + ".\n");
    
    /* If someone gets a natural 8 or 9 */
    if (playersHand == 8 || playersHand == 9 || bankersHand == 8 || bankersHand == 9) {
      
      delay();
      
      if (playersHand == 8 || playersHand == 9) {
        System.out.println("PLAYER has a natural " + playersHand + ".");
      }
      
      if (bankersHand == 8 || bankersHand == 9) {
        System.out.println("BANKER has a natural " + bankersHand + ".");
      }
      
      result(playersBet, playersHand, bankersHand);
    }
    
    /* If PLAYER has to hit */
    if (playersHand < 6) {
      playersHand = (playersHand + card[4]) % 10;
      
      delay();
      
      System.out.println("PLAYER gets a " + card[4] + ".");
      System.out.println("PLAYERs total is " + playersHand + ".");
    }
    
    /* BANKERs turn */
    if (bankersHand < playersHand && bankersHand < 6) {
      bankersHand = (bankersHand + card[5]) % 10;
      
      delay();
      
      System.out.println("BANKER gets a " + card[5] + ".");
      System.out.println("BANKERs total is " + bankersHand + ".");
    }
    
    result(playersBet, playersHand, bankersHand);
  }
}
