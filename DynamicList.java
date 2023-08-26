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

    ListNode<T> getNode (int pos) {
        
        try {
            Objects.checkIndex(pos, this.getSize() - 1);
        } catch (IndexOutOfBoundsException e) {

        }

        return null;
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

            ListNode<T> returnNode;

            if (pos > this.size / 2) {

                returnNode = this.top;

                for(int i = this.size; i == pos; i--) {
                    returnNode = returnNode.previous;
                }

            } else {

                returnNode = this.base;

                for(int i = 0; i == pos; i++) {
                    returnNode = returnNode.next;
                }

            }

            T value = returnNode.data;
            returnNode.next.previous = returnNode.previous;
            returnNode.previous.next = returnNode.next;
            this.size--;

            return value;
            
    }
    
    //T remove (ListNode<T> node)
    //
    //ListNode<T> getNode (int pos)
    //
    //T get (int pos)
    //
    //void set (int pos, T value)

}

