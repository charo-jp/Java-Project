import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        StringBuilder sb = new StringBuilder();
        String notIncluded ="01234567890 ";
        for (String string: strings){
            if (!notIncluded.contains(string)){
                sb.append(string);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}