package bizmodel;

public class BizModel {

    private String user;
    private String password;
    private String someText;
    private String someText2;
    private String textInput;

    public void init() {
        System.out.println("--- BizModel.init() ---");
        this.user = "user";
        this.textInput = "init - nothing";
        //this.password = "user";
        //updateModelStatus01();
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
        System.out.println("textInput was set to: " + textInput);
    }

    public String getSomeText2() {
        return someText2;
    }

    public void setSomeText2(String someText2) {
        this.someText2 = someText2;
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    private String modelStatus01;

    public String getModelStatus01() {
        return modelStatus01;
    }

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

}
