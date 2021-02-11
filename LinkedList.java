public class LinkedList<E>{
    private int size;
    Node<E> head;

    private class Node<T>{
        private T con;
        private Node<T> next;

        public Node(T val, Node<T> link){
            con = val;
            next = link;
        }

        public Node(T val){
            this(val, null);
        }
    }

    public LinkedList(){
        size = 0;
        head = null;
    }

    /**
     * Adds the given value to the linked list
     * @param val value to add
     */
    public void add(E val){
        checkValNull(val);
        
        if(size == 0){
            //adding head
            head = new Node<E>(val);
        }
        else{
            //adding other
            Node<E> temp = head;
            while(temp.next != null){
                //until last node
                temp = temp.next;
            }
            temp.next = new Node<E>(val);
        }
        size++;
    }

    /**
     * Makes this value the head node
     * @param val value to be added
     */
    public void addFront(E val){
        Node<E> temp = new Node<E>(val, head);
        head = temp;
        size++;
    }

    /**
     * Finds the given value in the linked list
     * @param val the value searched for
     * @return the val if found, null if not
     */
    public E get(E val){
        return getRecur(head, val);
    }

    /**
     * 
     * @return the head of the linked list
     */
    public E getHead(){
        return head.con;
    }

    private E getRecur(Node<E> current, E val){
        if(current == null){
            //base case: val not in list
            return null;
        }
        else if(current.con.equals(val)){
            //base case: found val
            return current.con;
        }
        else{
            //recurse
            return getRecur(current.next, val);
        }
    }

    /**
     * Removes the given value from the linked list
     * @param val the value to be removed
     */
    public void remove(E val){
        Node<E> temp = head;
        if(temp.con.equals(val)){
            //removing head
            head = head.next;
        }
        else{
            //removing internal node
            while(temp.next != null && !temp.next.con.equals(val)){
                //temp.next is not val and not null
                temp = temp.next;
            }
            if(temp.next != null){
                //val is found
                temp.next = temp.next.next;
            }
        }
        size--;
    }
    
    /**
     * Removes the head
     */
    public E removeFront(){
        E val = head.con;
        if(size > 0){
            head = head.next;
            size--;
        }
        else{
            System.out.println("bad");
        }
        return val;
    }

    /**
     * Makes the linked list empty
     */
    public void empty(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Node<E> temp = head;
        while(temp != null){
            //for every element in the list
            str.append(temp.con.toString() + ", ");
            temp = temp.next;
        }

        return str.toString();
    }

    private void checkValNull(E val){
        if(val == null){
            throw new IllegalArgumentException("Can't store null!");
        }
    }
}