package com.acme.advweb.day4.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    
    @Id @Column(name = "customer_id") private Integer customerId;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String phone;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public JsonObject toJson() {
        return (Json.createObjectBuilder()
                .add("customerId", customerId)
                .add("name", name)
                .add("addressline1", addressLine1)
                .add("addressline2", addressLine2)
                .add("city", city)
                .add("state", state)
                .add("phone", phone)
                .build());
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", phone=" + phone + '}';
    }        
}
