package com.pt.reactor.container;

import java.util.List;

/**
 * @author nate-pt
 * @date 2022/7/15 11:23
 * @Since 1.8
 * @Description
 */
public class DefaultLineHandler<T> implements LineHandler<T>{

    private LineContainer<T> container = new DefaultLineHandlerContainer();

    @Override
    public List search(String key,Class<T> tClass) {
        return container.pull(key, tClass);
    }

    @Override
    public void callNext(String key,Class<T> tClass) {
        List<T> pull = container.pull(key,tClass);
        T t = pull.get(0);
        // ����״̬
        container.async(t);
        // ����ɾ����һ��
        pull.remove(0);
        container.push(pull,key);
    }

    @Override
    public void callAge(String key, T t,Class<T> tClass) {
        List<T> pull = container.pull(key, tClass);
        int indexOf = pull.indexOf(t);
        // ���������±��Ӧɾ��
        pull.remove(indexOf);
        // ���غ��ķŵ���һλ
        pull.add(0,t);

        // ͬ��״̬
        container.async(t);
    }
}
