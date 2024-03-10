package Hashing;

import java.util.Arrays;

public class LinearProbing {
    static class Node {
        private final String key;
        private int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int table_size = 20;
    private final Node[] table;

    LinearProbing() {
        this.table = new Node[table_size];
    }

    public int getTable_size() {
        return table.length;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        int count = 0;
        while (count++ < table_size) {
            if (table[index] == null) {
                table[index] = new Node(key, value);
                return;
            } else {
                index = (index + 1) % table_size;
            }
        }
        throw new IllegalStateException("Table full");
    }

    public boolean contains(String key) {
        return Arrays.stream(table).anyMatch(i -> i.key.equals(key));
    }

    public int get(String key) {
        int index = hash(key);
        int count = 0;
        while (count++ < table_size) {
            if (table[index].key.equals(key)) return table[index].value;
            else index = (index + 1) % table_size;
        }
        throw new IllegalArgumentException("Not found");
    }

    private int hash(String key) {
        int adr = 0;
        for (int i = 0; i < key.length(); i++) {
            adr = (2 * key.charAt(i)) % table_size;
        }
        return adr;
    }

    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing();
        lp.insert("A", 1);
        lp.insert("B", 2);
        lp.insert("C", 3);
        lp.insert("D", 4);
        lp.insert("E", 5);
        lp.insert("F", 6);
        lp.insert("G", 7);
        lp.insert("H", 8);
        lp.insert("I", 9);
        lp.insert("J", 10);
        lp.insert("K", 11);
        lp.insert("L", 12);
        lp.insert("M", 13);
        lp.insert("N", 14);
        lp.insert("O", 15);
        lp.insert("P", 16);
        lp.insert("Q", 17);
        lp.insert("R", 18);
        lp.insert("S", 19);
        lp.insert("T", 20);

        System.out.println(lp.contains("s"));
        System.out.println(lp.contains("S"));
        // lp.insert("U", 21); // Should throw IllegalStateException (DID)

        System.out.println(lp.get("T"));
        lp.get("X");
    }
}
