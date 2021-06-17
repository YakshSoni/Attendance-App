package com.example.attendence;

public class StudentItem {
    private int roll;
    private String name;
    private String status;
    private long sid;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public StudentItem(int roll, String name, String status, long sid) {
        this.roll = roll;
        this.name = name;
        this.status = status;
        this.sid = sid;
    }

    public StudentItem(long sid,int roll, String name) {
        this.roll = roll;
        this.sid = sid;
        this.name = name;
        status=null;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
