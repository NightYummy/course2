public class MyHashMap<K, V> {

    @SuppressWarnings("unchecked")
    private final Pair<K, V>[] data = new Pair[16];

    public V get(K key) {
        int index = getIndex(key);
        var pair = data[index];

        if (pair == null) return null;

        while (!pair.key.equals(key)) pair = pair.next;

        return pair.value;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        var pair = data[index];

        if (data[index] == null) {
            data[index] = new Pair<>(key, value);
            return value;
        }

        while (pair.next != null) pair = pair.next;

        pair.next = new Pair<>(key, value);
        pair.next.previous = pair;

        return value;
    }

    public V remove(K key) {
        int index = getIndex(key);
        var pair = data[index];

        if (pair == null) return null;

        if (pair.key.equals(key)) {
            data[index] = pair.next;
            pair.next = null;
            return pair.value;
        }

        while (!pair.key.equals(key)) pair = pair.next;

        pair.previous.next = pair.next;
        if (pair.next == null) return pair.value;
        pair.next.previous = pair.previous;

        return pair.value;
    }

    private int getIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % data.length);
    }

    private static class Pair<K, V> {

        K key;
        V value;
        Pair<K, V> next;
        Pair<K, V> previous;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
