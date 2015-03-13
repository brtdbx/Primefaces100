package demos.viewmodel.login;

import guis.utils.Helper;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginControllerVB implements Serializable {

    @Inject
    LoginVB loginVB;

    //the model is always session scoped  - one model per user
    @Inject
    ModelSB modelSB;

    public LoginVB getLoginVB() {
        return loginVB;
    }

    public void setLoginVB(LoginVB loginVB) {
        this.loginVB = loginVB;
    }

    public void doSomething() {
        //----------------
        //schreibe ins modell
        viewToModel();

        //----------------
        //mach irgendetwas im model
        tryLogin();

        //----------------
        //lese aus modell
        modelToView();
    }

    private void modelToView() {
        loginVB.setPwd(modelSB.getPassword());
        loginVB.setUser(modelSB.getUser());
    }

    private void viewToModel() {
        modelSB.setUser(loginVB.getUser());
        modelSB.setPassword(loginVB.getPwd());
    }

    private void tryLogin() {
        boolean loginDataOk = modelSB.checkUserPwd();
        if (!loginDataOk) {
            Helper.addErrorMessage("loginCmdID", "errorUserPassword");
        }
    }

    public String nextPage() {
        boolean loginDataOk = modelSB.checkUserPwd();
        String navigationTarget = "login";
        if (loginDataOk) {
            navigationTarget = "/page100";
        }
        return navigationTarget;
    }

    public String sorryMessage() {
        String sorryMessage = null;

        if (modelSB.getUser() != null) {
            boolean loginDataOk = modelSB.checkUserPwd();
            if (!loginDataOk) {
                String[] params = new String[1];
                params[0] = modelSB.getUser();
                sorryMessage = Helper.getMessageString("notLoggedInMessage", params);
            }
        }

        return sorryMessage;
    }

    @PostConstruct
    public void init() {
        System.out.println("init LoginControllerVB");
        modelToView();
    }

}
