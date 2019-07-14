package com.adoredeveloper.sweetsbucket.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeShopsAll {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("vendor_details")
    @Expose
    public VendorDetails vendorDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorDetails getVendorDetails() {
        return vendorDetails;
    }

    public void setVendorDetails(VendorDetails vendorDetails) {
        this.vendorDetails = vendorDetails;
    }
    public static class VendorDetails {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("vendor_id")
        @Expose
        public String vendorId;
        @SerializedName("vendor_code")
        @Expose
        public String vendorCode;
        @SerializedName("store_name")
        @Expose
        public String storeName;
        @SerializedName("address1")
        @Expose
        public String address1;
        @SerializedName("address2")
        @Expose
        public String address2;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("pin")
        @Expose
        public String pin;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("street")
        @Expose
        public String street;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("store_front")
        @Expose
        public String storeFront;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getVendorId() {
            return vendorId;
        }

        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        public String getVendorCode() {
            return vendorCode;
        }

        public void setVendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPin() {
            return pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStoreFront() {
            return storeFront;
        }

        public void setStoreFront(String storeFront) {
            this.storeFront = storeFront;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
}
