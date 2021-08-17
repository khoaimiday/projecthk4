/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HUYNH HUY
 */
@Stateless
public class DishesFacade extends AbstractFacade<Dishes> implements DishesFacadeLocal {
    @PersistenceContext(unitName = "finalProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DishesFacade() {
        super(Dishes.class);
    }
    
}
