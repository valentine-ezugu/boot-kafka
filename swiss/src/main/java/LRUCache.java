import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private Map<K, V> map;

    public LRUCache(int cacheSize) {
        map = new LinkedHashMap<K, V>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public V get(K key) {
        return map.get(key);
    }

    public void set(K key, V value) {
        this.map.put(key, value);
    }

}
