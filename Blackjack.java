/* Nicholas Venditti
 * Mr. Paterson
 * ICS3U1-01
 * 19 January 2016
 */

import java.util.*; //Imports

public class Blackjack { //Public class
  
  /* Method than randomizes array */
  public static void randomize(int[] deck) {
  
    Random rnd = new Random();
    
    for (int length = deck.length - 1; length > 0; length--) {
      int random = rnd.nextInt(length + 1);
      int array = deck[random];
      deck[random] = deck[length];
      deck[length] = array;
    }
        
  }
  
  /* Main method */
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in); //Opens keyboard
    
    /* Array */
    int[] card = {2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,
      9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11};
    
    randomize(card); //Activates method that randomizes array
    
    /* Introduction */
    System.out.println("Welcome to Blackjack!\n");
    System.out.println("Dealer must draw on 16 and stand on all 17's.");
    System.out.println("Aces can only be worth 11.\n");
    
    System.out.println("You get a " + card[0] + " and a " + card[1] + ".");
    
    int playersHand = card[0] + card[1]; //Value of player's hand
    
    System.out.println("Your total is " + playersHand + ".\n");
    
    System.out.println("The dealer is showing a " + card[2] + ".\n");
    
    int dealersHand = card[2] + card[3]; //Value of the dealer's hand
    
    /* If dealer gets Blackjack and player does not */
    if (dealersHand == 21 && playersHand != 21) {
      System.out.println("The dealer's other card is a " + card[3] + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.print("The dealer got Blackjack, you lose.\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* If player gets Blackjack and dealer does not */ 
    if (playersHand == 21 && dealersHand != 21) {
      System.out.println("You got Blackjack, you win!\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* If player busts and dealer does not */
    if (playersHand == 22 && dealersHand != 22) {
      System.out.println("You got busted, you lose.\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* If dealer busts and player does not */
    if (dealersHand == 22 && playersHand != 22) {
      System.out.println("The dealer's other card is a " + card[3] + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.print("The dealer busted, you win!\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* If both dealer and player get Blackjack */
    if (dealersHand == 21 && playersHand == 21) {
      System.out.println("The dealer's other card is a " + card[3] + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.println("It's a push.\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
   
    /* If both dealer and player bust */
    if (dealersHand == 22 && playersHand == 22) {
      System.out.println("The dealer's other card is a " + card[3] + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.println("It's a push.\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* Player's turn */
    System.out.print("Would you like to \"hit\" or \"stay\"?");
    
    String playersTurn = keyboard.next(); //Hit or stay
   
    int cc = 4; //Card count
    
    /* If player stays under 16 */
    if (!playersTurn.equalsIgnoreCase("hit") && playersHand < 16) {
      System.out.println("");
      System.out.print("Are you sure you want to stay at " + playersHand + ", \"yes\" or \"no\"?");
      String warning = keyboard.next();
      if (warning.equalsIgnoreCase("no")) {
        playersTurn = ("hit");
      }
    }
    
    /* If player hits */
    if (playersTurn.equalsIgnoreCase("hit")) {
        
      while (playersHand < 21 && playersTurn.equalsIgnoreCase("hit")) { //Loop
        
        /* If player hits over 16 */
        if (playersHand > 16 && playersTurn.equalsIgnoreCase("hit")) {
          System.out.println("");
          System.out.print("Are you sure you want to hit at " + playersHand + ", \"yes\" or \"no\"?");
          String warning = keyboard.next();
          if (warning.equalsIgnoreCase("no")) {
            playersTurn = ("stay");
          }
        }
        
        /* If player hits */
        if (playersTurn.equalsIgnoreCase("hit")) {
          System.out.println("You drew a " + card[cc] + ".");
          playersHand = playersHand + card[cc];
          System.out.println("Your total is " + playersHand + ".\n");
          cc++; //Adds card count by 1
          
          /* If player busts */
          if (playersHand > 21) {
            System.out.println("You got busted, you lose.\n");
            try {
              Thread.sleep(3000L);
            }
            catch (Exception e) {}
            System.exit(1);
          }
          
          /* Player's turn */
          System.out.print("Would you like to \"hit\" or \"stay\"?");
          playersTurn = keyboard.next();
          
          /* If player hits over 16 */
          if (!playersTurn.equalsIgnoreCase("hit") && playersHand < 16) {
            System.out.println("");
            System.out.print("Are you sure you want to stay at " + playersHand + ", \"yes\" or \"no\"?");
            String warning = keyboard.next();
            if (warning.equalsIgnoreCase("no")) {
              playersTurn = ("hit");
           }
         }
           
        }
    
      }
      
    }
   
    keyboard.close(); //Closes keyboard
    
    /* Dealer's turn */
    System.out.println("Now it is the dealer's turn.\n"); 
    System.out.println("The dealer's other card is a " + card[3] + ".");
    System.out.println("The dealer's total is " + dealersHand + ".\n");
    
    while (dealersHand < 17) { //Loop
   
       try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.out.println("The dealer decides to hit.");
      System.out.println("The dealer drew a " + card[cc] + ".");
      dealersHand = dealersHand + card[cc];
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      cc++; //Adds card count by 1
     
      /* If dealer busts */
      if (dealersHand > 21) {
        System.out.print("The dealer busted, you win!\n");
        try {
          Thread.sleep(3000L);
        }
        catch (Exception e) {}
        System.exit(1);
      } 
    
    }
    
    try {
      Thread.sleep(3000L);
    }
    catch (Exception e) {}
    System.out.println("The dealer decides to stay.\n");
    try {
      Thread.sleep(1000L);
    }
    catch (Exception e) {}
  
    /* If dealer and player tie */
    if (dealersHand == playersHand) {
      System.out.println("Your total is " + playersHand + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.println("It's a push.\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* If dealer wins */
    if (dealersHand > playersHand) {
      System.out.println("Your total is " + playersHand + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.println("The dealer wins.\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
    /* If player wins */
    if (dealersHand < playersHand) {
      System.out.println("Your total is " + playersHand + ".");
      System.out.println("The dealer's total is " + dealersHand + ".\n");
      System.out.println("You win!\n");
      try {
        Thread.sleep(3000L);
      }
      catch (Exception e) {}
      System.exit(1);
    }
    
  } 
    
}    