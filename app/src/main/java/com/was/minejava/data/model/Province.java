package com.was.minejava.data.model;


//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;

/**
 * 省份model
 */

//@Entity(tableName = "province")
public class Province {

    //    @PrimaryKey(autoGenerate = true)
    //    private int id;

    //    @ColumnInfo(name = "code")
    private String code;

    //    @ColumnInfo(name = "name")
    private String name;

    //    @ColumnInfo(name = "isCheck")
    private boolean isCheck; // 是否选择

    //    @ColumnInfo(name = "isUnlimited")
    public boolean isUnlimited; //是否替补不限

    public Province(String code, String name) {
        this.code = code;
        this.code = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public boolean isUnlimited() {
        return isUnlimited;
    }

    public void setUnlimited(boolean unlimited) {
        isUnlimited = unlimited;
    }
}
