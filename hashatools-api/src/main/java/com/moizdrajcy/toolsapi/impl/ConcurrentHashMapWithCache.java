package com.moizdrajcy.toolsapi.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import com.moizdrajcy.toolsapi.MapWithCache;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapWithCache<K, V> implements MapWithCache<K, V> {

  private final Map<K, V> map;
  private final Cache<K, V> cache;

  public ConcurrentHashMapWithCache(long duration, TimeUnit timeUnit) {
    this.map = Maps.newConcurrentMap();
    this.cache = CacheBuilder.newBuilder().expireAfterWrite(duration, timeUnit).build();
  }

  public V get(K k) {
    V value = this.map.get(k);
    if (value == null) {
      value = this.cache.getIfPresent(k);
    }
    return value;
  }

  public void put(K k, V v) {
    this.map.put(k, v);
  }

  public void remove(K k) {
    V v = this.map.remove(k);
    if (v != null) {
      this.cache.put(k, v);
    }
  }

  public void forceRemove(K k) {
    this.map.remove(k);
    this.cache.invalidate(k);
  }

  public Collection<V> values() {
    return null;
  }
}
