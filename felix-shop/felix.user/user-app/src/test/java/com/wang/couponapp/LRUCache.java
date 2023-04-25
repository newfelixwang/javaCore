package com.wang.couponapp;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author：wp
 * @Package：com.wang.couponapp
 * @Project：java-Core
 * @name：LRUCache
 * @Date：2023/4/24 17:10
 * @Filename：LRUCache
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    /**
     * 雪花id生成工具
     */
    public static Snowflake snowFlowUtils = IdUtil.getSnowflake();

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }


    /**
     * 是否删除超过容量数据
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (size() > cacheSize) {
            System.out.println("超过容量删除" + eldest.getKey());
        } else {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        long id = snowFlowUtils.nextId();
        System.out.println(id);

        LRUCache lruCache = new LRUCache(4);
        lruCache.put("a", "1");
        lruCache.put("b", "2");
        lruCache.put("c", "3");
        lruCache.put("d", "4");
        lruCache.put("e", "5");
        lruCache.put("f", "6");

        Iterator iterator1 = lruCache.entrySet().iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("###########");
        lruCache.get("b");
        Iterator iterator2 = lruCache.entrySet().iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

    }
}
