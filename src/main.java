import java.util.Random;
import java.util.Scanner;
public class main {

    public static void main(String args[]){
        cardShuffle.cardGenerator();
        cardShuffle.shuffleCards();

        int n = 1;
        System.out.println("Commands:");
        System.out.println("1 - Draw card");
        System.out.println("2 - Shuffle Cards");
        System.out.println("3 - Start new game");
        System.out.println("4 - Print available cards");
        System.out.println("5 - Print already drawn cards (last drawn order)");
        System.out.println("-------------------------");
        System.out.println("Admin: 6 - Print shuffled cards array");
        Scanner inpurt = new Scanner(System.in);
        while(n != 0){
            n = inpurt.nextInt();
            if (n == 1){
                System.out.println("Card given: ");
                System.out.println(cardShuffle.giveCard());
                System.out.println("Total cards left: " + cardShuffle.countObjectsShuffledDeck());
            }
            if (n == 2){
                cardShuffle.shuffleCards();
                System.out.println("Cards have been shuffled");
            }
            if (n == 3){
                System.out.println("Starting new game ...");
                cardShuffle.cardGenerator();
                cardShuffle.shuffleCards();
                System.out.println("Deck has been reset and shuffled");
            }
            if (n == 4){
                cardShuffle.printAvailableCards();
            }
            if (n == 5){
                cardShuffle.printUnavailableCards();
            }
            if (n == 6){
                cardShuffle.printShuffle();
            }
            else if (n > 6){
                System.out.println("Input not understood, please try again.");
                System.out.println("--------");
                System.out.println("Commands:");
                System.out.println("1 - Draw card");
                System.out.println("2 - Shuffle Cards");
                System.out.println("3 - Start new game");
                System.out.println("4 - Print available cards");
                System.out.println("5 - Print already drawn cards");
                System.out.println("-------------------------");
                System.out.println("Admin: 6 - Print shuffled cards array");
            }
        }

        cardShuffle.printShuffle();

    }

}

//TODO: Start making actual app in Android Studio
//TODO:
