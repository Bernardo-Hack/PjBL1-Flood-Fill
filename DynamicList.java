import java.util.Objects;

public class DynamicList<T> {
    ListNode<T> base;
    ListNode<T> top;
    int size;

    //Subclasse dos nós
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

    //Essa função verifica se a lista esta vazia
    boolean isEmpty() {
        if (this.base == null && this.top == null) {
            return true;
        } else {
            return false;
        }
    }

    //Essa função verifica se a lista esta cheia
    boolean isFull() {
        if (this.base != null && this.top != null && this.top != this.base) {
            return true;
        } else {
            return false;
        }
    }

    //Essa função retorna o tamanho da lista
    int getSize() {
        return this.size;
    }

    //Essa função pega o nó baseado na posição dele na lista
    ListNode<T> getNode (int pos) {
        
        try {
            Objects.checkIndex(pos, this.getSize() - 1);
        } catch (IndexOutOfBoundsException e) {

        }

        return null;
    }

    //Essa função adiciona dados a lista
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

    //Essa função remove dados da lista
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
    //Função que adiciona dados pelo indice
    void set (int pos, T value){
        if (pos == size){
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
        } else {
            ListNode<T> newNode = new ListNode<T>(value);
            
            ListNode<T> returnNode;

            

            returnNode.previous = returnNode.next.previous;
            returnNode.next = returnNode.previous.next;
        }
    }
}

