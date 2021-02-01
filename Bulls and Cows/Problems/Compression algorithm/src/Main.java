import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String result = "";
        String[] strings = string.split("");
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            String cha = strings[i];
            if (i == 0 || cha.equals(strings[i - 1])) {
                count++;
            } else if (!cha.equals(strings[i - 1])) {
                result += strings[i - 1];
                result += count;
                count = 0;
                count++;
            }
        }
        result += strings[strings.length - 1] + count;
        System.out.println(result);

    }
}
