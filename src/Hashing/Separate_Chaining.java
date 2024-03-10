package Hashing;

public class Separate_Chaining {
    static class Node {
        private final String key;
        private int value;
        private final Node next;

        public Node(String key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int table_size = 20;
    private final Node[] table;

    Separate_Chaining(int size) {
        this.table = new Node[table_size];
    }

    public int getTable_size() {
        return table.length;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        if (table[index] == null) table[index] = new Node(key, value, null);
        else {
            while (table[index] != null && !table[index].key.equals(key)) table[index] = table[index].next;
            if (table[index] == null) table[index] = new Node(key, value, null);
            else if (table[index].key.equals(key)) table[index].value = value;
        }
    }

    public boolean contains(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) return true;
            table[index] = table[index].next;
        }
        return false;
    }

    public int get(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) return table[index].value;
            table[index] = table[index].next;
        }
        throw new IllegalArgumentException("Key not found");
    }

    private int hash(String key) {
        int adr = 0;
        for (int i = 0; i < key.length(); i++) {
            adr = (2 * key.charAt(i)) % table_size;
        }
        return adr;
    }

    public static void main(String[] args) {
        Separate_Chaining sc1 = new Separate_Chaining(20);

        sc1.insert("A", 25);
        sc1.insert("B", 330);
        sc1.insert("C", 440);
        sc1.insert("D", 550);
        sc1.insert("E", 660);
        sc1.insert("F", 770);
        sc1.insert("G", 880);

        System.out.println(sc1.get("A"));
        System.out.println(sc1.get("B"));
        System.out.println(sc1.get("C"));
        System.out.println(sc1.get("D"));
        System.out.println(sc1.get("E"));
        System.out.println(sc1.get("F"));
        System.out.println(sc1.get("G"));

    }
}
