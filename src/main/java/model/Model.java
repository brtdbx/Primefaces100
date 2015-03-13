package model;

import bizmodel.BizModel;
import guis.utils.Helper;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Model implements Serializable {

    private BizModel bizModel;

    //PostConstruct specifies the lifecycle callback method that 
    //the CDI framework calls after dependency injection 
    //but before the class is put into service.
    @PostConstruct
    public void init() {
        System.out.println("init Model");
        bizModel = new BizModel();
        bizModel.init();
        updateModelStatus01();
    }

    public String getTextInput() {
        return bizModel.getTextInput();
    }

    public void setTextInput(String textInput) {
        bizModel.setTextInput(textInput);
        System.out.println("textInput was set to: " + textInput);
    }

    public String getSomeText2() {
        return bizModel.getSomeText2();
    }

    public void setSomeText2(String someText2) {
        bizModel.setSomeText2(someText2);
    }

    public String getSomeText() {
        return bizModel.getSomeText();
    }

    public void setSomeText(String someText) {
        bizModel.setSomeText(someText);
    }

    private String modelStatus01;

    public String getModelStatus01() {
        return modelStatus01;
    }

    public String getUser() {
        return bizModel.getUser();
    }

    public void setUser(String user) {
        bizModel.setUser(user);
    }

    public String getPassword() {
        return bizModel.getPassword();
    }

    public void setPassword(String password) {
        bizModel.setPassword(password);
    }

    public boolean checkUserPwd() {
        return bizModel.checkUserPwd();
    }

    public void updateModelStatus01() {
        System.out.println("in updateModelStatus01");
        String requestID = Helper._getRequestHashCode();
        requestID = (requestID == null) ? "" : requestID;
        String sessionID = Helper._getSessionID();
        sessionID = (sessionID == null) ? "" : sessionID;
        String usr = bizModel.getUser();
        bizModel.getUser();
        usr = (usr == null) ? "" : usr;
        String status = "user: " + usr + " | Session: " + sessionID + " | Model data from RequestHash: " + requestID;
        System.out.println("status=" + status);
        System.out.println("----------------------------------------------");
        System.out.println("textInput=" + bizModel.getTextInput());
        this.modelStatus01 = status;
    }

}
