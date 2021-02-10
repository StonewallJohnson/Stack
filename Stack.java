public class Stack<E>{
    private int size;
    //TODO: make a linked list
    private LinkedList<E> container;

    public Stack(){
        size = 0;
        container = new LinkedList<E>();
    }

}