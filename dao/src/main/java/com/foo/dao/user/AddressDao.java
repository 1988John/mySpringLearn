package com.foo.dao.user;

import com.foo.domain.user.Address;

/**
 * @author Fooisart
 * @date 11:03 30-01-2019
 */
public interface AddressDao {
    Address selectEntryById(int id);
}
