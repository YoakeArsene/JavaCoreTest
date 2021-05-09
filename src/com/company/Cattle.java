package com.company;

public abstract class Cattle {
    String Id;
    int Age;
    float Weight;

    public Cattle(String id, int age, float weight) {
        Id = id;
        Age = age;
        Weight = weight;
    }

    public void ShowCattle(){
        System.out.println("Cattle Id: " + Id);
        System.out.println("Cattle Age: " + Age);
        System.out.println("Cattle Weight: " + Weight);
    }

    public float MilkProductADay(){
        return 0;
    }
}

class Cow extends Cattle {

    public Cow(String id, int age, float weight) {
        super(id, age, weight);
    }

    @Override
    public void ShowCattle(){
        System.out.println("Cow Id: " + Id);
        System.out.println("Cow Age: " + Age);
        System.out.println("Cow Weight: " + Weight);
        System.out.println("Milk product: " + MilkProductADay());
    }

    @Override
    public float MilkProductADay(){
        if (Age >= 2 && Age <=5){
            return Math.max(0, ((Weight - Age)/10));
        }
        else return 0;
    }

}

class Goat extends Cattle {

    public Goat(String id, int age, float weight) {
        super(id, age, weight);
    }

    @Override
    public void ShowCattle(){
        System.out.println("Goat Id: " + Id);
        System.out.println("Goat Age: " + Age);
        System.out.println("Goat Weight: " + Weight);
        System.out.println("Milk product: " + MilkProductADay());
    }

    @Override
    public float MilkProductADay(){
        if (Age >= 1 && Age <=2){
            return Weight / 10;
        }
        else if (Age > 2 && Age <= 4){
            return Weight / 15;
        }
        else return 0;
    }
}
