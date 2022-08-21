package models;

public class Item {
    private String name;
    private double price;
  
    public Item(String name, double price){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("The name field cannot be blank or null");
        }

        if (price < 0){
            throw new IllegalArgumentException("The price cannot be negative");
        }

        this.name = name;
        this.price = price;
    }

    public Item (Item source){
        this.name = source.name;
        this.price = source.price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("The name field cannot be blank or null");
        }
        this.name = name;
    }

    public void setPrice(double price){
        if (price < 0){
            throw new IllegalArgumentException("The price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString(){
        return this.name + ": $" + this.price + " ";
    }
}
