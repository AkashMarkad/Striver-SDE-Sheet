// LRU cache
// Important

// Approach: Map and Doubly Linked List
// Craete a head and tail dummy node
// use map store the key and the address of the node 
// Lru node is present at the right after the tail 
// Most recentaly used node is present right after head node

// Code :

class LRUCache {
    
    class Node{
        Node prev , next;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node head = new Node(0,0) , tail = new Node(0,0);
    HashMap<Integer, Node> hm = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }
        
        if(hm.size() == capacity){
            remove(tail.prev);
        }
        
        insert(new Node(key , value));
    }
    
    private void remove(Node node){
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node){
        hm.put(node.key , node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
