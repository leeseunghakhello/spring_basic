package hello.coreMain.singletonTest;

public class StateFulService {
    private int price;//상테를 유지하는 필드 10000-> 20000

    public int order(String name, int price){
        System.out.println("name+\"ptivr = \"+price = " + name+"ptivr = "+price);
        this.price=price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }

}
