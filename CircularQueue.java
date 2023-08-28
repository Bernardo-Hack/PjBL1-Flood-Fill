public class CircularQueue<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")

    public CircularQueue(int size) {
        this.data = (T[]) new Object[size];
    }

    public boolean isFull() {

        if (this.top == this.base) {
            return true;

        } else {
           return false;
        }
    }

    public void add(T data) {

        top = move(top);
        if (isFull() == true) {
            System.out.println("Impossível adicionar um dado, a fila já está cheia! \n");
            
        } else {
            // Código extremamente duvidoso cuidado!
            if (this.top == -1) {
                this.top = 0;
                this.data[top] = data;
                this.top++;
                
            }
            else {
                
                this.data[top] = data;
                this.top++;
                
            }
        }
    }
     
    public T remove() {

        try {
        
            T value = this.data[base];
            this.data[base] = null;
            this.base++;
            return value;

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Impossível retirar um dado, a fila já está vazia! \n");
            return null;
        }

    }

    public void clear() {
        
        @SuppressWarnings("unchecked")

        T[] newData = (T[]) new Object[this.data.length];
        this.data = newData;
        this.top = -1;
        this.base = 0;
    }
    
    

    public boolean isEmpty() {

        if (this.top == -1) {
            return true;

        } else {
            return false;

        }
    }
    
    private int move(int pos) {

        if (pos + 1 == this.data.length + 1) {
            return 0;

        } else {
            return pos++;
        }
    }

    void printQueue() {
        
        System.out.print("\n");
        for(int i = 0; i < this.data.length; i++) {

            System.out.println(this.data[i]);

        }
        System.out.print("\n");
    }
}
