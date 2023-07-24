public class TestRemoveC {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        is.addNewItem("bannanas", 1, 1, 1);
        is.addNewItem("apples", 1, 1, 1);
        is.addNewItem("chocolate", 1, 1, 1);

        is.deleteItem("bannanas");
        if (is.currentStock("bannanas") != -1) {
            StdOut.println("Test faild, function did not return the expected value");
            System.exit(1);
        }
    }
}
