import java.util.*;

public class MyHashTable {
    String[] table;
    ArrayList<Integer> keySet = new ArrayList<>();

    public MyHashTable(int size) {
        this.table = new String[size];
    }

    private int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % key.length();
        }
        return hash;
    }

    public void insert(String data) {
        int index = hashFunction(data);
        table[index] = data;
        keySet.add(index);
    }

    public void delete(String data) {
        int index = hashFunction(data);
        table[index] = null;
        keySet.remove(index);
    }

    public boolean lookup(String data) {
        int index = hashFunction(data);
        if (table[index] != null) {
            return true;
        } else {
            return false;
        }
    }

    public void printTable() {
        for (int i = 0; i < keySet.size(); i++) {
            System.out.println(table[keySet.get(i)]);
        }
    }
}

/*class HashNode {
    int Key;
    String data;

    public HashNode(String data) {
        this.data = data;
        this.Key = -1;
    }
}*/

class MyHashTableMain {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(1000);
        hashTable.insert("grapes");
        hashTable.insert("apple");
        hashTable.insert("orange");
        hashTable.insert("banana");
        hashTable.insert("watermelon");
        hashTable.printTable();
        hashTable.delete("");
        hashTable.delete("");
        System.out.println();
        hashTable.printTable();
    }
}
