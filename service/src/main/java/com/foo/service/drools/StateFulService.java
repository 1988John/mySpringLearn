package com.foo.service.drools;

import com.foo.domain.user.Product;
import org.apache.poi.ss.formula.functions.T;
import org.drools.command.Command;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import java.util.List;

public class StateFulService {

	private StatefulKnowledgeSession statefulKnowledgeSession;

	public void CalculateDiscount(Command<T> command) {
        statefulKnowledgeSession.execute(command);
	}

    public void setStatefulKnowledgeSession(StatefulKnowledgeSession statefulKnowledgeSession) {
        this.statefulKnowledgeSession = statefulKnowledgeSession;
    }

}
