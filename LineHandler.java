package com.pt.reactor.container;

import java.util.List;

/**
 * @author nate-pt
 * @date 2022/7/15 11:23
 * @Since 1.8
 * @Description ���д���
 */
public interface LineHandler<T> {

    /**
     * �ŶӶ���
     * @return
     */
    List<T> search(String key,Class<T> tClass);

    /**
     * ��һλ
     * @param key
     */
    void callNext(String key,Class<T> tClass);

    /**
     * �غ�
     * @param key
     * @param t
     */
    void callAge(String key,T t,Class<T> tClass);
}
