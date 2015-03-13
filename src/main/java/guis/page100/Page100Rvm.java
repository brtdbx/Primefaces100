package guis.page100;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Page100Rvm {

    private String modelStatus;

    public String getModelStatus() {
        System.out.println("modelStatus in rvm gelesen als:" + modelStatus);
        return modelStatus;
    }

    public void setModelStatus(String modelStatus) {
        System.out.println("modelStatus of rvm set to: " + modelStatus);
        this.modelStatus = modelStatus;
    }

    private String someText;

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }
    
    private String someText2;

    public String getSomeText2() {
        return someText2;
    }

    public void setSomeText2(String someText2) {
        this.someText2 = someText2;
    }
    
    
    @PostConstruct
    public void init() {
        System.out.println("init Page100Rvm");
    }

}
