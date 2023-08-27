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
            System.out.println("Posição informada inválida!");

        }

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

            return returnNode;
    }

    //Essa função adiciona dados a lista
    void addNode (T value) {

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

    //Essa função remove um nó da lista e retorna seu valor
    T pop (int pos) {

            ListNode<T> returnNode = this.getNode(pos);

            T value = returnNode.data;
            returnNode.next.previous = returnNode.previous;
            returnNode.previous.next = returnNode.next;
            this.size--;

            return value;
            
    }

    //Essa função retorna o valor de um nó da lista
    T getData (int pos) {
        ListNode<T> returnNode = this.getNode(pos);

        return returnNode.data;
    }

    //Essa função troca o valor de um nó da lista
    void setData (int pos, T value) {
        if (this.isEmpty()) {
            System.out.println("Lista está vazia.");

        } else {
            ListNode<T> auxNode = this.getNode(pos);

            auxNode.data = value;
        }
    }
}
