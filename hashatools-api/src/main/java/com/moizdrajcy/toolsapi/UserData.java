package com.moizdrajcy.toolsapi;

public abstract class UserData<T> {

  private final T t;

  protected UserData(T t) {
    this.t = t;
  }

  protected T get() {
    return t;
  }

}
