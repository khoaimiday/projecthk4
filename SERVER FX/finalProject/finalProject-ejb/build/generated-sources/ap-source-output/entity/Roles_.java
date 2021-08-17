package entity;

import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Date> createdAt;
    public static volatile SingularAttribute<Roles, String> name;
    public static volatile SingularAttribute<Roles, Integer> id;
    public static volatile CollectionAttribute<Roles, Users> usersCollection;
    public static volatile SingularAttribute<Roles, Date> updatedAt;

}