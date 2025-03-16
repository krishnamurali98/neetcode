class MyHashSet {
    boolean[] arr;
    public MyHashSet() {
        arr = new boolean[(int)1e6+1];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}