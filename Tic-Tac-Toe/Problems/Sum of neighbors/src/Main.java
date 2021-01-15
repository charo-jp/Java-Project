import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        String[] test = scanner.nextLine().split(" ",0);
        int nums = test.length;
        ArrayList<Integer> array = new ArrayList<>();
        for (String s : test) {
            array.add(Integer.parseInt(s));
        }
        arrays.add(array);
        int row =1;
        while (true) {
            String[] test1 = scanner.nextLine().split(" ",0);
            if (test1[0].equals("end")) {
                break;
            }
            ArrayList<Integer> array1 = new ArrayList<>();
            for (String s : test1) {
                array1.add(Integer.parseInt(s));
            }
            arrays.add(array1);
            row++;
        }
        for (int i = 0; i < arrays.size(); i++){
            for (int j = 0; j < arrays.get(i).size(); j++) {
                int right,left,top,bottom,sum;
                right = (nums + j - 1) % nums;
                left = (nums + j + 1) % nums;
                top = (row + i + 1) % row;
                bottom = (row + i - 1) % row;
                sum = arrays.get(i).get(right) + arrays.get(i).get(left) + arrays.get(top).get(j) + arrays.get(bottom).get(j);
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
}
