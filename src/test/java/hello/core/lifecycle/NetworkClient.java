package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url){
        System.out.println("의존 관계 설정");
        this.url = url;
    }

    public void connent(){
        System.out.println("connect:" + url);
    }

    public void call(String message){
        System.out.println("call = " + url + " message = " + message);
    }

    public void disConnect() {
        System.out.println("close " + url);
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }

    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connent();
        call("초기화 연결 메시지");
    }
}
