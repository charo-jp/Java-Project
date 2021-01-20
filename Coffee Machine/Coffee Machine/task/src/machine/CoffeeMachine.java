package machine;
import java.util.*;
public class CoffeeMachine {
    public static int water = 400;
    public static int milk = 540;
    public static int beans = 120;
    public static int cups = 9;
    public static int money = 550;
    public static Scanner scanner = new Scanner(System.in);

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printf(String str,int input){
        System.out.printf(str,input);
    }

    public static void coffeeMachineState(int water, int milk, int beans, int cups, int money){
        print("");
        print("The coffee machine has:");
        printf("%d of water\n", water);
        printf("%d of milk\n", milk);
        printf("%d of coffee beans\n", beans);
        printf("%d of disposable cups\n", cups);
        printf("$%d of money\n", money);
        print("");
    }

    public static void checkRemaining(int comWater, int comMilk, int comBeans, int comCups){
        if (water - comWater >= 0 && milk - comMilk >= 0 && beans - comBeans >= 0 && cups - comCups >=0){
            print("I have enough resources, making you a coffee!");
            water -= comWater;
            milk -= comMilk;
            beans -= comBeans;
            cups -= comCups;
        }else{
            if (water - comWater < 0){
                print("Sorry!, not enough water!");
            }else if (milk - comMilk < 0){
                print("Sorry!, not enough milk!");
            }else if (beans - comBeans < 0){
                print("Sorry!, not enough coffee beans!");
            }else if (cups - comCups < 0){
                print("Sorry!, not enough cups!");
            }
        }
    }
    public static void whatToBuy(String choice) {
        int comsumeWater, comsumeMilk, comsumeBeans, comsumeCups;
        if (choice.equals("1")) {
            comsumeWater = 250;
            comsumeBeans = 16;
            comsumeMilk = 0;
            money += 4;
            comsumeCups = 1;
            checkRemaining(comsumeWater, comsumeMilk, comsumeBeans, comsumeCups);
        } else if (choice.equals("2")) {
            comsumeWater = 350;
            comsumeMilk = 75;
            comsumeBeans = 20;
            money += 7;
            comsumeCups = 1;
            checkRemaining(comsumeWater, comsumeMilk, comsumeBeans, comsumeCups);
        } else if (choice.equals("3")) {
            comsumeWater = 200;
            comsumeMilk = 100;
            comsumeBeans = 12;
            money += 6;
            comsumeCups = 1;
            checkRemaining(comsumeWater, comsumeMilk, comsumeBeans, comsumeCups);
        } else if (choice.equals("back")) {
        }
    }
    public static void fillCoffeeMachine() {
        print("Write how many ml of water do you want to add:");
        int input1 = scanner.nextInt();
        water += input1;
        print("Write how many ml of milk do you want to add:");
        int input2 = scanner.nextInt();
        milk += input2;
        print("Write how many grams of coffee beans do you want to add:");
        int input3 = scanner.nextInt();
        beans += input3;
        print("Write how many disposable cups of coffee do you want to add:");
        int input4 = scanner.nextInt();
        cups += input4;
    }
    public static void takeMoney() {
        printf("I gave you $%d", money);
        money = 0;
    }
    public static void process() {
        while (true) {
            print("Write action (buy, fill, take,remaining,exit):");
            String input = scanner.nextLine();
            if (input.equals("buy")) {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String choice = scanner.nextLine();
                whatToBuy(choice);
            }else if(input.equals("fill")) {
                fillCoffeeMachine();
            } if (input.equals("take")) {
                takeMoney();
            }if (input.equals("remaining")) {
                coffeeMachineState(water, milk, beans, cups, money);
            } if(input.equals("exit")){
                break;
            }
        }
    }
    public static void main(String[] args) {
        process();
    }
}
