/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYNH HUY
 */
@Entity
@Table(name = "restaurants", catalog = "finalproject", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurants.findAll", query = "SELECT r FROM Restaurants r"),
    @NamedQuery(name = "Restaurants.findById", query = "SELECT r FROM Restaurants r WHERE r.id = :id"),
    @NamedQuery(name = "Restaurants.findByCreatedAt", query = "SELECT r FROM Restaurants r WHERE r.createdAt = :createdAt"),
    @NamedQuery(name = "Restaurants.findByUpdatedAt", query = "SELECT r FROM Restaurants r WHERE r.updatedAt = :updatedAt"),
    @NamedQuery(name = "Restaurants.findByEmail", query = "SELECT r FROM Restaurants r WHERE r.email = :email"),
    @NamedQuery(name = "Restaurants.findByFullName", query = "SELECT r FROM Restaurants r WHERE r.fullName = :fullName"),
    @NamedQuery(name = "Restaurants.findByImgUrl", query = "SELECT r FROM Restaurants r WHERE r.imgUrl = :imgUrl"),
    @NamedQuery(name = "Restaurants.findByIsActive", query = "SELECT r FROM Restaurants r WHERE r.isActive = :isActive"),
    @NamedQuery(name = "Restaurants.findByPhoneNumber", query = "SELECT r FROM Restaurants r WHERE r.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Restaurants.findByRate", query = "SELECT r FROM Restaurants r WHERE r.rate = :rate")})
public class Restaurants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;
    @Size(max = 255)
    @Column(name = "full_name", length = 255)
    private String fullName;
    @Size(max = 255)
    @Column(name = "img_url", length = 255)
    private String imgUrl;
    @Column(name = "is_active")
    private Boolean isActive;
    @Size(max = 255)
    @Column(name = "phone_number", length = 255)
    private String phoneNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate", precision = 12)
    private Float rate;
    @ManyToMany(mappedBy = "restaurantsCollection")
    private Collection<Address> addressCollection;
    @OneToMany(mappedBy = "restaurantId")
    private Collection<Offers> offersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<Dishes> dishesCollection;
    @OneToMany(mappedBy = "restaurantId")
    private Collection<Orders> ordersCollection;

    public Restaurants() {
    }

    public Restaurants(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @XmlTransient
    public Collection<Offers> getOffersCollection() {
        return offersCollection;
    }

    public void setOffersCollection(Collection<Offers> offersCollection) {
        this.offersCollection = offersCollection;
    }

    @XmlTransient
    public Collection<Dishes> getDishesCollection() {
        return dishesCollection;
    }

    public void setDishesCollection(Collection<Dishes> dishesCollection) {
        this.dishesCollection = dishesCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurants)) {
            return false;
        }
        Restaurants other = (Restaurants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Restaurants[ id=" + id + " ]";
    }
    
}
