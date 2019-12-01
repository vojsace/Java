package com.company;

public class HealthyBurger extends Hamburger {
    private String addHealthyName1;
    private double addHealthyPrice1;

    private String addHealthyName2;
    private double addHealthyPrice2;

    public HealthyBurger(String meat, double price) {
        super("brown rye", meat,"Healthy", price);
    }
    public void addHealthy1 (String name, double cost){
        this.addHealthyName1 = name;
        this.addHealthyPrice1 = cost;
    }

    @Override
    public double HamubrgerPrice() {
        double price = super.HamubrgerPrice();
        if (addHealthyName1 != null){
            price += this.addHealthyPrice1;
            System.out.println("Adding " + addHealthyName1 + " price:\t" + addHealthyPrice1);
        }
        return price;
    }

    @Override
    public double total() {
       double total =  HamubrgerPrice();
        System.out.println("\tTOTAL PRICE IS:\t" + total);
        return total;
    }
}
