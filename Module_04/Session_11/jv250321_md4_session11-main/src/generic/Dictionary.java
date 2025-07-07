package generic;

public class Dictionary<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static <E> void printElement(E[] array) {
        System.out.println("Các phần tử trong mảng:");
        for (E e : array) {
            System.out.println(e);
        }
    }

}
