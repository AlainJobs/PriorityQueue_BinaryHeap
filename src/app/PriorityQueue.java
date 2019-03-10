package app;

public interface PriorityQueue<K extends Comparable<K>,V>{

    public int size();
    public boolean isEmpty();
    public Entry<K,V> min();//exception
    public void insert(K key, V value);//Exception
    public Entry<K,V> remove();//exception

}