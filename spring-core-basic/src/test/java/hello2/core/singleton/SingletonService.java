package hello2.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // getInstance 로 받게 하기 위함
    // 생성자를 private 로 하여 외부에서 new 키워드를 사용한 객체 생성을 막아둠
    private SingletonService() {
    }


    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
