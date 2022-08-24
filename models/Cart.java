package models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> items;

    public Cart(){
        items = new ArrayList<Item>();
    }

    public Item getItem(int index){
        return new Item(items.get(index));
    }

    public void setItem(int index, Item item){
        items.set(index, new Item(item));
    }

   /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
    public boolean add (Item item){
        //Check that item is not already in ArrayList items
        //If not - add item and return true (that we added)
        if (!items.contains(item)){
            items.add(new Item(item));
            return true;
        //Otherwise, don't add item and return false
        } else {
            return false;
        }
    }
 
 
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
    public void remove (String name){
        if (this.items.isEmpty()){
            throw new IllegalStateException("You cannot remove an item from an empty cart");
        }

        //Search through each item in ArrayList - if find one that matches name argument, remove it
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)){
                items.remove(i);
            }
        }
    }

   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    public String checkout(){
        if (this.items.isEmpty()){
            throw new IllegalStateException("Cannot check out with an empty cart");
        }

        // 1. Calculates the subtotal (price before tax).
        double subtotal = 0.0;
        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).getPrice();
        }
        // 2. Calculates the tax (assume tax is 13%).
        double tax = subtotal * .13;
        // 3. Calculates total: subtotal + tax
        double total = subtotal + tax;
        // 4. Returns a String that resembles a receipt. See below.
        return  "\tRECEIPT\n\n" +
        "\tSubtotal: $" + String.format("%.2f", subtotal)  + "\n" +
        "\tTax: $" + String.format("%.2f", tax) + "\n" +
        "\tTotal: $" + String.format("%.2f", total) + "\n";
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString() + "\n";
        }
        return temp;
    }
    
}
