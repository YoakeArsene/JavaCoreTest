package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Float;

public class Batch {
    String batchName;
    static ArrayList<Cow> CowList;
    static ArrayList<Goat> GoatList;

    public Batch(String name){
        batchName = name;
        CowList = new ArrayList<>();
        GoatList = new ArrayList<>();
    }

    public static void AddCattle(@NotNull String type, String id, int age, float weight){
        if (type.equals("cow")){
            CowList.add(new Cow(id, age, weight));
        }
        else if (type.equals("goat")){
            GoatList.add(new Goat(id, age, weight));
        }
    }

    public static float TotalCowMilk(){
        float totalCowMilk = 0;
        for (Cow cow: CowList
             ) {
            totalCowMilk += cow.MilkProductADay();
        }
        return totalCowMilk;
    }

    public static float TotalGoatMilk(){
        float totalGoatMilk = 0;
        for (Goat goat: GoatList) {
            totalGoatMilk += goat.MilkProductADay();
        }
        return totalGoatMilk;
    }

    public static void FindMostProductiveCattle(){
        //Find Max Cow
        Float[] cowMilkProducted = new Float[CowList.size()];
        int i = 0;
        for (Cow cow: CowList) {
             cowMilkProducted[i++] = cow.MilkProductADay();
        }

        Float[] goatMilkProducted = new Float[GoatList.size()];
        int n = 0;
        for (Goat goat: GoatList) {
            goatMilkProducted[n++] = goat.MilkProductADay();
        }

        if(Collections.max(Arrays.asList(cowMilkProducted)) < Collections.max(Arrays.asList(goatMilkProducted))){
            Goat mostProductiveGoat = GoatList.stream()
                    .filter(c -> c.MilkProductADay() == Collections.max(Arrays.asList(goatMilkProducted)))
                    .findAny().get();
            mostProductiveGoat.ShowCattle();
        }
        else if(Collections.max(Arrays.asList(cowMilkProducted)) > Collections.max(Arrays.asList(goatMilkProducted))){
            Cow mostProductiveCow = CowList.stream()
                    .filter(c -> c.MilkProductADay() == Collections.max(Arrays.asList(cowMilkProducted)))
                    .findAny().get();
            mostProductiveCow.ShowCattle();
        }
    }

    public static void FindCowById(String id){
        Cow cowExist = CowList.stream().filter(c -> c.Id.equals(id)).findFirst().orElse(null);
            if (cowExist != null){
                cowExist.ShowCattle();
            } else System.out.println("ID not found.");
    }

    public static void FindGoatById(String id){
        Goat goatExist = GoatList.stream().filter(c -> c.Id.equals(id)).findFirst().orElse(null);
        if (goatExist != null){
            goatExist.ShowCattle();
        } else System.out.println("ID not found.");
    }

    public static void FindCowByAge(int age) {
        Cow cowExist = CowList.stream().filter(c -> c.Age == age).findFirst().orElse(null);
        if (cowExist != null){
            cowExist.ShowCattle();
        } else System.out.println("Cattle not found.");
    }

    public static void FindGoatByAge(int age) {
        Goat goatExist = GoatList.stream().filter(c -> c.Age == age).findFirst().orElse(null);
        if (goatExist != null){
            goatExist.ShowCattle();
        } else System.out.println("Cattle not found.");
    }

    public static void SortCattleByMilkProduced(){
        CowList.sort((o1, o2) -> o1.MilkProductADay() > o2.MilkProductADay() ? 1 : -1);

        System.out.println("--COW LIST SORTED BY MILK PRODUCTION--");
        for (Cow cow: CowList) {
            cow.ShowCattle();
        }

        GoatList.sort((o1, o2) -> o1.MilkProductADay() > o2.MilkProductADay() ? 1 : -1);

        System.out.println("--GOAT LIST SORTED BY MILK PRODUCTION--");
        for (Goat goat: GoatList) {
            goat.ShowCattle();
        }
    }

    public static void SortCattleByAgeReversed(){
        CowList.sort(((Comparator<Cow>) (o1, o2) -> o1.Age > o2.Age ? 1 : -1).reversed());

        System.out.println("--COW LIST SORTED BY DESCENDING AGE--");
        for (Cow cow: CowList) {
            cow.ShowCattle();
        }

        GoatList.sort(((Comparator<Goat>) (o1, o2) -> o1.Age > o2.Age ? 1 : -1).reversed());

        System.out.println("--GOAT LIST SORTED BY DESCENDING AGE--");
        for (Goat goat: GoatList) {
            goat.ShowCattle();
        }
    }

}
