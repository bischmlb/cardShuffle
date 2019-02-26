import java.util.ArrayList;
import java.util.Random;

public class cardShuffle {

    private static ArrayList<String> deckSorted = new ArrayList<>();
    private static ArrayList<String> shuffledCards = new ArrayList<>();
    private static ArrayList<String> usedCards = new ArrayList<>();
    private static String[] colours = new String[]{" of SPADES", " of CLUBS", " of HEARTS", " of DIAMONDS"};
    private static Random rand = new Random();

    // ----------------------------------------- actual shuffle functions

    public static void cardGenerator(){
        String newCard;
        for (int i=1; i<14; i++){
            for (int j = 0; j < 4; j++){
                if (i == 1) {
                    newCard = "ACE" + colours[j];
                    deckSorted.add(newCard);
                }else if (i == 11){
                    newCard = "JACK" + colours[j];
                    deckSorted.add(newCard);
                }else if (i == 12){
                    newCard = "QUEEN" + colours[j];
                    deckSorted.add(newCard);
                }else if (i == 13){
                    newCard = "KING" + colours[j];
                    deckSorted.add(newCard);
                }else{
                    newCard = "" + i + colours[j];
                    deckSorted.add(newCard);
                }
            }
        }
    }

    public static void shuffleCards(){
        int n;
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < countObjectsShuffledDeck()+1; i++) {
                n = rand.nextInt(countObjectsDeckSorted());
                if(shuffledCards.contains(deckSorted.get(n))){
                    shuffledCards.remove(deckSorted.get(n));
                }
                shuffledCards.add(deckSorted.get(n));
            }
        }
    }


    public static String giveCard(){
        if (shuffledCards.size() < 1){
            throw new IllegalArgumentException("The game has no more available cards. Please start a new game.");
        }
        int n = rand.nextInt(countObjectsShuffledDeck());
        String card = shuffledCards.get(n);
        shuffleCards();
        shuffledCards.remove(card);
        deckSorted.remove(card);
        usedCards.add(card);

        return card;
    }

    public static int countObjectsShuffledDeck(){
        int count = 0;
        for(String element : shuffledCards){
            count++;
        }
        return count;
    }

    public static int countObjectsDeckSorted(){
        int count = 0;
        for(String element : deckSorted){
            count++;
        }
        return count;
    }


// ----------------------------------------------------------------------------- bonus

    public static Boolean checkAvailable(String card){
        if (deckSorted.contains(card)){
            System.out.println("Your card is still available");
            return true;
        }
        System.out.println("Your card is not available, or you did not type it correctly. Only the following format is accepted: \"CARD\" of \"COLOR\". Example: \"3 of HEARTS\" or \"QUEEN of DIAMONDS\". Printing available cards: ");
        printAvailableCards();
        return false;
    }

    public static void printAvailableCards(){
        int count = 0;
        for(String card : deckSorted){
            System.out.println(card);
            count++;
        }
        System.out.println("Total cards: " + count);
    }

    public static void printUnavailableCards(){
        for (String card : usedCards){
            System.out.println(card);
        }
    }

    public static void printShuffle(){
        for (String element : shuffledCards){
            System.out.println(element);
        }
    }

}


