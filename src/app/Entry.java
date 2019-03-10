package app;

public class Entry<K extends Comparable<K>,V>{

    public K key;
    public V value;

    public Entry(K key,V value){
        this.key = key;
        this.value = value;
    }

    
   public int compareTo(Entry<K,V> second){

       if((this.key).compareTo(second.key) < 0)
       return -1;
       else if((this.key).compareTo(second.key) > 0)
       return 1;
       else return 0;
   }

   public String toString(){
   
    return "Key: "+key+"\tValue: "+value;
}
   
       

    
}