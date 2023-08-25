public class StaticStack<T> {
    private int top = -1;
    private T[] data;

    @SuppressWarnings("unchecked")
    
    StaticStack(int size) {

        this.data = (T[]) new Object[size];
    }
    
    public void push(T data) {
        
        this.top++;
        if (this.isEmpty()) {

            this.data[0] = data;
            this.top = 0;

        } else {
            try {

                this.data[this.top] = data;

            } catch(ArrayIndexOutOfBoundsException e) {

                System.out.println("Impossível adicionar um dado, a Pilha já está cheio! \n");
            }
        }
    }

    public T pop() {

        try {
            
            T value = this.data[top];
            this.data[top] = null;
            this.top--;
            return value;

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Impossível retirar um dado, a Pilha já está vazia! \n");
            return null;
        }
    }

    public void clear() {

        @SuppressWarnings("unchecked")

        T[] newData = (T[]) new Object[this.data.length];

        this.data = newData;
        this.top = -1;
    }

    public boolean isFull() {

        if (top == this.data.length) {

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

    void printStack() {
        
        System.out.print("\n");
        for(int i = 0; i < this.data.length; i++) {

            System.out.println(i + " : " + this.data[i]);

        }
        System.out.print("\n");
    }
}
