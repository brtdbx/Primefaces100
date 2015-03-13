package guis.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Helper {

    public static String _getRequestHashCode() {
        return String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequest().hashCode());
    }

    public static String _getSessionID() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionId(false);
    }

    public static void addErrorMsg(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
    }

    public static void addErrorMessage(String clientID, String key) {
        String message = getPropertyValue(key);
        String messageDetails = getPropertyValue(key + ".datails");
        FacesContext.getCurrentInstance().addMessage(clientID,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, getPropertyValue("messageTypeError") + message, messageDetails));
    }

    public static String getMessageString(String key, Object params[]) {

        String text = getPropertyValue(key);

        if (params != null) {
            //assuming the locale is not changed just now...
            //but see: http://stackoverflow.com/questions/4830588/jsf-locale-is-set-per-request-not-for-session
            Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            MessageFormat mf = new MessageFormat(text, locale);
            text = mf.format(params, new StringBuffer(), null).toString();
        }

        return text;
    }

    private static String getPropertyValue(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        //ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
        String msg = bundle.getString(key);
        return msg;
    }
}
