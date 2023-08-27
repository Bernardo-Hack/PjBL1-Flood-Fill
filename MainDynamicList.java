public class MainDynamicList {
    public static void main(String[] args) {
        
        DynamicList<Integer> ble = new DynamicList<>(10);

        for(int i = 0; i < 100; i++){
             if(i % 9 == 0 && i != 0){
                ble.addNode(0);               
            }else{
                ble.addNode(3);  
            }
            
        } //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

        ble.print2DList();

    }
}
