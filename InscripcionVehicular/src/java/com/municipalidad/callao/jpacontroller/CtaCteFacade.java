/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.municipalidad.callao.jpacontroller;

import com.municipalidad.callao.entity.CtaCte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RENSO
 */
@Stateless
public class CtaCteFacade extends AbstractFacade<CtaCte> {

    @PersistenceContext(unitName = "InscripcionVehicularPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CtaCteFacade() {
        super(CtaCte.class);
    }
    
}
