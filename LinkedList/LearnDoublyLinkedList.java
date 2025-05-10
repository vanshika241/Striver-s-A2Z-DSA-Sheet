//LinkedList from Arrays
public static Node buildDLL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
        return head;
    }

    //Insertion at any Node (After that Node)
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node newNode = new Node(x);
        if(p == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        
        int i=0;
        Node temp = head;
        while(i<p && temp.next != null){
            temp = temp.next;
            i++;
        }
        if(temp.next == null){
            temp.next = newNode;
            newNode.prev = temp;
            return head;
        }
        
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }
    
    //Delete any Node
    public Node deleteNode(Node head, int x) {
        // code here
        if(x == 1){
            head = head.next;
            head.prev = null;
            return head;
        }
        int i=1;
        Node temp = head;
        while(temp != null && i<x-1){
            temp = temp.next;
            i++;
        }
        if(temp == null || temp.next == null){
            return head;
        }
        Node delNode = temp.next;
        temp.next = delNode.next;
        
        if(delNode.next != null){
            delNode.next.prev = temp;
        }
        return head;
    }

    //Reverse a doubly LinkedList
    public Node reverseDLL(Node head) {
        // Your code here
        if(head == null || head.next == null)return head;
        Node last = null;
        Node curr = head;
        while(curr != null){
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }
        return last.prev;
    }
