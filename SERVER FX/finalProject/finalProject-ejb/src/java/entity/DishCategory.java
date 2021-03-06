/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYNH HUY
 */
@Entity
@Table(name = "dish_category", catalog = "foodorder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DishCategory.findAll", query = "SELECT d FROM DishCategory d"),
    @NamedQuery(name = "DishCategory.findById", query = "SELECT d FROM DishCategory d WHERE d.id = :id"),
    @NamedQuery(name = "DishCategory.findByName", query = "SELECT d FROM DishCategory d WHERE d.name = :name")})
public class DishCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "name", length = 255)
    private String name;
    @OneToMany(mappedBy = "dishCategoryId")
    private Collection<Dishes> dishesCollection;

    public DishCategory() {
    }

    public DishCategory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof DishCategory)) {
            return false;
        }
        DishCategory other = (DishCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DishCategory[ id=" + id + " ]";
    }
    
}
