public class SWTestGet {
    public static void main(String[] args) {
        // enter an item, remove it--if get doesn't return null, test failed
        class Item {
            /** Add any required fields here */
            String name;
            String val;

            public Item(String name, String val) {
                this.val = val;
                this.name = name;
            }
        }
        SymbolTable<String, String> st = new SymbolTable<String, String>();
        int i = 0;
        String[] list = { "a", "b", "c", "d", "e" };
        while (i < 5) {
            st.put(list[i], "A");
            st.remove(list[i]);
            if (st.get(list[i]) != null) {
                StdOut.println("test failed");
                System.exit(1);
            }
            i++;
        }
        StdOut.println("test passed");
        System.exit(0);
    }
}
