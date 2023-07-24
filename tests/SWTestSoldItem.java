public class SWTestSoldItem {
    public static void main(String[] args) {
        // how to test solditem--buy an amount, sell some, compare itm.sold to bought - sold?
        InventorySystem is = new InventorySystem();
        int init = 100;
        is.addNewItem("apples", init, 1, 1);
        int sold = 50;
        is.soldItem("apples", sold);
        if ((init - sold) != is.currentStock("apples")) {
            StdOut.println("Test failed, function did not return the expected value");
            System.exit(1);
        }
        StdOut.println("test passed");

    }
}
