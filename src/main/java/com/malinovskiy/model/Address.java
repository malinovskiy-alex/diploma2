package com.malinovskiy.model;

import javax.persistence.*;

/**
 * Created by alexander on 27.12.14.
 */
@Entity
@Table(name = "address")
@NamedQuery(name = Address.FIND_All, query = "select a from Address a")
public class Address {
    public static final String FIND_All = "Address.findAll";
    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue
    private long id;
    @Column(name = "ADDRESS_NAME")
    private String name;
    @Column(name = "LAT")
    private double lat;
    @Column(name = "LNG")
    private double lng;
    @Column(name="CLUSTER_ID")
    private Long clusterId;
    @Column(name = "TIME")
    private String time = "";
    @Column(name = "DISTANCE")
    private String distance = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (Double.compare(address.lat, lat) != 0) return false;
        if (Double.compare(address.lng, lng) != 0) return false;
        if (name != null ? !name.equals(address.name) : address.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
