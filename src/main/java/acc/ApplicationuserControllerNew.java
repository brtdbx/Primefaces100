package acc;

import entities.Applicationuser;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named("applicationuserControllerNew")
@SessionScoped
public class ApplicationuserControllerNew implements Serializable {

    @Inject
    private Ejb2JpaController ejb2JpaController;

    private List<Applicationuser> items = null;
    private Applicationuser selected;

    public ApplicationuserControllerNew() {
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

    public void createApplicationuser() {
        ejb2JpaController.create(selected);
    }

    public void updateApplicationuser() {
        ejb2JpaController.update(selected);
    }

    public void destroyApplicationuser() {
        ejb2JpaController.destroy(selected);
    }


    public List<Applicationuser> getItems() {
        items = ejb2JpaController.getItems();
        return items;
    }

    public Applicationuser getApplicationuser(Integer id) {
        Applicationuser au = ejb2JpaController.getApplicationuser(id);
        return au;
    }

    public List<Applicationuser> getItemsAvailableSelectMany() {
        List<Applicationuser> auList = ejb2JpaController.getItemsAvailableSelectMany();
        return auList;
    }

    public List<Applicationuser> getItemsAvailableSelectOne() {
        List<Applicationuser> auList = ejb2JpaController.getItemsAvailableSelectOne();
        return auList;
    }

    @FacesConverter(forClass = Applicationuser.class)
    public static class ApplicationuserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ApplicationuserControllerNew controller = (ApplicationuserControllerNew) facesContext.getApplication().getELResolver().
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
