package com.foo.service.drools;

import com.foo.domain.user.Product;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.runtime.StatelessKnowledgeSession;

public class SimpleService {

	private StatelessKnowledgeSession productSession;

	private WorkingMemoryEventListener workingMemoryListener;

	private AgendaEventListener agendaEventListener;

	public void CalculateDiscount(Product product) {
		productSession.addEventListener(workingMemoryListener);
		productSession.addEventListener(agendaEventListener);
		productSession.execute(product);
	}

	public void setProductSession(StatelessKnowledgeSession productSession) {
		this.productSession = productSession;
	}

    public void setWorkingMemoryListener(WorkingMemoryEventListener workingMemoryListener) {
        this.workingMemoryListener = workingMemoryListener;
    }

    public void setAgendaEventListener(AgendaEventListener agendaEventListener) {
        this.agendaEventListener = agendaEventListener;
    }
}
