public class Stack<E>{
    private LinkedList<E> container;

    public Stack(){
        container = new LinkedList<E>();
    }

    /**
     * Pushes the given val onto the stack
     * @param val the val to be pushed
     */
    public void push(E val){
        container.addFront(val);
    }

    /**
     * Pops the top of the stack
     * @return the value that was on the top of the stack
     */
    public E pop(){
        return container.removeFront();
    }

    /**
     * Returns the value at the top of the stack
     * @return the value at the top of the stack
     */
    public E peek(){
        return container.getHead();
    }

    /**
     * 
     * @return the size of the stack
     */
    public int size(){
        return container.size();
    }

    /**
     * 
     * @return whether or not the stack is empty
     */
    public boolean isEmpty(){
        return container.size() == 0;
    }

    /**
     * Empties the stack
     */
    public void empty(){
        container.empty();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Stack<E> temp = new Stack<E>();

        while(!this.isEmpty()){
            //push this onto temp
            temp.push(this.pop());
            str.append(temp.peek().toString());
            str.append(", ");
        }
        while(!temp.isEmpty()){
            //return state
            this.push(temp.pop());
        }
        
        return str.toString();
    }
}