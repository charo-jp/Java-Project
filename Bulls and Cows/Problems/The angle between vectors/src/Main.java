import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double u = Math.sqrt(a * a + b * b);
        double v = Math.sqrt(c * c + d * d);
        double radian = Math.acos((a * c + b * d) / (u * v));
        System.out.println(Math.toDegrees(radian));

    }
}
