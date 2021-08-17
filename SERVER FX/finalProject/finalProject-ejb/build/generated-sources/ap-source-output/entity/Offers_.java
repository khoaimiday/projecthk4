package entity;

import entity.Dishes;
import entity.Restaurants;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Offers.class)
public class Offers_ { 

    public static volatile SingularAttribute<Offers, String> imgUrl;
    public static volatile SingularAttribute<Offers, Date> createdAt;
    public static volatile SingularAttribute<Offers, String> code;
    public static volatile SingularAttribute<Offers, Integer> discountPercent;
    public static volatile SingularAttribute<Offers, BigDecimal> pricePromo;
    public static volatile SingularAttribute<Offers, Date> expiredDate;
    public static volatile SingularAttribute<Offers, Dishes> dishesId;
    public static volatile SingularAttribute<Offers, Date> activedDate;
    public static volatile SingularAttribute<Offers, Long> id;
    public static volatile SingularAttribute<Offers, Restaurants> restaurantId;
    public static volatile SingularAttribute<Offers, Date> updatedAt;

}