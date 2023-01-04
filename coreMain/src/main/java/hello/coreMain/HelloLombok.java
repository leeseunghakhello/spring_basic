package hello.coreMain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;
    
    public static void main(String[] args){
        HelloLombok helloLombok=new HelloLombok();
        helloLombok.setName("asdfafd");
        
        String name=helloLombok.getName();
        System.out.println("name = " + name);

        //toString을 사용하면 위와 다르게 이렇게 바로 프린트 할 수 있다.
        //System.out.println("helloLombok = " + helloLombok);
        
    }
}
