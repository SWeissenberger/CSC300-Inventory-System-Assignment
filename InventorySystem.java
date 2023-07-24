/**
 * This class represents an inventory system that a compnay may use to track how
 * many items of a given type are purchased and sold by the company and if the
 * company is currently making a profit on a given item.
 * <p>
 * This class should make use of at least 2 other classes
 * - A Item class which is used to group the required metadata about a given
 * item you are tracking inside of your inventory system. This class should be
 * defined inside of and private to the InventorySystem class.
 * - A SymbolTable class which is used as a database for the various
 * items you are storing. This symbol table should map the String name of a
 * given item to the instance of an Item class which represents the information
 * about that given item. The most efficient way to accomplish this is to make
 * the SymbolTable class generic so that it does not need to know any infomration
 * about the the Item class. The symbolTable class will be found in a second
 * java file called SymbolTable.java
 */
public class InventorySystem {
    /**
     * Define the private Item class and the metadata about each item that you
     * need to track. Note two things here. First we're making this private as
     * we are assuming that the SymbolTable class will be generic and thus does
     * not need to know any information about the Item class. If the SymbolTable
     * was not designed to be generic, then this class would need to be extracted
     * to its own file.
     * <p>
     * Second, note that I have not pre-populated all of the fields, you will
     * likely need to add a few additional in order to keep track of all of the
     * required information
     */
    private class Item {
        /** Add any required fields here */
        private String name;
        private int bought;
        private int sold;
        private double wholeSalePrice;
        private double resalePrice;
        private int instock;

        /**
         * Our Item constructor, this should be used whenever we add a new item
         * to our inventory system.
         *
         * @param name      The name of the item
         * @param bought    How many did we initially purchase
         * @param wholeSale What is the whole sale price
         * @param resale    What is the resale price
         */
        public Item(String name, int bought, double wholeSale, double resale) {
            this.sold = 0;
            this.bought = bought;
            this.wholeSalePrice = wholeSale;
            this.resalePrice = resale;
            this.name = name;
            this.instock = this.bought - this.sold;
        }
    }

    /**
     * Declare the instance of the SymbolTable you'll be using. Note you just
     * want to declare it here, you will initialize the new instance in the
     * constructor. If you are unsure about the difference between declaring and
     * initializing please reach out to me
     */
    private SymbolTable<String, Item> st;

    /** Our basic constructor, this should initialize our backing symbol table */
    InventorySystem() {
        st = new SymbolTable<String, Item>();
    }

    /**
     * Adds a new item to the inventory. This should create a new Item instance
     * and then add it to the symbol table.
     *
     * @param name         The name of the item
     * @param initialOrder How many were initially purchased
     * @param wholesale    The wholesale(per item cost) that we paid
     * @param resale       The resale price(per item) that we will be selling the items for
     * @return true if the item was added succesfully, false if the item already
     * exists in the inventory system
     */
    public boolean addNewItem(String name, int initialOrder, double wholesale, double resale) {
        // if the item isn't already in the system . . .
        if (st.get(name) == null) {
            // create a new Item with its name and put it in the system
            Item newItem = new Item(name, initialOrder, wholesale, resale);
            st.put(newItem.name, newItem);

            return true;

        }
        return false;
    }

    /**
     * Checks to see if we currently carry a given item, in other words, checks
     * to see if the item exists in our symbol table database.
     *
     * @param name The name of the item
     * @return true if we carry it, false if not
     */
    public boolean carry(String name) {
        return st.contains(name);
    }

    /**
     * Checks to see if an item is available, here we are checking to see if our
     * available stock for an item is > 0
     *
     * @param name The name of the item
     * @return true if current stock > 0 and false if 0 or if we do not carry the
     * item
     */
    public boolean available(String name) {
        Item itm = st.get(name);

        if (itm != null) {
            if (itm.instock > 0) {
                return true;
            }

            return false;
        }

        return false;
    }

    /**
     * Retreive the current number of of items we currently have in stock
     *
     * @param name The name of the item to look up
     * @return The number we currently have in stock, -1 if we don't carry the item
     */
    public int currentStock(String name) {
        Item itm = st.get(name);

        if (itm != null) {
            return itm.instock;
        }
        return -1;
    }

    /**
     * Updates the number of items sold for the given item
     *
     * @param name The name of the item that was sold
     * @param qnty The number of items that were sold
     * @return true if we could complete the order, false if we do not have
     * enough inventory to complete the order or we do not have the requested
     * item in our inventory system. If the order cannot be completed then no
     * fields should be updated
     */
    public boolean soldItem(String name, int qnty) {
        Item itm = st.get(name);

        if (itm != null && (itm.instock - qnty) >= 0) {
            itm.instock = itm.instock - qnty;
            itm.sold = itm.sold + qnty;

            return true;
        }

        return false;
    }

    /**
     * Track that we purchased some number of items, this will increase our
     * overall available inventory of the given item
     *
     * @param name The name of the item we purchased
     * @param qnty The number of items we purchased
     * @return true if we succesfully purchased the amount of items, false if
     * we do not have the item in our inventory system
     */
    public boolean boughtItem(String name, int qnty) {
        Item itm = st.get(name);

        if (itm != null) {
            itm.instock = itm.instock + qnty;
            itm.bought = itm.bought + qnty;
            return true;
        }

        return false;
    }

    /**
     * Prints the current inventory status of all items in the inventory, see the
     * example output files for examples of this output. I have provided the
     * format string for the print statement. You will need to fill out the
     * required parameters for the print function.
     */
    public void printInventory() {
        StdOut.printf("%30s | Purchased | Sold | Remaining | Profit $\n", "Product");
        StdOut.println("------------------------------------------------------------------------");

        for (String str : st.keys()) {
            Item itm = st.get(str);
            StdOut.printf("%30s:%11d:%7d:%11d: ", str, itm.bought, itm.sold, itm.instock);
            double netProfit = (itm.resalePrice * itm.sold) - (itm.wholeSalePrice * itm.bought);
            StdOut.printf("$ %.2f.%n", netProfit);
        }
        StdOut.println();
    }

    /**
     * Removes an item from the inventory
     *
     * @param item The name of the item to remove
     * @return true if the item was succesfully deleted, false if we do not have
     * the requested item in the inventory
     */
    public boolean deleteItem(String item) {
        Item itm = st.get(item);

        if (itm != null) {
            st.remove(item);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        StdOut.println("Accepting input");

        while (!StdIn.isEmpty()) {
            String cmd = StdIn.readString();
            StdOut.println("running command: " + cmd);

            if (cmd.equals("add")) {
                String item = StdIn.readString();
                int qnty = StdIn.readInt();
                double wholesale = StdIn.readDouble();
                double resale = StdIn.readDouble();
                if (!is.addNewItem(item, qnty, wholesale, resale)) {
                    StdOut.printf("error: failed to add %s to the inventory\n", item);
                }
                else {
                    StdOut.println("added " + item + " to the inventory");
                }
            }
            else if (cmd.equals("sold")) {
                String item = StdIn.readString();
                int qnty = StdIn.readInt();
                if (!is.soldItem(item, qnty)) {
                    StdOut.printf("error: failed to sell %d %s's\n", qnty, item);
                    if (!is.carry(item)) {
                        StdOut.println("We don't carry " + item);
                    }
                    else if (is.currentStock(item) < qnty) {
                        StdOut.printf("we only have %d in stock!\n", is.currentStock(item));
                    }
                }
                else {
                    StdOut.printf("sold %d %s\n", qnty, item);
                }
            }
            else if (cmd.equals("bought")) {
                String item = StdIn.readString();
                int qnty = StdIn.readInt();
                if (!is.boughtItem(item, qnty)) {
                    StdOut.printf("error: failed to buy %d %s\n", qnty, item);
                    if (!is.carry(item)) {
                        StdOut.printf("We don't carry %s\n", item);
                    }
                    else {
                        StdOut.println("unknown failure!");
                    }
                }
                else {
                    StdOut.printf("purchased %d %s\n", qnty, item);
                }
            }
            else if (cmd.equals("stock")) {
                String item = StdIn.readString();
                int stock = is.currentStock(item);
                if (stock == -1) {
                    StdOut.printf("error: we don't carry %s\n", item);
                }
                else {
                    StdOut.printf("Current stock of %s: %d\n", item, stock);
                }
            }
            else if (cmd.equals("inventory")) {
                is.printInventory();
            }
            else if (cmd.equals("remove")) {
                String item = StdIn.readString();
                StdOut.printf("Removing %s from the inventory\n", item);
                if (!is.deleteItem(item)) {
                    if (!is.carry(item)) {
                        StdOut.printf("We don't carry %s\n", item);
                    }
                    else {
                        StdOut.printf("unknown failure!\n");
                    }
                }
                else {
                    if (!is.carry(item)) {
                        StdOut.println("succesfully removed " + item + " from the inventory");
                    }
                }
            }
            else {
                StdOut.println("Unknown command");
            }
        }
    }
}
