package guis.page100;

import guis.utils.Helper;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Model;

@Named
@RequestScoped
public class Page100Controller implements Serializable {

    //the model is always session scoped  - one model per user
    @Inject
    Model model;

    //the page100Rvm is in request scope
    @Inject
    Page100Rvm page100Rvm;
    
    public void setPage100Rvm(Page100Rvm page100Rvm) {
        this.page100Rvm = page100Rvm;
    }
    
    public Page100Rvm getPage100Rvm() {
        return page100Rvm;
    }
    
    public void submit() {
        System.out.println("submit button hit");
        doSomething();
    }
    
    public String welcomeMessage() {
        
        String[] params = new String[1];
        model.setUser("lieber Benutzer");
        params[0] = model.getUser();
        System.out.println("model.getUser()=" + model.getUser());
        String welcomeMessage = Helper.getMessageString("welcomeUserMessage", params);
        
        return welcomeMessage;
    }
    
    public void doSomething() {
        //----------------
        //schreibe ins modell
        viewToModel();
        //----------------
        //mach irgendetwas im model
        //model.doSomething();
        //model.updateModelStatus01();
        //----------------
        //lese aus modell
        modelToView();
    }
    
    private void modelToView() {
        page100Rvm.setSomeText(model.getSomeText());
        page100Rvm.setSomeText2(model.getSomeText2());
        page100Rvm.setModelStatus(model.getModelStatus01());
    }
    
    private void viewToModel() {
        model.setSomeText(page100Rvm.getSomeText());
        model.setSomeText2(page100Rvm.getSomeText2());
        model.updateModelStatus01();
    }
    
    @PostConstruct
    public void init() {
        
        System.out.println("init controller");
        
        modelToView();
        
    }
    
}
