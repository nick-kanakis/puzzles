package Stack_Queue.helper;

import java.util.EmptyStackException;

/**
 * Created by Nicolas on 9/11/2017.
 */
public class MyStack<T> {
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if(top == null)
            throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode<T> newNode = new StackNode<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T peek(){
        if(top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
