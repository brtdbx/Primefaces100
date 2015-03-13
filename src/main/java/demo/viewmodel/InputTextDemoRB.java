package demo.viewmodel;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InputTextDemoRB implements Serializable {

    private String inputText01;

    public String getInputText01() {
        return inputText01;
    }

    public void setInputText01(String inputText01) {
        this.inputText01 = inputText01;
    }
    
    @PostConstruct
    public void init() {
        System.out.println("init InputTextDemoRB");
    }

}
