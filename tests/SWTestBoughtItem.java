public class SWTestBoughtItem {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        int init = 100;
        is.addNewItem("apples", init, 1, 1);
        int bought = -50;
        is.boughtItem("apples", bought);

        if ((init + bought) != is.currentStock("apples")) {
            StdOut.printf("Test failed, function returned %d instead of %d", init + bought,
                          is.currentStock("apples"));
            System.exit(1);
        }
        StdOut.println("test passed");
    }
}
