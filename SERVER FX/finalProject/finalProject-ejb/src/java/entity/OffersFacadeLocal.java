/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HUYNH HUY
 */
@Local
public interface OffersFacadeLocal {

    void create(Offers offers);

    void edit(Offers offers);

    void remove(Offers offers);

    Offers find(Object id);

    List<Offers> findAll();

    List<Offers> findRange(int[] range);

    int count();
    
}
