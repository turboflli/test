package com.teste.ubs.application.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ubs")
public class UbsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Double lon;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = true)
    private Integer size;

    @Column(nullable = true)
    private Integer adaptation_for_seniors;

    @Column(nullable = true)
    private Integer medical_equipment;

    @Column(nullable = true)
    private Integer medicine;

    public UbsEntity() {

    }

    public UbsEntity(Long id, String name, String adress, String city, String phone, Double lon, Double lat,
                     Integer size, Integer adaptation_for_seniors, Integer medical_equipment, Integer medicine) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.phone = phone;
        this.lon = lon;
        this.lat = lat;
        this.size = size;
        this.adaptation_for_seniors = adaptation_for_seniors;
        this.medical_equipment = medical_equipment;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getAdaptation_for_seniors() {
        return adaptation_for_seniors;
    }

    public Integer getMedical_equipment() {
        return medical_equipment;
    }

    public Integer getMedicine() {
        return medicine;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\" :" + id +
                ", \"name\" : \"" + name + '"' +
                ", \"adress\" : \"" + adress + '"' +
                ", \"city\" : \"" + city + '"' +
                ", \"phone\" : \"" + phone + '"' +
                ",  \"geocode\" : {"+
                    " \"lat\" : " + lat +
                    ", \"long\" : " + lon +
                " } " +
                ", \"score\" : {" +
                    " \"size\" : " + size +
                    ", \"adaptation_for_seniors\" : " + adaptation_for_seniors +
                    ", \"medical_equipment\" : " + medical_equipment +
                    ", \"medicine\" : " + medicine +
                "}" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UbsEntity ubsEntity = (UbsEntity) o;
        return Objects.equal(id, ubsEntity.id) &&
                Objects.equal(name, ubsEntity.name) &&
                Objects.equal(adress, ubsEntity.adress) &&
                Objects.equal(city, ubsEntity.city) &&
                Objects.equal(phone, ubsEntity.phone) &&
                Objects.equal(lon, ubsEntity.lon) &&
                Objects.equal(lat, ubsEntity.lat) &&
                Objects.equal(size, ubsEntity.size) &&
                Objects.equal(adaptation_for_seniors, ubsEntity.adaptation_for_seniors) &&
                Objects.equal(medical_equipment, ubsEntity.medical_equipment) &&
                Objects.equal(medicine, ubsEntity.medicine);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, adress, city, phone, lon, lat, size, adaptation_for_seniors, medical_equipment, medicine);
    }
}
