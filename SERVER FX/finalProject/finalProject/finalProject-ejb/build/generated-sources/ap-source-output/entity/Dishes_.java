package entity;

import entity.DishCategory;
import entity.Offers;
import entity.OrderDetails;
import entity.Restaurants;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Dishes.class)
public class Dishes_ { 

    public static volatile SingularAttribute<Dishes, String> note;
    public static volatile SingularAttribute<Dishes, Integer> quantity;
    public static volatile CollectionAttribute<Dishes, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Dishes, Integer> countLike;
    public static volatile SingularAttribute<Dishes, String> fullName;
    public static volatile SingularAttribute<Dishes, Integer> delivered;
    public static volatile SingularAttribute<Dishes, Boolean> isActive;
    public static volatile SingularAttribute<Dishes, Restaurants> restaurantId;
    public static volatile CollectionAttribute<Dishes, Offers> offersCollection;
    public static volatile SingularAttribute<Dishes, String> imgUrl;
    public static volatile SingularAttribute<Dishes, Date> createdAt;
    public static volatile SingularAttribute<Dishes, String> unit;
    public static volatile SingularAttribute<Dishes, Float> rate;
    public static volatile SingularAttribute<Dishes, BigDecimal> price;
    public static volatile SingularAttribute<Dishes, Long> id;
    public static volatile SingularAttribute<Dishes, DishCategory> dishCategoryId;
    public static volatile SingularAttribute<Dishes, Date> updatedAt;

}