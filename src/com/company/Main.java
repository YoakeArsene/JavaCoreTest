    package com.company;

    import java.util.Objects;
    import java.util.Scanner;

    public class Main {

    public static void main(String[] args) {
        Batch batch = new Batch("Cattle");
        Batch.AddCattle("cow","cow1", 2, 10);
        Batch.AddCattle("cow","cow2", 3, 15);
        Batch.AddCattle("goat","goat1", 4, 10);
        Batch.AddCattle("goat","goat2", 2, 6);

        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("Welcome to the Cattle Farm Manager");
        System.out.println("Press 1 to add new cattle.");
        System.out.println("Press 2 to show all cattle.");
        System.out.println("Press 3 to calculate total milk production.");
        System.out.println("Press 4 to find most productive individual.");
        System.out.println("Press 5 to find cattle by ID.");
        System.out.println("Press 6 to find cattle by age.");
        System.out.println("Press 7 to sort the cattle by milk production.");
        System.out.println("Press 8 to sort the cattle by descending age.");
        System.out.println("Press 0 to quit the program.");

        String option;
        do {
            System.out.println("===========================================");
            System.out.print("Enter your option: ");
            option = sc.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.print("Add a cow or a goat?: ");
                    String type = sc.nextLine();
                    if (type.equals("cow") || type.equals("goat")) {
                        System.out.print("Enter cattle ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter cattle Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter cattle Weight: ");
                        float weight = Float.parseFloat(sc.nextLine());
                        Batch.AddCattle(type, id, age, weight);
                        System.out.println("Add completed!");
                    } else System.out.println("Invalid input.");
                }
                case "2" -> {
                    for (Cow cow : Batch.CowList) {
                        cow.ShowCattle();
                    }
                    for (Goat goat : Batch.GoatList) {
                        goat.ShowCattle();
                    }
                }
                case "3" -> {
                    System.out.print("Find total of cow or goat milk?: ");
                    String type = sc.nextLine();
                    if (type.equals("cow")) {
                        System.out.println("Total cow milk produced is " + Batch.TotalCowMilk());
                    } else if (type.equals("goat")) {
                        System.out.println("Total goat milk produced is " + Batch.TotalGoatMilk());
                    } else System.out.println("Invalid input.");
                }
                case "4" -> Batch.FindMostProductiveCattle();
                case "5" -> {
                    System.out.print("Find cow or goat?: ");
                    String type = sc.nextLine();
                    if (type.equals("cow")) {
                        System.out.print("Enter ID: ");
                        Batch.FindCowById(sc.nextLine());
                    } else if (type.equals("goat")) {
                        System.out.print("Enter ID: ");
                        Batch.FindGoatById((sc.nextLine()));
                    } else System.out.println("Invalid input.");
                }
                case "6" -> {
                    System.out.print("Find cow or goat?: ");
                    String type = sc.nextLine();
                    if (type.equals("cow")) {
                        System.out.print("Enter age: ");
                        Batch.FindCowByAge(Integer.parseInt(sc.nextLine()));
                    } else if (type.equals("goat")) {
                        System.out.print("Enter age: ");
                        Batch.FindGoatByAge(Integer.parseInt(sc.nextLine()));
                    } else System.out.println("Invalid input.");
                }
                case "7" -> Batch.SortCattleByMilkProduced();
                case "8" -> Batch.SortCattleByAgeReversed();
                case "0" -> System.out.println("Exit program.");
                default -> System.out.println("Invalid input.");
            }
        }while (!Objects.equals(option, "0"));

    }
}
