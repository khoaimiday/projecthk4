package entity;

import entity.OrderDetails;
import entity.Restaurants;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> amount;
    public static volatile SingularAttribute<Orders, String> deliverTime;
    public static volatile SingularAttribute<Orders, String> deliverPhone;
    public static volatile SingularAttribute<Orders, BigDecimal> totalPrice;
    public static volatile CollectionAttribute<Orders, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Orders, String> deliverAddress;
    public static volatile SingularAttribute<Orders, Restaurants> restaurantId;
    public static volatile SingularAttribute<Orders, Long> userId;
    public static volatile SingularAttribute<Orders, Date> createdAt;
    public static volatile SingularAttribute<Orders, String> offerCode;
    public static volatile SingularAttribute<Orders, String> deliverNote;
    public static volatile SingularAttribute<Orders, Long> id;
    public static volatile SingularAttribute<Orders, Date> updatedAt;
    public static volatile SingularAttribute<Orders, Boolean> status;

}