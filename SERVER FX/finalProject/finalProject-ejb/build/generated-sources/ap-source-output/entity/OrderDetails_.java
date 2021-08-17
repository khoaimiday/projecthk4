package entity;

import entity.Dishes;
import entity.Orders;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Date> createdAt;
    public static volatile SingularAttribute<OrderDetails, Integer> amount;
    public static volatile SingularAttribute<OrderDetails, BigDecimal> sellingPrice;
    public static volatile SingularAttribute<OrderDetails, BigDecimal> originalPrice;
    public static volatile SingularAttribute<OrderDetails, String> unitName;
    public static volatile SingularAttribute<OrderDetails, Orders> orderId;
    public static volatile SingularAttribute<OrderDetails, String> description;
    public static volatile SingularAttribute<OrderDetails, Dishes> dishesId;
    public static volatile SingularAttribute<OrderDetails, Long> id;
    public static volatile SingularAttribute<OrderDetails, Date> updatedAt;

}