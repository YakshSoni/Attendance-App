package com.example.attendence;
import android.service.autofill.SaveRequest;

public class classItem
{
    private long cid;

    public long getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public classItem(long cid, String className, String subjectName) {
        this.cid = cid;
        this.className = className;
        this.subjectName = subjectName;
    }

    private String className,subjectName;

    public classItem(String className, String subjectName) {
        this.className = className;
        this.subjectName = subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

