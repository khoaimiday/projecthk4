package entity;

import entity.Dishes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(DishCategory.class)
public class DishCategory_ { 

    public static volatile SingularAttribute<DishCategory, String> name;
    public static volatile CollectionAttribute<DishCategory, Dishes> dishesCollection;
    public static volatile SingularAttribute<DishCategory, Long> id;

}