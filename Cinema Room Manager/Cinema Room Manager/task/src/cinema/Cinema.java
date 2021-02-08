package cinema;
import java.util.*;
import java.math.BigDecimal;
public class Cinema {
    private final static Scanner scanner = new Scanner(System.in);
    private  static int purchasedTickets = 0;
    private static int currentIncome = 0;
    public static void enter(){
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsEachRow = scanner.nextInt();
        String[] cinema =createCinema(rows, seatsEachRow);
        selectAction(rows, seatsEachRow, cinema);

    }
    public static String[] createCinema(int rows, int seatsEachRow) {
        String[] seats = new String[rows * seatsEachRow];
        for (int j = 0; j < rows * seatsEachRow; j++) {
            seats[j] = "S";
        }
        return seats;
    }

    public static void selectAction(int rows, int seatsEachRow, String[] cinema){
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int manipulation = scanner.nextInt();
            if (manipulation == 1) {
                createAndViewCinema(rows, seatsEachRow,1 , 0,0, cinema);
            } else if (manipulation == 2) {
                specifySeat(rows, seatsEachRow, cinema);
                // the Cinema seats have to be updated.
            } else if (manipulation == 3) {
                showStatistics(rows, seatsEachRow);
            } if (manipulation == 0) {
                break;
            }
        }
    }
    private static void showStatistics(int rows, int seatsEachRow) {
        int income;
        if (rows * seatsEachRow <= 60) {
            income = rows * seatsEachRow * 10;

        }else {
            int frontHalf = rows / 2;
            income = frontHalf * seatsEachRow * 10 + (rows - frontHalf) * seatsEachRow * 8;
        }
        float percentage =  (float) purchasedTickets / (rows * seatsEachRow) * 100;
        System.out.printf("Number of purchased tickets: %d%n", purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n",currentIncome);
        System.out.println("Total income: $" +income );
    }

    public static void createAndViewCinema(int rows, int seatsOfEachRow, int diff, int row, int col, String[] cinema) {
        if (diff == -2) {

            cinema[seatsOfEachRow * (row - 1) + col - 1] = "B";
        } else {
            System.out.println("Cinema:");
            String cols = "  ";
            for (int i = 1; i < seatsOfEachRow + 1; i++) {
                cols += i + " ";
            }
            System.out.println(cols);
            for (int i = 1 ; i < rows + 1; i++) {
                String showRow = i + " ";
                for (int j = 0; j < seatsOfEachRow; j++) {
                    showRow += cinema[seatsOfEachRow * (i - 1) + j] + " ";
                }
                System.out.println(showRow);
            }
        }
    }

    public static void specifySeat(int rows, int seatsOfEachRow, String[] cinema){
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int col = scanner.nextInt();
            if (row <= 0 || row > rows || col <= 0 || col > seatsOfEachRow) {
                System.out.println("Wrong input!");
            } else if (cinema[seatsOfEachRow * (row - 1) + col - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                outputPrice(row, col, rows, seatsOfEachRow);
                createAndViewCinema(rows, seatsOfEachRow, -2, row, col, cinema);
                purchasedTickets += 1;
                break;
            }
        }
    }

    private static void outputPrice(int row, int col, int rows, int seatsOfEachRow) {
        int price;
        int seats = rows * seatsOfEachRow;
        if (seats <= 60) {
            price = 10;
        } else {
            int frontHalf = rows / 2;
            if ( row <= frontHalf) {
                price = 10;
            } else {
                price = 8;
            }
        }
        currentIncome += price;
        System.out.printf("Ticket price:%n$%d%n",price);
    }

    public static void main(String[] args) {
        enter();
    }
}