package entity;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(RefreshToken.class)
public class RefreshToken_ { 

    public static volatile SingularAttribute<RefreshToken, Date> expiryDate;
    public static volatile SingularAttribute<RefreshToken, Date> createdAt;
    public static volatile SingularAttribute<RefreshToken, Long> id;
    public static volatile SingularAttribute<RefreshToken, BigInteger> userId;
    public static volatile SingularAttribute<RefreshToken, Date> updatedAt;
    public static volatile SingularAttribute<RefreshToken, String> token;

}