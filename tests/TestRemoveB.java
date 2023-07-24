public class TestRemoveB {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        is.addNewItem("apples", 1, 1, 1);
        is.addNewItem("bannanas", 1, 1, 1);
        is.addNewItem("chocolate", 1, 1, 1);

        is.deleteItem("bannanas");
        if (is.currentStock("bannanas") != -1) {
            StdOut.println("Test faild, function did not return the expected value");
            System.exit(1);
        }
        StdOut.println("test passed!");
    }
}
