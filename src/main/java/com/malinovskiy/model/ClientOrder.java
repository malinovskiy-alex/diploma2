package com.malinovskiy.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_order")
@NamedQuery(name = ClientOrder.FIND_All, query = "select a from ClientOrder a")
public class ClientOrder implements Serializable {

    public static final String FIND_All = "ClientOrder.findAll";

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Column(name = "CLIENT_ADDRESS")
    private String clientAddress;
    @Column(name = "CLIENT_PHONE")
    private String clientPhone;
    @Column(name = "RECIPIENT_NAME")
    private String recipientName;
    @Column(name = "RECIPIENT_PHONE")
    private String recipientPhone;
    @Column(name = "RECIPIENT_ADDRESS")
    private String recipientAddress;
    @Column(name = "LAT")
    private double lat;
    @Column(name = "LNG")
    private double lng;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PAYMENT_CODE")
    private String paymentCode;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "ORDER_PRICE")
    private double orderPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientOrder that = (ClientOrder) o;

        if (Double.compare(that.lat, lat) != 0) return false;
        if (Double.compare(that.lng, lng) != 0) return false;
        if (Double.compare(that.orderPrice, orderPrice) != 0) return false;
        if (clientAddress != null ? !clientAddress.equals(that.clientAddress) : that.clientAddress != null)
            return false;
        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientPhone != null ? !clientPhone.equals(that.clientPhone) : that.clientPhone != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipientAddress != null ? !recipientAddress.equals(that.recipientAddress) : that.recipientAddress != null)
            return false;
        if (recipientName != null ? !recipientName.equals(that.recipientName) : that.recipientName != null)
            return false;
        if (recipientPhone != null ? !recipientPhone.equals(that.recipientPhone) : that.recipientPhone != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientAddress != null ? clientAddress.hashCode() : 0);
        result = 31 * result + (clientPhone != null ? clientPhone.hashCode() : 0);
        result = 31 * result + (recipientName != null ? recipientName.hashCode() : 0);
        result = 31 * result + (recipientPhone != null ? recipientPhone.hashCode() : 0);
        result = 31 * result + (recipientAddress != null ? recipientAddress.hashCode() : 0);
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        temp = Double.doubleToLongBits(orderPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", status='" + status + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
