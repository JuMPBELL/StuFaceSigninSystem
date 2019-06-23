package com.stufacesigninsystem.demo.Entity;

public class Student {
    private int StuID;
    private String StuName;
    private String StuSex;

    public int getStuID() {
        return StuID;
    }

    public void setStuID(int stuID) {
        StuID = stuID;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getStuSex() {
        return StuSex;
    }

    public void setStuSex(String stuSex) {
        StuSex = stuSex;
    }

    public String getStuFace() {
        return StuFace;
    }

    public void setStuFace(String stuFace) {
        StuFace = stuFace;
    }

    private String StuFace;
}
