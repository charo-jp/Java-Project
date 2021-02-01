import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.next();
        int count = 0;
        int recurring = first.length() - second.length() + 1;
        int firstIndex = 0;
        int endIndex = second.length();
        for (int i = 0; i < recurring; i++) {
            if (endIndex <= first.length()) {
            String target = first.substring(firstIndex, endIndex);
            if (target.equals(second)) {
                count++;
                firstIndex += second.length();
                endIndex += second.length();
            }else {
            firstIndex++;
            endIndex++;
            }
            }else {
                break;
            }
        }
        System.out.println(count);
    }
}
