package demos.viewmodel.login;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ModelSB implements Serializable {

    private String user;
    private String password;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUserPwd() {
        boolean isOk = false;
        if (user != null && password != null) {
            if (!user.isEmpty() && !password.isEmpty()) {
                if (user.equals(password)) {
                    isOk = true;
                }
            }
        }
        
        return isOk;
    }

    //PostConstruct specifies the lifecycle callback method that 
    //the CDI framework calls after dependency injection 
    //but before the class is put into service.
    @PostConstruct
    public void init() {
        System.out.println("init Model");
    }


}
