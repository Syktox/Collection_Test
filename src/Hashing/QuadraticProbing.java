package Hashing;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QuadraticProbing {
    static class Node {
        private final String key;
        private int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int table_size = 19;
    private final Node[] table;

    QuadraticProbing() {
        this.table = new Node[table_size];
    }

    public boolean isTablePrim() {
        for (int i = 2; i < table_size; i++) if (table_size % i == 0) return false;
        return true;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        int d = -table_size;
        int count = 0;

        while (table[index] != null && count < table_size + 10) {
            d = d + 2;
            index = (index + Math.abs(d)) % table_size;
            count++;
        }
        if (count > table_size + 10) throw new IllegalArgumentException("Table full");
        if (table[index] == null) {
            table[index] = new Node(key, value);
        }
    }

    public boolean contains(String key) {
        return Arrays.stream(table).anyMatch(i -> i.key.equals(key));
    }

    public int get(String key) {
        int index = hash(key);
        int d = -table_size;
        int count = 0;
        while (count++ < table_size + 10 && !table[index].key.equals(key)) {
            d = d + 2;
            index = (index + Math.abs(d)) % table_size;
            count++;
        }
        if (table[index].key.equals(key)) return table[index].value;
        throw new NoSuchElementException();
    }

    private int hash(String key) {
        int adr = 0;
        for (int i = 0; i < key.length(); i++) {
            adr = (2 * adr + key.charAt(i)) % table_size;
        }
        return adr;
    }

    public static void main(String[] args) {
        QuadraticProbing qp = new QuadraticProbing();
        if (qp.isTablePrim()) {
            for (int i = 0; i <= 19; i++) {
                qp.insert("A" + i, i);
            }

            System.out.println(qp.contains("A18"));
            System.out.println(qp.get("A18"));
        }
    }
}
