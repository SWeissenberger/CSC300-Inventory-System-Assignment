public class TestInventoryCount {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        is.addNewItem("hotdogs", 50, 1.99, 2.99);

        if (is.currentStock("hotdogs") != 50) {
            StdOut.printf("Expected function to return 50, but got %d\n",
                          is.currentStock("hotdogs"));
            System.exit(1);
        }
        StdOut.println("test passed!");
    }
}
