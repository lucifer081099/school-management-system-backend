package com.school_management_system.data_management.models;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;
import java.util.Map;

@SolrDocument(collection = "user")
public class User {
    @Id
    private String id;

    @Field
    private String username;

    @Field
    private String name;

    @Field
    private String rollNumber;

    @Field
    private String userClass;

    @Field
    private String house;

    @Field
    private String classAllocated;

    @Field
    private String seatRow;

    @Field
    private String seatColumn;



    // English hindi maths scienece history economics
    @Field
    private String english;

    @Field
    private String hindi;

    @Field
    private String mathematics;

    @Field
    private String science;

    @Field
    private String history;

    @Field
    private String economics;

    // Getters and Setters

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getMathematics() {
        return mathematics;
    }

    public void setMathematics(String mathematics) {
        this.mathematics = mathematics;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getEconomics() {
        return economics;
    }

    public void setEconomics(String economics) {
        this.economics = economics;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getClassAllocated() {
        return classAllocated;
    }

    public void setClassAllocated(String classAllocated) {
        this.classAllocated = classAllocated;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }
 

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", userClass='" + userClass + '\'' +
                ", house='" + house + '\'' +
                ", classAllocated='" + classAllocated + '\'' +
                ", seatRow='" + seatRow + '\'' +
                ", seatColumn='" + seatColumn + '\'' +
                ", english='" + english + '\'' +
                ", hindi='" + hindi + '\'' +
                ", mathematics='" + mathematics + '\'' +
                ", science='" + science + '\'' +
                ", history='" + history + '\'' +
                ", economics='" + economics + '\''+
                '}';
    }
}
