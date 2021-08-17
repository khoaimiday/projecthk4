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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYNH HUY
 */
@Entity
@Table(name = "orders", catalog = "finalproject", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByCreatedAt", query = "SELECT o FROM Orders o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Orders.findByUpdatedAt", query = "SELECT o FROM Orders o WHERE o.updatedAt = :updatedAt"),
    @NamedQuery(name = "Orders.findByAmount", query = "SELECT o FROM Orders o WHERE o.amount = :amount"),
    @NamedQuery(name = "Orders.findByDeliverAddress", query = "SELECT o FROM Orders o WHERE o.deliverAddress = :deliverAddress"),
    @NamedQuery(name = "Orders.findByDeliverNote", query = "SELECT o FROM Orders o WHERE o.deliverNote = :deliverNote"),
    @NamedQuery(name = "Orders.findByDeliverPhone", query = "SELECT o FROM Orders o WHERE o.deliverPhone = :deliverPhone"),
    @NamedQuery(name = "Orders.findByDeliverTime", query = "SELECT o FROM Orders o WHERE o.deliverTime = :deliverTime"),
    @NamedQuery(name = "Orders.findByOfferCode", query = "SELECT o FROM Orders o WHERE o.offerCode = :offerCode"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status"),
    @NamedQuery(name = "Orders.findByTotalPrice", query = "SELECT o FROM Orders o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "Orders.findByUserId", query = "SELECT o FROM Orders o WHERE o.userId = :userId")})
public class Orders implements Serializable {
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
    @Column(name = "amount")
    private Integer amount;
    @Size(max = 255)
    @Column(name = "deliver_address", length = 255)
    private String deliverAddress;
    @Size(max = 255)
    @Column(name = "deliver_note", length = 255)
    private String deliverNote;
    @Size(max = 255)
    @Column(name = "deliver_phone", length = 255)
    private String deliverPhone;
    @Size(max = 255)
    @Column(name = "deliver_time", length = 255)
    private String deliverTime;
    @Size(max = 255)
    @Column(name = "offer_code", length = 255)
    private String offerCode;
    @Column(name = "status")
    private Boolean status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price", precision = 19, scale = 2)
    private BigDecimal totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id", nullable = false)
    private long userId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne
    private Restaurants restaurantId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderDetails> orderDetailsCollection;

    public Orders() {
    }

    public Orders(Long id) {
        this.id = id;
    }

    public Orders(Long id, long userId) {
        this.id = id;
        this.userId = userId;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getDeliverNote() {
        return deliverNote;
    }

    public void setDeliverNote(String deliverNote) {
        this.deliverNote = deliverNote;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ id=" + id + " ]";
    }
    
}
