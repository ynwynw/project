package com.pt.reactor.container;

import java.util.List;

/**
 * @author nate-pt
 * @date 2022/7/15 10:30
 * @Since 1.8
 * @Description
 */
public interface LineContainer<T> {


    /**
     * ����������ȡ����
     * @param key
     */
    List<T> pull(String key,Class<T> tClass);


    /**
     * ����������������
     * @param list
     * @param key
     */
    void push(List<T> list,String key);


    /**
     * �첽����
     * @param t
     */
    void async(T t);

}
