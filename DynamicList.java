import java.util.Objects;

public class DynamicList<T> {
    ListNode<T> base;
    ListNode<T> top;
    int lineLen;
    int size;

    //Constructor da Lista
    public DynamicList(int len) {
        this.base = null;
        this.top = null;
        this.lineLen = len;
        this.size = 0;
    }

    //Subclasse dos nós
    private static class ListNode<T> {

        ListNode<T> top = null;
        ListNode<T> previous = null;
        ListNode<T> next = null;
        ListNode<T> bottom = null;
        T data;
        
        public ListNode(T data) {
            this.data = data;
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

    //Essa função pega o nó baseado na posição dele na lista
    ListNode<T> getNode (int pos) {
        
        try {
            Objects.checkIndex(pos, this.size - 1);

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

        } else if (this.size < this.lineLen) {
            ListNode<T> newNode = new ListNode<T>(value);
            newNode.previous = this.top;
            this.top = newNode.previous.next = newNode;
            this.size++;

        } else {
            ListNode<T> newNode = new ListNode<T>(value);
            
            newNode.previous = this.top;
            this.top = newNode.previous.next = newNode;

            ListNode<T> auxNode = this.getNode(this.size - this.lineLen);
            newNode.top = auxNode;
            auxNode.bottom = newNode;
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

            ListNode<T> auxNode = returnNode.next;

            auxNode.top = returnNode.top;
            auxNode.bottom = returnNode.bottom;
            
            while(true) {
                auxNode = auxNode.next;

                if(auxNode == null) {

                    break;

                } else {
                    auxNode.top = auxNode.previous.top;
                    auxNode.bottom = auxNode.previous.bottom;

                }
            }
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

    /* Essa função faz o print da matriz 
    corretamente, baseado na variável {this.collumnLen} */
    void print2DList() {
/*         for (int j = 0; j < 100; j++) {
                ListNode<T> auxNode = this.getNode(j);
                System.out.print(" " + auxNode.data + " ");}*/
//        for (int i = this.lineLen; i < this.size; i += this.lineLen) {
            
            for (int j = 0; j < 100; j++) {
                ListNode<T> auxNode = this.getNode(j);
                System.out.print(" " + auxNode.data + " ");
                /*if(j % 10 == 0 && j != 0){
                    System.out.print("]\n");
                    System.out.print("[");
                }*/
            } 
            

 //       }
    }
}
