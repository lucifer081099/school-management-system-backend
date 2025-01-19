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
    @Field
    private String username;

    @Field("name")
    @SortableField
    private String name;

    @Field
    private String rollNumber;

    @Field
    private String userClass;

    @Field("house")
    private String house;

    @Field
    private List<Seat> seatAllocated;

    @Field("marks")
    private Map<String, String> marks;

    // Getters and Setters

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

    public List<Seat> getSeatAllocated() {
        return seatAllocated;
    }

    public void setSeatAllocated(List<Seat> seatAllocated) {
        this.seatAllocated = seatAllocated;
    }

    public Map<String, String> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, String> marks) {
        this.marks = marks;
    }

    // Nested class for seat allocation
    public static class Seat {
        private String classAllocated;
        private String seatRow;
        private String seatColumn;

        // Getters and Setters
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
            return "Seat{" +
                    "classAllocated='" + classAllocated + '\'' +
                    ", seatRow='" + seatRow + '\'' +
                    ", seatColumn='" + seatColumn + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", userClass='" + userClass + '\'' +
                ", house='" + house + '\'' +
                ", seatAllocated=" + seatAllocated +
                ", marks=" + marks +
                '}';
    }
}
