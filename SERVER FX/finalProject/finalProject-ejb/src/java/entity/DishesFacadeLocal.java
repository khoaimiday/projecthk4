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
public interface DishesFacadeLocal {

    void create(Dishes dishes);

    void edit(Dishes dishes);

    void remove(Dishes dishes);

    Dishes find(Object id);

    List<Dishes> findAll();

    List<Dishes> findRange(int[] range);

    int count();
    
}
