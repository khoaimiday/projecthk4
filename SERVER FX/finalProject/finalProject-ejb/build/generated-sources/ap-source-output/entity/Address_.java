package entity;

import entity.Restaurants;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> note;
    public static volatile SingularAttribute<Address, String> cities;
    public static volatile CollectionAttribute<Address, Restaurants> restaurantsCollection;
    public static volatile SingularAttribute<Address, String> ward;
    public static volatile SingularAttribute<Address, String> type;
    public static volatile SingularAttribute<Address, Date> createdAt;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> district;
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile CollectionAttribute<Address, Users> usersCollection;
    public static volatile SingularAttribute<Address, String> lane;
    public static volatile SingularAttribute<Address, Date> updatedAt;

}