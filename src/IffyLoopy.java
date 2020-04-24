import java.util.Scanner;
/* The IffyLoop class meets the requirements for the IffyLoop assignment
*      assignment from Java Bootcamp
*
*  The program provides scenarios for practicing "while" loops and 
*      conditionals
*
*  Kim Levin
*  4/24/2020
*/
public class IffyLoopy {
   public static void main(String[] args) {

      Scanner keyboard = new Scanner(System.in);

      //Prompt user to enter 5 words to be concatenated into
      //  one string
      System.out.print("You will be entering 5 words to build a ");
      System.out.println("sentence.");

      fiveWords(keyboard);
      askIfRedEyes(keyboard);
   }

   //This method expects the user to enter 5 words to be appened
   //  to a sentence. The words can be entered in any combination
   //  For example, if the user enters only 2 strings and hits return 
   //  they'll be prompted to enter 3 more words. If the user enters 5
   //  words, they won't be prompted to enter any more words.

   static void fiveWords(Scanner keyIn) {
      //Declare and initialze variables
      int wordCount = 0;
      int wordsLeft = 0;
      boolean done = false;
      String wordString = "";
      String finalString = "";
      final int MAX_WORDS = 5;
      wordsLeft = MAX_WORDS - wordCount;


      do {
         System.out.print("Please enter up to 5 words: ");
         wordString = keyIn.nextLine().trim();
  
         char letter;
         for (int i = 0; i < wordString.length(); i++) {
            letter = wordString.charAt(i);
            if (!Character.isWhitespace(letter) && (wordsLeft > 0)) {
               finalString = finalString + letter;
               if (i > (wordString.length() - 2) && (wordsLeft > 0)) {
                  wordCount++;
                  wordsLeft--;
                  finalString = finalString.concat(" ");
               }
            } else {
               if (Character.isWhitespace(letter) && wordsLeft > 0) {
                  wordCount++;
                  wordsLeft--;
                  finalString = finalString.concat(" ");
               }
            }
         }

         if ( wordCount < 5) {
            System.out.printf("You have %d words left\n",wordsLeft);
         } else {
            done = true;
         }
      } while (!done);
      System.out.println("Here are your five words: " + finalString);
   }
   static void askIfRedEyes(Scanner keyIn) {
      boolean redEyes;
      boolean do_again = true;
      String userAnswer;
      do {
         System.out.print("Are your eyes red? ");
         userAnswer = keyIn.next().toLowerCase();
         if (userAnswer.equals("y") || userAnswer.equals("yes") ) {
            System.out.println("Get some sleep!");
         } else {
            System.out.println("You look great!");
         }

         System.out.print("Do you want to try again? ");
         userAnswer = keyIn.next();
         if (userAnswer.toLowerCase().equals("n")) {
            do_again = false;
         }
      } while(do_again);
      
   }
}
