package com.moizdrajcy.toolsapi;

import java.util.Collection;

public interface MapWithCache<K, V> {

  V get(K k);

  void put(K k, V v);

  void remove(K k);

  void forceRemove(K k);

  Collection<V> values();
}
