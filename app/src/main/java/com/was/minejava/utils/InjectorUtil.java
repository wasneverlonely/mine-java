package com.was.minejava.utils;

import com.was.minejava.data.PlaceRepository;
import com.was.minejava.data.dao.PlaceDao;
import com.was.minejava.data.network.PlaceNetwork;

public class InjectorUtil {


    public static PlaceRepository getPlaceRepository() {
        return PlaceRepository.getInstance();
    }

}
