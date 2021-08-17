/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUYNH HUY
 */
@Entity
@Table(name = "refresh_token", catalog = "finalproject", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"token"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefreshToken.findAll", query = "SELECT r FROM RefreshToken r"),
    @NamedQuery(name = "RefreshToken.findById", query = "SELECT r FROM RefreshToken r WHERE r.id = :id"),
    @NamedQuery(name = "RefreshToken.findByCreatedAt", query = "SELECT r FROM RefreshToken r WHERE r.createdAt = :createdAt"),
    @NamedQuery(name = "RefreshToken.findByUpdatedAt", query = "SELECT r FROM RefreshToken r WHERE r.updatedAt = :updatedAt"),
    @NamedQuery(name = "RefreshToken.findByExpiryDate", query = "SELECT r FROM RefreshToken r WHERE r.expiryDate = :expiryDate"),
    @NamedQuery(name = "RefreshToken.findByToken", query = "SELECT r FROM RefreshToken r WHERE r.token = :token"),
    @NamedQuery(name = "RefreshToken.findByUserId", query = "SELECT r FROM RefreshToken r WHERE r.userId = :userId")})
public class RefreshToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiry_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "token", nullable = false, length = 255)
    private String token;
    @Column(name = "user_id")
    private BigInteger userId;

    public RefreshToken() {
    }

    public RefreshToken(Long id) {
        this.id = id;
    }

    public RefreshToken(Long id, Date expiryDate, String token) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.token = token;
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
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
        if (!(object instanceof RefreshToken)) {
            return false;
        }
        RefreshToken other = (RefreshToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RefreshToken[ id=" + id + " ]";
    }
    
}
