package com.foo.service.drools.listener;

import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangwang3
 * @date 2018/7/31.
 */
public class MyWorkingMemoryEventListener implements WorkingMemoryEventListener {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        LOGGER.error("objectInserted:{}",event);
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        LOGGER.error("objectUpdated:{}",event);
    }

    @Override
    public void objectRetracted(ObjectRetractedEvent event) {
        LOGGER.error("objectRetracted");
    }

}
