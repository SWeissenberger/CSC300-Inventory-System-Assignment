public class TestRemoveA {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        is.addNewItem("hotdogs", 50, 1.99, 2.99);
        is.addNewItem("bread", 120, 1.00, 4.99);
        is.deleteItem("bread");
        if (is.currentStock("bread") != -1) {
            StdOut.println("Test faild, function did not return the expected value");
            System.exit(1);
        }
        StdOut.println("test passed!");
    }
}
