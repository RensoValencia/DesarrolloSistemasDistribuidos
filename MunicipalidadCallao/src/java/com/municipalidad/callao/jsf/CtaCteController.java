package com.municipalidad.callao.jsf;

import com.municipalidad.callao.entity.CtaCte;
import com.municipalidad.callao.jsf.util.JsfUtil;
import com.municipalidad.callao.jsf.util.JsfUtil.PersistAction;
import com.municipalidad.callao.jpacontroller.CtaCteFacade;

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

@Named("ctaCteController")
@SessionScoped
public class CtaCteController implements Serializable {

    @EJB
    private com.municipalidad.callao.jpacontroller.CtaCteFacade ejbFacade;
    private List<CtaCte> items = null;
    private CtaCte selected;

    public CtaCteController() {
    }

    public CtaCte getSelected() {
        return selected;
    }

    public void setSelected(CtaCte selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CtaCteFacade getFacade() {
        return ejbFacade;
    }

    public CtaCte prepareCreate() {
        selected = new CtaCte();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("CtaCteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("CtaCteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("com/municipalidad/callao/properties/messages").getString("CtaCteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CtaCte> getItems() {
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

    public CtaCte getCtaCte(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CtaCte> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CtaCte> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CtaCte.class)
    public static class CtaCteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CtaCteController controller = (CtaCteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ctaCteController");
            return controller.getCtaCte(getKey(value));
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
            if (object instanceof CtaCte) {
                CtaCte o = (CtaCte) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CtaCte.class.getName()});
                return null;
            }
        }

    }

}
