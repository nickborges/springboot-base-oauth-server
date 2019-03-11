package br.com.springboot.base.core.util;

public class Util<T> {

    public T validaNull(T obj){
        return obj != null ? obj : null;
    }
}
