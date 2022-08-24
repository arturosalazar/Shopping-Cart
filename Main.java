import models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
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
