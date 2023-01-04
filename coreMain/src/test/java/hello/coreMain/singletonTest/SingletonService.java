package hello.coreMain.singletonTest;

public class SingletonService {
    private static final SingletonService instance=new SingletonService();

    //조회
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱클톤 객체 로직 호출");
    }


}
