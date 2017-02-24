package com.municipalidad.callao.jsf;

import com.municipalidad.callao.entity.Multas;
import com.municipalidad.callao.jsf.util.JsfUtil;
import com.municipalidad.callao.jsf.util.JsfUtil.PersistAction;
import com.municipalidad.callao.jpacontroller.MultasFacade;

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

@Named("multasController")
@SessionScoped
public class MultasController implements Serializable {

    @EJB
    private com.municipalidad.callao.jpacontroller.MultasFacade ejbFacade;
    private List<Multas> items = null;
    private Multas selected;

    public MultasController() {
    }

    public Multas getSelected() {
        return selected;
    }

    public void setSelected(Multas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MultasFacade getFacade() {
        return ejbFacade;
    }

    public Multas prepareCreate() {
        selected = new Multas();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("MultasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("MultasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("MultasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Multas> getItems() {
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

    public Multas getMultas(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Multas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Multas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Multas.class)
    public static class MultasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MultasController controller = (MultasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "multasController");
            return controller.getMultas(getKey(value));
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
            if (object instanceof Multas) {
                Multas o = (Multas) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Multas.class.getName()});
                return null;
            }
        }

    }

}
