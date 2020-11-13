package com.was.minejava.data.dao;

import com.was.minejava.data.model.Province;

import org.litepal.LitePal;

import java.util.List;

public class PlaceDao {

    //获取
    public List<Province> getProvinceList() {
        return LitePal.findAll(Province.class);

    }

    public void saveProvinceList(List<Province> provinceList) {

        if (provinceList != null && !provinceList.isEmpty()) {
//            LitePal.saveAll(provinceList);
        }

    }
}
