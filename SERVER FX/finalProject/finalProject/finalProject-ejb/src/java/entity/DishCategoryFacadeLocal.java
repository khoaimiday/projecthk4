/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;


@Local
public interface DishCategoryFacadeLocal {

    void create(DishCategory dishCategory);

    void edit(DishCategory dishCategory);

    void remove(DishCategory dishCategory);

    DishCategory find(Object id);

    List<DishCategory> findAll();

    List<DishCategory> findRange(int[] range);

    int count();
    
}
