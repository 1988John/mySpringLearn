package com.foo.service.user;

import org.springframework.stereotype.Service;

/**
 * Fields are isolated with @Contended,
 * we can not risk accidental false sharing.
 */
public interface OrderService {
    String getOrder();

}
