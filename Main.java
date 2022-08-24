import models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Cart;
import models.Store;

public class Main {
    static Store store = new Store();

    static Cart cart = new Cart();
    public static void main(String[] args){

        try {
            loadItems("products.txt");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            manageItems();
        }
        
        
        
    }
    
    /**
     * Name: manageItems
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. Creates an infinite loop:     
     *   •        The user can choose to a) add or b) remove c) checkout.
     *   •          case a: asks for the aisle and item number. Then, adds item to cart.
     *   •          case b: asks for the name. Then, removes item from cart.
     *   •          case c: prints the receipt and closes Scanner.
     *   •        Prints the updated shopping cart.
     */
 
    static public void manageItems(){
        Scanner scan = new Scanner (System.in);
        while (true){
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");

            System.out.println(store);

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");

            String answer = scan.nextLine();

            

            if (answer.equals("a")){
                System.out.print("\nChoose an aisle number between: 1 - 7: ");                
                int aisle = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
                scan.nextLine(); //To avoid skipping errors when calling nextLine() after nextInt()
                
                System.out.print("Choose an item number between: 1 - 3: ");
                int row = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
                scan.nextLine(); //To avoid skipping errors when calling nextLine() after nextInt()

                //Check for invalid input 
                if (aisle == 404 || row == 404){
                    System.out.println("Please enter a valid aisle and row");
                    continue;
                }
                if (aisle < 1 || aisle > 7 || row < 1 || row > 3){
                    System.out.println("Please enter a valid aisle and row");
                }

                Item itemToAdd = new Item(store.getItem(aisle, row));
                if (cart.add(itemToAdd)){
                    System.out.println(itemToAdd.getName() + " was added to your shopping cart.");
                } else {
                    System.out.println(itemToAdd.getName() + " is already in your shopping cart.");
                }

            } else if (answer.equals("b")){
                if (cart.isEmpty()){
                    System.out.println("You cannot remove items from an empty cart");
                    continue;
                }
                System.out.print("Enter the item you'd like to remove: ");
                String toRemove = scan.nextLine();
                cart.remove(toRemove);
            } else if (answer.equals("c")){
                System.out.println(cart.checkout());
                break;
            } 


            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            scan.nextLine();
        
        }
        scan.close();
    }

    /**
     * Name: loadItems
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   1. loads items from <fileName>.txt.
     *      • while loop runs through every line in <fileName>
     *      • scan.nextLine() picks up the entire line.
     *      • splits each String using the ";" separator.
     *      • splits both fields in each String using the "=" separator.
     *      • Parse each price into a Double.
     *   2. adds all items to the store object's items field.
     */

    static public void loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner scanFile = new Scanner (file);

        
        for (int i = 0; scanFile.hasNextLine(); i++){
            String scannedLine = scanFile.nextLine();
            String[] splitLine = scannedLine.split(";");
            for (int j = 0; j < splitLine.length; j++) {
                String[] splitPhrase = splitLine[j].split("=");
                store.setItem(i, j, new Item(splitPhrase[0], Double.parseDouble(splitPhrase[1]))); 
            }
        }
        
        scanFile.close();
    }

}
