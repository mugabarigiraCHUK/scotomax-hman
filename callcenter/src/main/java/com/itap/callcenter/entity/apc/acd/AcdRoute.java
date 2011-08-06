/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.acd;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.itap.callcenter.entity.DomainObject;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "acd_route")
@XmlRootElement
public class AcdRoute implements Serializable, DomainObject {
    
	private static final long serialVersionUID = 1L;
    
	@Id
    @Column(name = "route_id", length = 11, nullable = false)
    @NotNull
    private Integer routeId;
	
    @Column(name = "route_name", length = 50, nullable = false)
    @NotNull
    private String routeName;
    
    @Column(name = "route_description", length = 100)
    private String routeDescription;
    
    @Column(name = "route_condition", length = 11, nullable = false)
    @NotNull
    private int routeCondition;
    
    @Column(name = "route_caller", length = 50)
    private String routeCaller;
    
    @Column(name = "route_called", length = 50)
    private String routeCalled;
    
    @Column(name = "route_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date routeCreateDate;
    
    @Column(name = "route_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date routeUpdateDate;

    public AcdRoute() {
    }

    public AcdRoute(Integer routeId) {
        this.routeId = routeId;
    }

    public AcdRoute(Integer routeId, String routeName, int routeCondition, Date routeCreateDate, Date routeUpdateDate) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.routeCondition = routeCondition;
        this.routeCreateDate = routeCreateDate;
        this.routeUpdateDate = routeUpdateDate;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public int getRouteCondition() {
        return routeCondition;
    }

    public void setRouteCondition(int routeCondition) {
        this.routeCondition = routeCondition;
    }

    public String getRouteCaller() {
        return routeCaller;
    }

    public void setRouteCaller(String routeCaller) {
        this.routeCaller = routeCaller;
    }

    public String getRouteCalled() {
        return routeCalled;
    }

    public void setRouteCalled(String routeCalled) {
        this.routeCalled = routeCalled;
    }

    public Date getRouteCreateDate() {
        return routeCreateDate;
    }

    public void setRouteCreateDate(Date routeCreateDate) {
        this.routeCreateDate = routeCreateDate;
    }

    public Date getRouteUpdateDate() {
        return routeUpdateDate;
    }

    public void setRouteUpdateDate(Date routeUpdateDate) {
        this.routeUpdateDate = routeUpdateDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        AcdRoute other = (AcdRoute) o;
        return new EqualsBuilder()
                 .append(routeId, other.routeId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.routeId)
         .toHashCode();
    }
    
}
