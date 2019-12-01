package com.company;

public class Main {

    public static void main(String[] args) {

        Hamburger bb = new Hamburger("White", "Pork", "Basic", 1.5);

        bb.addExtra1("Tomato",0.5);
        bb.addExtra2("Cheese",0.8);
        bb.addExtra3("mozzarella",1);
        bb.addExtra4("Onion",0.2);
        bb.HamubrgerPrice();
        bb.total();

        HealthyBurger hb = new HealthyBurger("Turkey",3);

        hb.addExtra1("OATS",0.55);
        hb.addHealthy1("Avocado",2.45);
        hb.total();

    }
}
