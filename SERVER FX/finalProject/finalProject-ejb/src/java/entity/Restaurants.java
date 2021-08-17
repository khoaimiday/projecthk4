/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "restaurants", catalog = "foodorder", schema = "")
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
    @NamedQuery(name = "Restaurants.findByRateCount", query = "SELECT r FROM Restaurants r WHERE r.rateCount = :rateCount"),
    @NamedQuery(name = "Restaurants.findByRateTotal", query = "SELECT r FROM Restaurants r WHERE r.rateTotal = :rateTotal"),
    @NamedQuery(name = "Restaurants.findByRate", query = "SELECT r FROM Restaurants r WHERE r.rate = :rate"),
    @NamedQuery(name = "Restaurants.findByWishId", query = "SELECT r FROM Restaurants r WHERE r.wishId = :wishId")})
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
    @Column(name = "rate_count")
    private Integer rateCount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate_total", precision = 12)
    private Float rateTotal;
    @Column(name = "rate", precision = 12)
    private Float rate;
    @Column(name = "wish_id")
    private BigInteger wishId;
    @JoinTable(name = "favourite", joinColumns = {
        @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "restaurantId")
    private Collection<Offers> offersCollection;
    @OneToMany(mappedBy = "restaurantId")
    private Collection<Ratings> ratingsCollection;
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ManyToOne
    private Address addressId;
    @OneToMany(mappedBy = "restaurantId")
    private Collection<Dishes> dishesCollection;

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

    public Integer getRateCount() {
        return rateCount;
    }

    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }

    public Float getRateTotal() {
        return rateTotal;
    }

    public void setRateTotal(Float rateTotal) {
        this.rateTotal = rateTotal;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public BigInteger getWishId() {
        return wishId;
    }

    public void setWishId(BigInteger wishId) {
        this.wishId = wishId;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Offers> getOffersCollection() {
        return offersCollection;
    }

    public void setOffersCollection(Collection<Offers> offersCollection) {
        this.offersCollection = offersCollection;
    }

    @XmlTransient
    public Collection<Ratings> getRatingsCollection() {
        return ratingsCollection;
    }

    public void setRatingsCollection(Collection<Ratings> ratingsCollection) {
        this.ratingsCollection = ratingsCollection;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @XmlTransient
    public Collection<Dishes> getDishesCollection() {
        return dishesCollection;
    }

    public void setDishesCollection(Collection<Dishes> dishesCollection) {
        this.dishesCollection = dishesCollection;
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
