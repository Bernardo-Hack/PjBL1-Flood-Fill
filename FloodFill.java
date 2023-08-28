import java.util.Scanner;

public class FloodFill{
    public static void main(String[] args) {

        //Criação da "imagem" com cor inicial
        int inicialColor;
            int[][] image = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                    {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            }; 

            printa_image(image);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a linha inicial (0-9): ");
            int startXvalue = scanner.nextInt();

            System.out.print("Digite a coluna inicial (0-9): ");
            int startYvalue = scanner.nextInt();

            inicialColor = image[startXvalue][startYvalue];
            System.out.print("Digite o novo valor: ");
            int newColor = scanner.nextInt();

            System.out.print("Digite qual deseja utilizar (1.Pilha - 2.Fila): ");
            int opt = scanner.nextInt();
            
            if (opt == 1) {
                //Caso queira executar a Fila
                System.out.println("------------------------QUEUE------------------------");
                PaintQueue(image, startXvalue, startYvalue, inicialColor, newColor);
                
            } else if (opt == 2) {
                //Caso queira executar a Pilha
                System.out.println("------------------------STACK------------------------");
                PaintStack(image, startXvalue, startYvalue, inicialColor, newColor);

            } else {
                System.out.println("Insira uma opção válida.");

            }

            scanner.close();
    }

    //Printizinho da "imagem"
    public static void printa_image( int[][] image){
        for (int[] elemento : image) {
            for (int pixel : elemento) {
                System.out.print(pixel + " ");

            }
        System.out.println();

        }
    }
    
    //Compara a cor da cordenada a ser preenchida com a cor inicial
    //caso não seja igual (no caso 0) ele bloqueia a passagem
    public static boolean colorComparation(int[][] image, Par paratual, int inicialColor, int cor_nova) {
        int x = paratual.getV1();
        int y = paratual.getV2();

        if (image[x][y] == inicialColor) {
            return true;

        } else {
            return false;

        } 

    }

    //Função que armazena os valores vizinhos do valor atual da Fila
    public static void neighborQueue(int x,int y, int[][] image, CircularQueue<Par> queue){
        int xnovo = x - 1;
        int ynovo = y;
        Par parnovo = new Par(xnovo, ynovo);
        verificarQueue(xnovo, ynovo, image, queue, parnovo);

        xnovo = x + 1;
        ynovo = y;
        verificarQueue(xnovo, ynovo, image, queue, parnovo);

        xnovo = x;
        ynovo = y - 1;
        verificarQueue(xnovo, ynovo, image, queue, parnovo);

        xnovo = x;
        ynovo = y + 1;
        verificarQueue(xnovo, ynovo, image, queue, parnovo);

    }

    public static void verificarQueue(int xnovo, int ynovo, int[][]image, CircularQueue<Par> queue, Par parnovo){
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length) == true){
            parnovo = new Par(xnovo, ynovo);
            queue.add(parnovo);
        }
    }

    //Função que armazena os valores vizinhos do valor atual da Pilha
    public static void neighborStack(int x,int y, int[][] image, StaticStack<Par> stack){
        int xnovo = x - 1;
        int ynovo = y;
        Par parnovo = new Par(xnovo, ynovo);

        verificarStack(xnovo, ynovo, image, stack, parnovo);

        xnovo = x + 1;
        ynovo = y;

        verificarStack(xnovo, ynovo, image, stack, parnovo);

        xnovo = x;
        ynovo = y - 1;

        verificarStack(xnovo, ynovo, image, stack, parnovo);

        xnovo = x;
        ynovo = y + 1;

        verificarStack(xnovo, ynovo, image, stack, parnovo);
    }

    public static void verificarStack(int xnovo, int ynovo, int[][]image, StaticStack<Par> stack, Par parnovo){
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length) == true){
            parnovo = new Par(xnovo, ynovo);
            stack.push(parnovo);
        }
    }
    
    //Função que cria a fila e par inicial, realiza comparação de cor para instruir o armazenamento de 
    //cordenada, e colore
    public static void PaintQueue(int[][] image, int startX, int startY, int inicialColor, int newColor) {
        Par parinicio = new Par(startX, startY);
        CircularQueue<Par> queue = new CircularQueue<>(200);
        queue.add(parinicio);

        while (!queue.isEmpty()) {
            Par paratual = queue.remove();

            int x = paratual.getV1();
            int y = paratual.getV2();

            if (colorComparation(image, paratual, inicialColor, newColor)) {
                neighborQueue(x, y, image, queue);
                image[x][y] = newColor;

                System.out.println("---------------------------");
                printa_image(image);  
            }
        }
    }

    /* Função que cria a pilha e par inicial, realiza comparação de cor para instruir
     o armazenamento de cordenada, e colore */
    public static void PaintStack(int[][] image, int startX, int startY, int inicialColor, int newColor){
        Par parinicio = new Par(startX, startY);
        StaticStack<Par> stack = new StaticStack<>(200);
        stack.push(parinicio);

        if(newColor != inicialColor) {
            while (!stack.isEmpty()) {
                Par paratual = stack.pop();
                
                int x = paratual.getV1();
                int y = paratual.getV2();

                if (colorComparation(image, paratual, inicialColor, newColor)) {
                    neighborStack(x, y, image, stack);
                    image[x][y] = newColor;
                    
                    System.out.println("---------------------------");
                    printa_image(image);  
                }
            }
        } else {
            System.out.println("A imagem já está preenchida cojm essa cor!");

        }
    }
}   
