/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.municipalidad.callao.jpacontroller;

import com.municipalidad.callao.entity.Declaracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RENSO
 */
@Stateless
public class DeclaracionFacade extends AbstractFacade<Declaracion> {

    @PersistenceContext(unitName = "MunicipalidadCallaoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeclaracionFacade() {
        super(Declaracion.class);
    }
    
}
