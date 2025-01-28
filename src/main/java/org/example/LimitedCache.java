package org.example;

import java.util.LinkedHashMap;

public class LimitedCache<K, V> {
    private final int maxSize;
    private final LinkedHashMap<K, V> cache;

    public LimitedCache(int maxSize) {

        this.maxSize = maxSize;
        this.cache = new LinkedHashMap<>();
    }

    public void put(K key, V value) {

        /*if (cache.containsKey(key)) {
            cache.replace(key, value);
            return;
        }*/
        /* Обновляем значение по ключу*/
        cache.compute(key, ((k, v) -> v = value));
        /* тут мы можем выйти за границы размера кеша, но не надолго. Если в методе computeIfAbsent
           произойдет вставка нового элемента. В следующем шаге удалится первый элемент и размер придет в норму*/
        cache.computeIfPresent(key, (k, v) -> value);
        if (cache.size() > maxSize)
            cache.remove(cache.firstEntry().getKey());

        //cache.putLast(key, value);
    }
    public V get(K key){

        return cache.get(key);
    }
    public boolean containsKey(K key) {

        return cache.containsKey(key);
    }
    public int size() {

        return cache.size();
    }
}

class MainCache {
    public static void main(String[] args) {

        LimitedCache<String, String> stringCache = new LimitedCache<>(5);
        LimitedCache<Integer, String> integerCache = new LimitedCache<>(5);

        stringCache.put("1", "qaz");
        stringCache.put("2", "wsx");
        stringCache.put("2", "wsxjkjk");
        stringCache.put("3", "edc");
        stringCache.put("4", "rfv");
        stringCache.put("5", "tgb");
        stringCache.put("6", "yhn");

        System.out.println(stringCache.containsKey("5"));
        System.out.println("Значение ключа: " + stringCache.get("2"));
        System.out.println("Размер кеша: " + stringCache.size());

        integerCache.put(1, "qaz");
        integerCache.put(2, "wsx");
        integerCache.put(2, "wsxjkjk");
        integerCache.put(3, "edc");
        integerCache.put(4, "rfv");
        integerCache.put(5, "tgb");
        integerCache.put(6, "yhn");

        System.out.println(integerCache.containsKey(2));
        System.out.println("Значение ключа: " + integerCache.get(10));
        System.out.println("Размер кеша: " + integerCache.size());
    }

}

