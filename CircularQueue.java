public class CircularQueue<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")

    public CircularQueue(int size) {
        this.data = (T[]) new Object[size];
    }

    public void add(T data) {

        if (this.isFull()) {
            System.out.println("Impossível adicionar um dado, a fila já está cheia! \n");
        } else {
            // Código extremamente duvidoso cuidado!

            if (this.top == -1) {
                this.top = 0;
            }
            
            base = move(base);
            this.data[base] = data;

        }
    }
     
    public T remove() {

        if (this.isEmpty()) {
            System.out.println("Impossível retirar um dado, a fila já está vazia! \n");
        } else {

            // Código de retirar dado aqui.

        }
        return null; // placeholder pro VScode não reclamar
    }

    public void clear() {
        
        @SuppressWarnings("unchecked")

        T[] newData = (T[]) new Object[this.data.length];
        this.data = newData;
        this.top = -1;
        this.base = 0;
    }
    
    public boolean isFull() {

        if (this.top == this.base && this.base == this.data.length - 1) {
            return true;

          } else if (this.top == this.top + 1) {
            return true;

          } else {
            return false;

          }
    }

    public boolean isEmpty() {

        if (this.top == -1) {
            return true;

        } else {
            return false;

        }
    }
    
    private int move(int pos) {

        if (pos + 1 == this.data.length) {
            return 0;

        } else {
            return pos++;

        }
    }
}
