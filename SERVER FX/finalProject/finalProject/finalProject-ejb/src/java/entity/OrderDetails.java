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
@Table(name = "order_details", catalog = "finalproject", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findById", query = "SELECT o FROM OrderDetails o WHERE o.id = :id"),
    @NamedQuery(name = "OrderDetails.findByCreatedAt", query = "SELECT o FROM OrderDetails o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "OrderDetails.findByUpdatedAt", query = "SELECT o FROM OrderDetails o WHERE o.updatedAt = :updatedAt"),
    @NamedQuery(name = "OrderDetails.findByAmount", query = "SELECT o FROM OrderDetails o WHERE o.amount = :amount"),
    @NamedQuery(name = "OrderDetails.findByDescription", query = "SELECT o FROM OrderDetails o WHERE o.description = :description"),
    @NamedQuery(name = "OrderDetails.findByOriginalPrice", query = "SELECT o FROM OrderDetails o WHERE o.originalPrice = :originalPrice"),
    @NamedQuery(name = "OrderDetails.findBySellingPrice", query = "SELECT o FROM OrderDetails o WHERE o.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "OrderDetails.findByUnitName", query = "SELECT o FROM OrderDetails o WHERE o.unitName = :unitName")})
public class OrderDetails implements Serializable {
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
    @Column(name = "description", length = 255)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "original_price", precision = 19, scale = 2)
    private BigDecimal originalPrice;
    @Column(name = "selling_price", precision = 19, scale = 2)
    private BigDecimal sellingPrice;
    @Size(max = 255)
    @Column(name = "unit_name", length = 255)
    private String unitName;
    @JoinColumn(name = "dishes_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Dishes dishesId;
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Orders orderId;

    public OrderDetails() {
    }

    public OrderDetails(Long id) {
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Dishes getDishesId() {
        return dishesId;
    }

    public void setDishesId(Dishes dishesId) {
        this.dishesId = dishesId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetails[ id=" + id + " ]";
    }
    
}
