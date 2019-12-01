package com.company;

public class Hamburger {
    private String breadRollType;
    private String meat;
    private String name;
    private double price;

    private String addExtraName1;
    private double addExtraPrice1;
    private String addExtraName2;
    private double addExtraPrice2;
    private String addExtraName3;
    private double addExtraPrice3;
    private String addExtraName4;
    private double addExtraPrice4;

    public Hamburger(String breadRollType, String meat, String name, double price) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.name = name;
        this.price = price;
    }
    public void addExtra1 (String name, double cost){
        this.addExtraName1= name;
        this.addExtraPrice1 =cost;
    }
    public void addExtra2 (String name, double cost){
        this.addExtraName2= name;
        this.addExtraPrice2 =cost;
    }
    public void addExtra3 (String name, double cost){
        this.addExtraName3= name;
        this.addExtraPrice3 =cost;
    }
    public void addExtra4 (String name, double cost){
        this.addExtraName4= name;
        this.addExtraPrice4 =cost;
    }

    public double HamubrgerPrice (){
        double price = this.price;
        System.out.println("You ordered " + this.name +" burger with " + this.breadRollType+" bread and " + this.meat + " price:\t" + this.price);
        if (addExtraName1 != null){
            this.price += this.addExtraPrice1;
            System.out.println("Adding " + addExtraName1 + " price:\t" + addExtraPrice1);
        }
        if (addExtraName2 != null){
            this.price += this.addExtraPrice2;
            System.out.println("Adding " + addExtraName2 + " price:\t" + addExtraPrice2);
        }
        if (addExtraName3 != null){
            this.price += this.addExtraPrice3;
            System.out.println("Adding " + addExtraName3 + " price:\t" + addExtraPrice3);
        }
        if (addExtraName4 != null){
            this.price += this.addExtraPrice4;
            System.out.println("Adding " + addExtraName4 + " price:\t" + addExtraPrice4);
        }

        return price;
    }
    public double total(){
        double total = this.price;
        System.out.println("\tTOTAL PRICE IS:\t" + total);
        return total;
    }


}
