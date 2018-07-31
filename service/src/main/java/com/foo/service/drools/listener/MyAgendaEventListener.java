package com.foo.service.drools.listener;

import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangwang3
 * @date 2018/7/31.
 */
public class MyAgendaEventListener extends DefaultAgendaEventListener{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public void activationCreated(ActivationCreatedEvent event) {
        LOGGER.error("activationCreated:{}",event);
    }

    @Override
    public void afterActivationFired(AfterActivationFiredEvent event) {
        LOGGER.error("afterActivationFired:{}",event);
    }
}
