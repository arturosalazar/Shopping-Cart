import models.Item;

public class Main {
    

    public static void main(String[] args) {

        //Test the creation of individual items
        Item celery = new Item("Celery", 0.99);
        System.out.print(celery);
        Item spinach = new Item("Spinach", 0.99);
        System.out.print(spinach);
        Item coriander = new Item("Coriander", 1.29);
        System.out.print(coriander);

        //Test copy constructor
        Item corianderCopy = new Item(coriander);
        System.out.print(corianderCopy);

        //Remove comment to test that exception is thrown if item name is null or blank
        // Item emptyItem = new Item("", 1.0);
        // Item nullItem = new Item (null, 1.0);

        //Remove comment to test that exception is thrown it price is less than 0
        // Item negativePriceItem = new Item ("Apple", -1.0);
    
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

}
