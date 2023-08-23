import java.util.Objects;

public class DynamicList<T> {
    ListNode<T> base;
    ListNode<T> top;
    int size;

    private static class ListNode<T> {

        ListNode<T> previous;
        T data;
        ListNode<T> next;
        
        public ListNode(T data) {
            this.previous = null;
            this.data = data;
            this.next = null;

        }
    }

    boolean isEmpty() {
        if (this.base == null && this.top == null) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (this.base != null && this.top != null && this.top != this.base) {
            return true;
        } else {
            return false;
        }
    }

    int getSize() {
        return this.size;
    }

    void add(T value) {

        if (this.isEmpty()) {

            ListNode<T> firstNode = new ListNode<T>(value);
            this.base = this.top = firstNode;
            this.size = 1;

        } else {

            ListNode<T> newNode = new ListNode<T>(value);
            newNode.previous = this.top;
            this.top = newNode.previous.next = newNode;
            this.size++;

        }
    }

    T remove (int pos) {

        if (pos == 0) {

            ListNode<T> oldBase = this.base;
            ListNode<T> newBase = this.base.next;

            T value = oldBase.data;
            newBase.previous = null;
            this.base = newBase;
            this.size--;

            return value;
            
        } else if (pos == this.size - 1) {

            ListNode<T> oldTop = this.base;
            ListNode<T> newTop = this.base.next;

            T value = oldTop.data;
            newTop.next = null;
            this.top = newTop;
            this.size--;

            return value;

        } else {

            if (pos > this.size / 2) {

            } else {

                

            }

        }
    }
    
    //T remove (ListNode<T> node)
    //
    ListNode<T> getNode (int pos) {
        
        Objects.checkIndex(pos, this.getSize() - 1);
        
        for 
    } 
    //
    //T get (int pos)
    //
    //void set (int pos, T value)

}

