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
public interface RestaurantsFacadeLocal {

    void create(Restaurants restaurants);

    void edit(Restaurants restaurants);

    void remove(Restaurants restaurants);

    Restaurants find(Object id);

    List<Restaurants> findAll();

    List<Restaurants> findRange(int[] range);

    int count();
    
}
