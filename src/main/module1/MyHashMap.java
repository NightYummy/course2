package module1;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

    @SuppressWarnings("unchecked")
    private final Pair<K, V>[] data = new Pair[16];
    private int size = 0;

    @Override
    public V get(Object key) {
        int index = getIndex(key);
        var pair = data[index];

        if (pair == null) return null;

        while (!pair.key.equals(key)) pair = pair.next;

        return pair.value;
    }

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        var pair = data[index];

        if (data[index] == null) {
            data[index] = new Pair<>(key, value);
            size++;
            return value;
        }

        while (pair.next != null) pair = pair.next;

        pair.next = new Pair<>(key, value);
        pair.next.previous = pair;

        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        int index = getIndex(key);
        var pair = data[index];

        if (pair == null) return null;

        if (pair.key.equals(key)) {
            data[index] = pair.next;
            pair.next = null;
            size--;
            return pair.value;
        }

        while (!pair.key.equals(key)) pair = pair.next;

        pair.previous.next = pair.next;
        if (pair.next == null) return pair.value;
        pair.next.previous = pair.previous;

        size--;
        return pair.value;
    }

    private int getIndex(Object key) {
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public Collection<V> values() {
        return List.of();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }
}
