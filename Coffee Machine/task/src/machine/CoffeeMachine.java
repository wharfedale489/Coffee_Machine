package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);
    public static String sorry = "Sorry, not enough ";
    public static String yes = "I have enough resources, making you a coffee!";
    public static int water = 400;
    public static int milk = 540;
    public static int coffee = 120;
    public static int disposableCups = 9;
    public static int money = 550;

    public static void main(String[] args) {
        menu();
    }

    public static void menu () {

        boolean exit = true;
        do {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            System.out.println();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printStatusCoffeeMachine();
                    break;
                case "exit":
                    exit = false;
                    break;
            }
            System.out.println();
        }while(exit);
    }

    public static void buy() {
        System.out.println("What do you want to buy 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String byuCoffee = scanner.next();

        switch (byuCoffee) {
            case "1":
                setEspresso();
                break;
            case "2":
                setLatte();
                break;
            case "3":
                setCappuccino();
                break;
            case "back":
                break;
        }

    }

    public static void setEspresso() {
        if (water < 250 || coffee < 16 || disposableCups == 0) {
            if (water < 250) System.out.println(sorry + "water!");
            if (coffee < 16) System.out.println(sorry + "coffee!");
            if (disposableCups == 0) System.out.println(sorry + "disposable cups!");
        } else {
            System.out.println(yes);
            water -= 250;
            coffee -= 16;
            money += 4;
            disposableCups -= 1;
        }
    }

    public static void setLatte() {
        if (water < 350 || milk < 75 || coffee < 20 || disposableCups == 0) {
            if (water < 350) System.out.println(sorry + "water!");
            if (milk < 75) System.out.println(sorry + "milk!");
            if (coffee < 20) System.out.println(sorry + "coffee!");
            if (disposableCups == 0) System.out.println(sorry + "disposable cups!");
        } else {
            System.out.println(yes);
            water -= 350;
            milk -= 75;
            coffee -= 20;
            money += 7;
            disposableCups -= 1;
        }
    }

    public static void setCappuccino(){
        if (water < 200 || milk < 100 || coffee < 12 || disposableCups == 0) {
            if (water < 200) System.out.println(sorry + " water!");
            if (milk < 100) System.out.println(sorry + "milk!");
            if (coffee < 12) System.out.println(sorry + "coffee!");
            if (disposableCups == 0) System.out.println(sorry + "disposable cups!");
        } else {
            System.out.println(yes);
            water -= 200;
            milk -= 100;
            coffee -= 12;
            money += 6;
            disposableCups -= 1;
        }
    }

    public static void fill() {
        setWater();
        setMilk();
        setCoffee();
        setDisposableCaps();

    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void printStatusCoffeeMachine() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffee + " of coffee beans\n" +
                disposableCups + " of disposable cups\n" +
                money + " of money");
    }

    public static void setWater () {
        System.out.println("Write how many ml water do you want to add:");
        CoffeeMachine.water += scanner.nextInt();

    }

    public static void setMilk() {
        System.out.println("Write how many ml milk do you want to add:");
        CoffeeMachine.milk += scanner.nextInt();
    }

    public static void setCoffee() {
        System.out.println("Write how many grams of coffee beans do you want to add:");
        CoffeeMachine.coffee += scanner.nextInt();
    }

    public static void setDisposableCaps() {
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        CoffeeMachine.disposableCups += scanner.nextInt();
    }
}