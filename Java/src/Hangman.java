import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static List<String> words() throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        File file = new File("/Users/c4q-sarahkim/Desktop/FinalProject/Java/src/word_list");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().toUpperCase();
            words.add(word);
        }
        return words;
    }

    public static String wordToGuess(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Hangman!");
        String wordToGuess = wordToGuess(words());

        String guessedLetters = "";
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedLetters += "-";
        }

        Scanner scanner = new Scanner(System.in);

        int guessesRemaining = 8;
        while (guessesRemaining > 0) {
            System.out.println("The word now looks like this: " + guessedLetters);

            if(guessesRemaining == 1) {
                System.out.println("You have only one guess left.");
            } else {
                System.out.println("You have " + guessesRemaining + " guesses left.");
            }

            System.out.print("Your guess: ");
            String letter = scanner.nextLine().toUpperCase();

            if (letter.length() > 1) {
                System.out.println("You can guess one letter at a time. Try again.");
                continue;
            }

            if(wordToGuess.contains(letter)) {
                System.out.println("That guess is correct.");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if(wordToGuess.substring(i, i + 1).equals(letter)) {
                        guessedLetters = guessedLetters.substring(0, i) + letter + guessedLetters.substring(i + 1, guessedLetters.length());
                    }
                }
                if (guessedLetters.contains("-"))
                    continue;
                else
                    break;
            } else {
                System.out.println("There are no " + letter + "'s in the word.");
            }

            guessesRemaining--;
        }

        if (guessesRemaining > 0) {
            System.out.println("You guessed the word: " + wordToGuess);
            System.out.println("You win.");
        } else {
            System.out.println("You're completely hung.");
            System.out.println("The word was: " + wordToGuess);
            System.out.println("You lose.");
        }
    }

}