public class CircularQueue<Par> {
    private int top = -1;
    private int base = 0;
    private Par[] data;

    @SuppressWarnings("unchecked")

    public CircularQueue(int size) {
        this.data = (Par[]) new Object[size];
    }
    
    // Essa função retorna se a fila está cheia
    public boolean isFull() {

        if (this.top == this.base) {
            return true;

        } else {
           return false;

        }
    }

    // Essa função retorna se a fila está vazia
    public boolean isEmpty() {

        if (this.top == -1) {
            return true;

        } else {
            return false;

        }
    }

    // Essa função adiciona um valor a fila
    public void add(Par data) {

        top = move(top);
        if (isFull() == true) {
            System.out.println("Impossível adicionar um dado, a fila já está cheia! \n");
            
        } else {
            // Código extremamente duvidoso cuidado!
            if (isEmpty()) {
                this.top = 0;
                this.data[top] = data;
                this.top++;
                
            } else {
                this.data[top] = data;
                this.top++;
                
            }
        }
    }
    
    // Essa função remove o valor da fila na posição base
    public Par remove() {

        Par value = this.data[base];

        if (value == null) {
            System.out.println("Impossível remover um dado, a fila já esta vazia! ");

        } else {
            this.data[base] = null;
            this.base++;

            if (base == top) {
                top = -1;
                base = 0;

            }
        }
        return value;
    }

    // Essa função limpa os valores na pila
    public void clear() {
        
        @SuppressWarnings("unchecked")

        Par[] newData = (Par[]) new Object[this.data.length];
        this.data = newData;
        this.top = -1;
        this.base = 0;
    }
    
    // Essa função checa para qual posição o dado será posicionado
    private int move(int pos) {

        if (pos + 1 == this.data.length + 1) {
            return 0;

        } else {
            return pos++;

        }
    }

    // Essa dunção faz o print da fila
    void printQueue() {
    
        System.out.print("\n");
        for(int i = 0; i < this.data.length; i++) {
            System.out.println(this.data[i]);

        }
        System.out.print("\n");
    }
}
