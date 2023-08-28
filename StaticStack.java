public class StaticStack<T> {
    private int top = -1; // Váriavel que armazena a posição do último dado inserido
    private T[] data; // Variável do array genérico vazio

    @SuppressWarnings("unchecked") //Os avisos estavam irritando :p

    // Constructoe da classe StaticStack cria a pilha do tipo escolhido
    StaticStack(int size) {
        this.data = (T[]) new Object[size];

    }
    
    // A função push adiciona dados a pilha
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

    // A função pop remove o último elemnto inserido e retorna o dado
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

    /* A função clear tem como objetivo limpar a pilha, essa função o array data
    um novo array genérico com o mesmo tamanho com valores nulos */
    public void clear() {

        @SuppressWarnings("unchecked")

        T[] newData = (T[]) new Object[this.data.length];

        this.data = newData;
        this.top = -1;
    }

    // A função isFull retorna se a pilha está cheia
    public boolean isFull() {
        if (top == this.data.length) {
            return true;

        } else {
            return false;

        }
    }

    // A função isEmpty retorna se a pilha está vazia
    public boolean isEmpty() {
        if (this.top == -1) {
            return true;

        } else {
            return false;

        }
    }

    /* A função printStack foi criada para printar a pilha bonitinho
    não vai funcionar quando valor é instanciado com T */
    void printStack() {
        System.out.print("\n");

        for(int i = 0; i < this.data.length; i++) {
            System.out.println(i + " : " + this.data[i]);

        }
        System.out.print("\n");
    }
}
