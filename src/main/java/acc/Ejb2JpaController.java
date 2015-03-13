package acc;

import entities.Applicationuser;
import acc.util.JsfUtil;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ejb2JpaController")
@SessionScoped
public class Ejb2JpaController implements Serializable {

    @EJB
    private acc.ApplicationuserFacade ejbFacade;
    private List<Applicationuser> items = null;
    private Applicationuser selected;

    public Ejb2JpaController() {
    }

    public Applicationuser getSelected() {
        return selected;
    }

    public void setSelected(Applicationuser selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public Applicationuser prepareCreate() {
        selected = new Applicationuser();
        initializeEmbeddableKey();
        
        return selected;
    }

    private ApplicationuserFacade getFacade() {
        return ejbFacade;
    }

    public void create(Applicationuser selected) {
        String successMessage = ResourceBundle.getBundle("/Bundle").getString("ApplicationuserCreated");
        if (selected != null) {
            setEmbeddableKeys();
            try {
                getFacade().edit(selected);
                JsfUtil.showSuccessMessage(successMessage);
            } catch (EJBException ex) {
                JsfUtil.showErrorMessageFromExceptionCause(ex, "PersistenceErrorOccured");
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.showErrorMessage(ex, "PersistenceErrorOccured");
            }
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update(Applicationuser selected) {
        String successMessage = ResourceBundle.getBundle("/Bundle").getString("ApplicationuserUpdated");
        if (selected != null) {
            setEmbeddableKeys();
            try {
                getFacade().edit(selected);
                JsfUtil.showSuccessMessage(successMessage);
            } catch (EJBException ex) {
                JsfUtil.showErrorMessageFromExceptionCause(ex, "PersistenceErrorOccured");
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.showErrorMessage(ex, "PersistenceErrorOccured");
            }
        }

        //folgender Code mach Sinn, wenn das Update scheitert:
        //selected = null; // Remove selection
        //items = null;    // Invalidate list of items to trigger re-query.
    }

    public void destroy(Applicationuser selected) {
        String successMessage = ResourceBundle.getBundle("/Bundle").getString("ApplicationuserDeleted");
        if (selected != null) {
            setEmbeddableKeys();
            try {
                getFacade().remove(selected);
                JsfUtil.showSuccessMessage(successMessage);
            } catch (EJBException ex) {
                JsfUtil.showErrorMessageFromExceptionCause(ex, "PersistenceErrorOccured");
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.showErrorMessage(ex, "PersistenceErrorOccured");
            }
        }

        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Applicationuser> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public Applicationuser getApplicationuser(Integer id) {
        return getFacade().find(id);
    }

    public List<Applicationuser> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Applicationuser> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Applicationuser.class)
    public static class ApplicationuserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Ejb2JpaController controller = (Ejb2JpaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "applicationuserController");
            return controller.getApplicationuser(getKey(value));
        }

        Integer getKey(String value) {
            Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Applicationuser) {
                Applicationuser o = (Applicationuser) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Applicationuser.class.getName()});
                return null;
            }
        }

    }

}
