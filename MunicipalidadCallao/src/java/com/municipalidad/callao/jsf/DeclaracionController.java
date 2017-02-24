package com.municipalidad.callao.jsf;

import com.municipalidad.callao.entity.Declaracion;
import com.municipalidad.callao.jsf.util.JsfUtil;
import com.municipalidad.callao.jsf.util.JsfUtil.PersistAction;
import com.municipalidad.callao.jpacontroller.DeclaracionFacade;

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

@Named("declaracionController")
@SessionScoped
public class DeclaracionController implements Serializable {

    @EJB
    private com.municipalidad.callao.jpacontroller.DeclaracionFacade ejbFacade;
    private List<Declaracion> items = null;
    private Declaracion selected;

    public DeclaracionController() {
    }

    public Declaracion getSelected() {
        return selected;
    }

    public void setSelected(Declaracion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DeclaracionFacade getFacade() {
        return ejbFacade;
    }

    public Declaracion prepareCreate() {
        selected = new Declaracion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("DeclaracionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("DeclaracionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("DeclaracionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Declaracion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Declaracion getDeclaracion(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Declaracion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Declaracion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Declaracion.class)
    public static class DeclaracionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DeclaracionController controller = (DeclaracionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "declaracionController");
            return controller.getDeclaracion(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Declaracion) {
                Declaracion o = (Declaracion) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Declaracion.class.getName()});
                return null;
            }
        }

    }

}
