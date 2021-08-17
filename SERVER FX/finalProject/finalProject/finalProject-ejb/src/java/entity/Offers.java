/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUYNH HUY
 */
@Entity
@Table(name = "offers", catalog = "finalproject", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offers.findAll", query = "SELECT o FROM Offers o"),
    @NamedQuery(name = "Offers.findById", query = "SELECT o FROM Offers o WHERE o.id = :id"),
    @NamedQuery(name = "Offers.findByCreatedAt", query = "SELECT o FROM Offers o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Offers.findByUpdatedAt", query = "SELECT o FROM Offers o WHERE o.updatedAt = :updatedAt"),
    @NamedQuery(name = "Offers.findByActivedDate", query = "SELECT o FROM Offers o WHERE o.activedDate = :activedDate"),
    @NamedQuery(name = "Offers.findByCode", query = "SELECT o FROM Offers o WHERE o.code = :code"),
    @NamedQuery(name = "Offers.findByDiscountPercent", query = "SELECT o FROM Offers o WHERE o.discountPercent = :discountPercent"),
    @NamedQuery(name = "Offers.findByExpiredDate", query = "SELECT o FROM Offers o WHERE o.expiredDate = :expiredDate"),
    @NamedQuery(name = "Offers.findByImgUrl", query = "SELECT o FROM Offers o WHERE o.imgUrl = :imgUrl"),
    @NamedQuery(name = "Offers.findByPricePromo", query = "SELECT o FROM Offers o WHERE o.pricePromo = :pricePromo")})
public class Offers implements Serializable {
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
    @Column(name = "actived_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activedDate;
    @Size(max = 255)
    @Column(name = "code", length = 255)
    private String code;
    @Column(name = "discount_percent")
    private Integer discountPercent;
    @Column(name = "expired_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Size(max = 255)
    @Column(name = "img_url", length = 255)
    private String imgUrl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price_promo", precision = 19, scale = 2)
    private BigDecimal pricePromo;
    @JoinColumn(name = "dishes_id", referencedColumnName = "id")
    @ManyToOne
    private Dishes dishesId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne
    private Restaurants restaurantId;

    public Offers() {
    }

    public Offers(Long id) {
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

    public Date getActivedDate() {
        return activedDate;
    }

    public void setActivedDate(Date activedDate) {
        this.activedDate = activedDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getPricePromo() {
        return pricePromo;
    }

    public void setPricePromo(BigDecimal pricePromo) {
        this.pricePromo = pricePromo;
    }

    public Dishes getDishesId() {
        return dishesId;
    }

    public void setDishesId(Dishes dishesId) {
        this.dishesId = dishesId;
    }

    public Restaurants getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurants restaurantId) {
        this.restaurantId = restaurantId;
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
        if (!(object instanceof Offers)) {
            return false;
        }
        Offers other = (Offers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Offers[ id=" + id + " ]";
    }
    
}
