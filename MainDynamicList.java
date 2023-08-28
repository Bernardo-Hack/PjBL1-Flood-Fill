public class MainDynamicList {
    public static void main(String[] args) {
        
        DynamicList<Integer> ble = new DynamicList<>(10);

        ble.addNode(1);
        System.out.println(ble.getData(0));
        
        ble.addNode(2);
        System.out.println(ble.getData(1));
        
        ble.addNode(3);
        System.out.println(ble.getData(2));
        
        ble.addNode(4);
        System.out.println(ble.getData(3));
        
        ble.addNode(5);
        System.out.println(ble.getData(4));
        
        ble.addNode(6);
        System.out.println(ble.getData(5));
        
        ble.addNode(7);
        System.out.println(ble.getData(6));
        
        ble.addNode(8);
        System.out.println(ble.getData(7));
        
        ble.addNode(9);
        System.out.println(ble.getData(8));
        
        System.out.println(ble.getNode(3));
    }
}
