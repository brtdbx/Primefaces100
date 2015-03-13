package demos.controller;

import demo.viewmodel.InputTextDemoRB;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Model;

@Named
@ViewScoped
public class DemoController implements Serializable {

    //the model is always session scoped  - one model per user
    @Inject
    Model model;
    
    @Inject
    InputTextDemoRB inputTextDemoRB;

    public InputTextDemoRB getInputTextDemoRB() {
        return inputTextDemoRB;
    }

    public void setInputTextDemoRB(InputTextDemoRB inputTextDemoRB) {
        this.inputTextDemoRB = inputTextDemoRB;
    }

    
    public void doSomething() {
//        //----------------
//        //schreibe ins modell
        viewToModel();
//
//        //----------------
//        //mach irgendetwas im model
//        tryLogin();
//
//        //----------------
//        //lese aus modell
//        modelToView();
    }

    private void modelToView() {
        inputTextDemoRB.setInputText01(model.getTextInput());
    }

    private void viewToModel() {
        System.out.println("setting:" + inputTextDemoRB.getInputText01());
        model.setTextInput(inputTextDemoRB.getInputText01());
    }


    @PostConstruct
    public void init() {
        modelToView();
        //inputTextDemoRB.setInputText01("init inputTextDemoRB from DemoController");
        System.out.println("init DemoController");
    }

}
