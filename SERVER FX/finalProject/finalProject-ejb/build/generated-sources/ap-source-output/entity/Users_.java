package entity;

import entity.Address;
import entity.Roles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-07-28T15:58:59")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Address> addressCollection;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, String> fullName;
    public static volatile SingularAttribute<Users, String> verifycationCode;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Boolean> isActive;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile SingularAttribute<Users, Date> createdAt;
    public static volatile SingularAttribute<Users, String> resetPasswordToken;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> phoneNumber;
    public static volatile SingularAttribute<Users, Long> id;
    public static volatile CollectionAttribute<Users, Roles> rolesCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, Date> updatedAt;

}