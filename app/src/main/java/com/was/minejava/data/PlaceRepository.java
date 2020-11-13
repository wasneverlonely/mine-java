package com.was.minejava.data;

import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.data.dao.PlaceDao;
import com.was.minejava.data.model.Province;
import com.was.minejava.data.network.PlaceNetwork;

import java.util.List;

public class PlaceRepository {

    private PlaceDao placeDao;
    private PlaceNetwork placeNetWork;

    private PlaceRepository(PlaceDao placeDao, PlaceNetwork placeNetWork) {
        this.placeDao = placeDao;
        this.placeNetWork = placeNetWork;
    }


    public List<Province> getProvinceList() {
//        List<Province> data = placeDao.getProvinceList();
//        if (data == null || data.isEmpty()) {
//            placeNetWork.fetchProvinceList(new HttpSubscriber<List<Province>>() {
//                @Override
//                public void onSuccess(NetState<List<Province>> netState) {
//                    data = netState.getData();
////                    placeDao.saveProvinceList(provinces);
////                    return provinces;
//                }
//            });
//        }
//        return data;
        return null;
    }

    private static PlaceRepository instance = null;

    public static PlaceRepository getInstance() {
        if (instance == null) {
            instance = new PlaceRepository(new PlaceDao(), new PlaceNetwork());
        }
        return instance;
    }

}
