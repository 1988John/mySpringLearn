package com.foo.service.user;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foo.dao.user.AddressDao;
import com.foo.domain.user.Address;
import com.google.common.collect.Maps;

/**
 * @author Fooisart
 * @date 11:05 30-01-2019
 */
@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    public Address getAddressById(int id){
        return addressDao.selectEntryById(id);
    }

    public Map<Integer, Address> getAddressByIds(Collection<Integer> ids){
        Map<Integer,Address> map = Maps.newHashMap();
        ids.forEach(id -> {
            Address address = getAddressById(id);
            map.put(id,address);
        });
        return map;
    }
}
