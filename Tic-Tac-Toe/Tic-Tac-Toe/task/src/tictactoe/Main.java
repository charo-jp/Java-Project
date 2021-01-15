package tictactoe;
import java.util.*;
public class Main {
    public static String result(String[] lists){
        int j = 0;
        for (int i = 0; i < 3; i++) {
            String a = lists[i + j];
            String b = lists[i + 1 + j];
            String c = lists[i + 2 + j];
            String d = lists[i];
            String e = lists[3 + i];
            String f = lists[6 + i];
            if (a.equals(b) && b.equals(c)) {
                if (a.equals("X")) {
                    return "X wins";
                }
                if (a.equals("O")) {
                    return "O wins";
                }
            }
            if (d.equals(e) && e.equals(f)) {
                if (d.equals("X")) {
                    return "X wins";
                }
                if (d.equals("O")) {
                    return "O wins";
                }
            }
            if (i == 1){
                if (lists[0].equals(lists[4]) && lists[4].equals(lists[8])) {
                    if (lists[0].equals("X")) {
                        return "X wins";
                    }
                    if (lists[0].equals("O")) {
                        return "O wins";
                    }
                }else if (lists[2].equals(lists[4]) && lists[4].equals(lists[6])) {
                    if (lists[2].equals("X")) {
                        return "X wins";
                    }
                    if (lists[2].equals("O")) {
                        return "O wins";
                    }
                }
            }
            j += 2;
        }
        int letterCount = 9;
        for (int i = 0; i < 9; i++) {
            if (lists[i].equals(" ") || lists[i].equals("_")) {
                letterCount--;
            }
        }
        if ( letterCount == 9) {
            return "Draw";
        }else {
            return "not finished";
        }
    }

    public static boolean IntOrNot(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void gridMaker (String[] lists) {
        System.out.println("---------");
        int j = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("| "+lists[i+j]+" "+lists[i+j+1]+" "+lists[i+j+2]+" |");
            j +=2;
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lists = {" "," "," "," "," "," "," "," "," ",};
        int count = 1;
        String result;
        gridMaker(lists);
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input1 = scanner.next();
            String input2 = scanner.next();
            String col;
            if (input2.equals("")) {
                col = "None";
            } else {
                col = input2;
            }
            int first, second;
            boolean intOrNot1 = IntOrNot(input1);
            boolean intOrNot2 = IntOrNot(col);
            if (intOrNot1 && intOrNot2) {
                first = Integer.parseInt(input1);
                second = Integer.parseInt(col);
                if ( first >= 1 && first <=3 && second >= 1 && second <=3) {
                    String cell = lists[(first - 1) * 3 + second -1];
                    if (cell.equals(" ") || cell.equals("_")) {
                        if (count % 2 == 1) {
                            lists[(first - 1) * 3 + second -1] = "X";
                            count++;

                        } else {
                            lists[(first - 1) * 3 + second -1] = "O";
                            count++;
                        }
                        result = result(lists);
                        if (result.equals("X wins") || result.equals("O wins") || result.equals("Draw")) {
                            break;
                        }
                        gridMaker(lists);
                    }else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }else {
                System.out.println("You should enter numbers!");
            }
        }
        gridMaker(lists);
        System.out.println(result);
    }
}
