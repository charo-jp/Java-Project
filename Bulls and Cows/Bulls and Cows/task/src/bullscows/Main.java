package bullscows;
import java.util.*;
public class Main {
    private static String secretcodeGen(int num) {
        String secret = "";
        for (int i = 0; i < num; i++) {
            secret += "*";
        }
        return secret;
    }

    private static void secretNumber (int num, int symbols) {
        Random random = new Random();
        String result = "";
        String secretcode = secretcodeGen(num);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
        String range;
        if (symbols <= 10) {
            range = "(0-" + list.get(symbols - 1) + ")";
        }else {
            range = "(0-9,a-" + list.get(symbols - 1) + ")";
        }
        System.out.printf("The secret is prepared: %s %s.%n",secretcode, range);
        for (int i = 0; i < num; i++) {
            while (true) {
                String r = list.get(random.nextInt(symbols));
                if (!("-1".equals(r))) {
                    result += r;
                    int index = list.indexOf(r);
                    list.set(index,"-1");
                    break;
                }
            }
        }
        System.out.println("Okay, let's start a game!");
        userGuess(result);
    }

    private static int grader (String num,String secret){
        String[] nums = num.split("");
        int bulls = 0;
        int cows = 0;
        String[] secret1 = secret.split("");
        for (int i = 0; i < secret1.length; i++) {
            for (int j = 0; j < secret1.length; j++) {
                String s = nums[j];
                if (i == j && s.equals(secret1[i])) {
                    bulls++;
                } else if (s.equals(secret1[i])) {
                    cows++;
                }
            }
        }
        printResult(bulls, cows);
        return bulls;
    }

    private static void printResult(int bulls, int cows) {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None");
        } else if (bulls == 1 && cows == 0 ) {
            System.out.println("Grade: 1 bull");
        } else if (bulls == 0 && cows == 1 ) {
            System.out.println("Grade: 1 cow");
        } else if (bulls == 1 && cows == 1 ) {
            System.out.println("Grade: 1 bull and 1 cow");
        } else if (bulls > 1 && cows == 0 ) {
            System.out.printf("Grade: %d bulls%n",bulls);
        }else if (cows > 1 && bulls == 0){
            System.out.printf("Grade: %d cows%n",cows);
        }else {
            System.out.printf("Grade: %d bulls and %d cows%n", bulls, cows);
        }
    }

    private static void userGuess(String secret) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        while (true) {
            System.out.printf("Turn %d:%n",count);
            String guess = scanner.next();
            int bull = grader(guess,secret);
            if (bull == guess.length()) {
                break;
            }
            count++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static void firstManipulation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String numStr = scanner.next();
        try {
            int number = Integer.parseInt(numStr);
            System.out.println("Input the number of possible symbols in the code");
            int symbols = scanner.nextInt();
            if (number - symbols > 0 || number == 0) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols%n", number, symbols);
            } else if (symbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).%n");
            }else if (number - symbols <= 0) {
                secretNumber(number, symbols);
            }
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s \" isn't a valid number.%n", numStr);
        }
    }

    public static void main(String[] args) {
        firstManipulation();
    }
}