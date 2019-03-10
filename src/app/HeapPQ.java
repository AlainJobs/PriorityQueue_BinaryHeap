package app;



public class HeapPQ<K extends Comparable<K>, V> implements PriorityQueue<K,V>{


    private static final int DEFAULT_CAPACITY = 10;
    private Entry<K,V>[] array;
    private int size;


    @SuppressWarnings("unchecked")
    public HeapPQ(){
         array = new Entry[DEFAULT_CAPACITY];  
         size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void insert(K key, V value){

        DynamicResize();
        size++;
        int index=size;
        array[index] = new Entry<>(key, value);
        bubbleUp();
    }

    public Entry<K,V> remove() {
    	// what do want return?
    	Entry<K,V> result = min();
    	
    	// get rid of the last leaf/decrement
    	array[1] = array[size];
    	array[size] = null;
    	size--;
    	bubbleDown();
    	return result;
    }

    private Entry<K,V>[] copyArray_doubling(){
        int size=this.array.length; 
        Entry<K,V>[] newArray = (Entry[])new Object[size*2]; //cheating?
        for(int i=0; i < size;i++){ // je l'ai saute!
        newArray[i]= this.array[i];
        }
        return newArray;
    }

    private void DynamicResize(){
        if(size >= array.length -1)
        this.array=copyArray_doubling();
    }

     
    private boolean hasParent(int i) {
        return i > 1;
    }
    
    
    private int leftIndex(int i) {
        return i * 2;
    }
    
    
    private int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    private boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    
    private boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    
    private Entry<K,V> parent(int i) {
        return array[parentIndex(i)];
    }
    
    
    private int parentIndex(int i) {
        return i / 2;
    }
    
    
    
    private void swap(int index1, int index2) {
        Entry<K,V> tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }

    public int size(){
        return size;
    }

    private void bubbleUp() {
        int index = this.size;
        
        while (hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }

    private void bubbleDown() {
        int index = 1;
        
        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);
            
            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index)
                && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            } 
            
            if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }
            
            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }        
    }

    public String toString(){

        String str_list= "";

        
        for(int i = 1; i <= size; i++) {
            //int index = (front + i) % size;
            str_list+=((array[i].toString()+" \n"));
        }
        return str_list;

    }
 
    public Entry<K,V> min() {
        if (this.isEmpty()) {
            System.out.println("HMMM NEGATIF!");
            return null;
        }
        
        return array[1];
    }


}