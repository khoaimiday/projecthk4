package entity;

import entity.Address;
import entity.Dishes;
import entity.Offers;
import entity.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Restaurants.class)
public class Restaurants_ { 

    public static volatile CollectionAttribute<Restaurants, Address> addressCollection;
    public static volatile SingularAttribute<Restaurants, String> fullName;
    public static volatile CollectionAttribute<Restaurants, Dishes> dishesCollection;
    public static volatile CollectionAttribute<Restaurants, Orders> ordersCollection;
    public static volatile SingularAttribute<Restaurants, Boolean> isActive;
    public static volatile CollectionAttribute<Restaurants, Offers> offersCollection;
    public static volatile SingularAttribute<Restaurants, String> imgUrl;
    public static volatile SingularAttribute<Restaurants, Date> createdAt;
    public static volatile SingularAttribute<Restaurants, String> phoneNumber;
    public static volatile SingularAttribute<Restaurants, Float> rate;
    public static volatile SingularAttribute<Restaurants, Long> id;
    public static volatile SingularAttribute<Restaurants, String> email;
    public static volatile SingularAttribute<Restaurants, Date> updatedAt;

}