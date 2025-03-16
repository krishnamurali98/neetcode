class ListNode {
    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    ListNode[] HashMap;

    public MyHashMap() {
        HashMap = new ListNode[10000];
        for (int i = 0; i < 10000; i++) {
            HashMap[i] = new ListNode(-1, -1);
        }
    }

    public int hash(int key) {
        return key % HashMap.length;
    }

    public void put(int key, int value) {
        int index = hash(key);
        ListNode curr = HashMap[index];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.value = value;
                return;
            }
            curr = curr.next;
        }
        ListNode newNode = new ListNode(key, value);
        curr.next = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        ListNode curr = HashMap[index].next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        ListNode curr = HashMap[index];
        while (curr != null && curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
