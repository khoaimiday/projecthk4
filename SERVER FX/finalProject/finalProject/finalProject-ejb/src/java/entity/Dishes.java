/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "dishes", catalog = "finalproject", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dishes.findAll", query = "SELECT d FROM Dishes d"),
    @NamedQuery(name = "Dishes.findById", query = "SELECT d FROM Dishes d WHERE d.id = :id"),
    @NamedQuery(name = "Dishes.findByCreatedAt", query = "SELECT d FROM Dishes d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "Dishes.findByUpdatedAt", query = "SELECT d FROM Dishes d WHERE d.updatedAt = :updatedAt"),
    @NamedQuery(name = "Dishes.findByDelivered", query = "SELECT d FROM Dishes d WHERE d.delivered = :delivered"),
    @NamedQuery(name = "Dishes.findByFullName", query = "SELECT d FROM Dishes d WHERE d.fullName = :fullName"),
    @NamedQuery(name = "Dishes.findByImgUrl", query = "SELECT d FROM Dishes d WHERE d.imgUrl = :imgUrl"),
    @NamedQuery(name = "Dishes.findByIsActive", query = "SELECT d FROM Dishes d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "Dishes.findByCountLike", query = "SELECT d FROM Dishes d WHERE d.countLike = :countLike"),
    @NamedQuery(name = "Dishes.findByNote", query = "SELECT d FROM Dishes d WHERE d.note = :note"),
    @NamedQuery(name = "Dishes.findByPrice", query = "SELECT d FROM Dishes d WHERE d.price = :price"),
    @NamedQuery(name = "Dishes.findByQuantity", query = "SELECT d FROM Dishes d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "Dishes.findByRate", query = "SELECT d FROM Dishes d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dishes.findByUnit", query = "SELECT d FROM Dishes d WHERE d.unit = :unit")})
public class Dishes implements Serializable {
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
    @Column(name = "delivered")
    private Integer delivered;
    @Size(max = 255)
    @Column(name = "full_name", length = 255)
    private String fullName;
    @Size(max = 255)
    @Column(name = "img_url", length = 255)
    private String imgUrl;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "count_like")
    private Integer countLike;
    @Size(max = 255)
    @Column(name = "note", length = 255)
    private String note;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 19, scale = 2)
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "rate", precision = 12)
    private Float rate;
    @Size(max = 255)
    @Column(name = "unit", length = 255)
    private String unit;
    @OneToMany(mappedBy = "dishesId")
    private Collection<Offers> offersCollection;
    @JoinColumn(name = "dish_category_id", referencedColumnName = "id")
    @ManyToOne
    private DishCategory dishCategoryId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Restaurants restaurantId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dishesId")
    private Collection<OrderDetails> orderDetailsCollection;

    public Dishes() {
    }

    public Dishes(Long id) {
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

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
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

    public Integer getCountLike() {
        return countLike;
    }

    public void setCountLike(Integer countLike) {
        this.countLike = countLike;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlTransient
    public Collection<Offers> getOffersCollection() {
        return offersCollection;
    }

    public void setOffersCollection(Collection<Offers> offersCollection) {
        this.offersCollection = offersCollection;
    }

    public DishCategory getDishCategoryId() {
        return dishCategoryId;
    }

    public void setDishCategoryId(DishCategory dishCategoryId) {
        this.dishCategoryId = dishCategoryId;
    }

    public Restaurants getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurants restaurantId) {
        this.restaurantId = restaurantId;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
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
        if (!(object instanceof Dishes)) {
            return false;
        }
        Dishes other = (Dishes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dishes[ id=" + id + " ]";
    }
    
}
