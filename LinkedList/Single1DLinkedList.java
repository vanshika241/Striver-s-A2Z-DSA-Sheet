   //LinkedList from Array
   public static Node constructLL(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    //Inserting a node in LinkedList
    static Node insert(Node head, int n, int pos, int val) {
        // Write your code here.
        Node newNode = new Node(val);
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        int i=0;
        Node temp = head;
        while(temp != null && i<pos-1){
            temp = temp.next;
            i++;
        }
        if(temp == null)return head;
       
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    //Delete Node in an LinkedList
    Node deleteNode(Node head, int x) {
        // code here
        if(x == 1){
            head = head.next;
            return head;
        }
        Node temp = head;
        int i=1;
        while(i<x-1 && temp.next != null){
            temp = temp.next;
            i++;
        }
        if(temp.next == null)return head;
        temp.next = temp.next.next;
        return head;
    }
    
    //Length of LinkedList
    public int getCount(Node head) {
        // code here
        int sz = 0;
        Node temp = head;
        while(temp != null){
            sz++;
            temp = temp.next;
        }
        return sz;
    }

    //Search an element in LinkedList
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
