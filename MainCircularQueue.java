public class MainCircularQueue {
    
    public static void main(String[] args) {

        CircularQueue<Integer> queue = new CircularQueue<>(10);

        for(int i = 0; i < 10; i++){
            queue.add(i);
        }

        queue.printQueue();

        //queue.remove();

        queue.printQueue();

        queue.add(50);
        queue.add(70);

        queue.printQueue();
    }
}
