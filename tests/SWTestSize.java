public class SWTestSize {
    public static void main(String[] args) {
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
            i++;
            if ((i) != st.size()) {
                StdOut.printf("test failed--i == %d and size == %d", i, st.size());
                System.exit(1);
            }
        }
        StdOut.println("test passed");
        System.exit(0);

    }
}
