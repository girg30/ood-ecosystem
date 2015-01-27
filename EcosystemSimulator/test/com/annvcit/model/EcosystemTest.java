package com.annvcit.model;

import org.junit.Test;

import com.annvcit.controller.ImplAfricaFactory;
import com.annvcit.controller.ImplFinnishFactory;

public class EcosystemTest {

	@SuppressWarnings("unused")
	@Test
	public void testEcosystem_changableInRunTime() {
		// ban đầu là africa
		Ecosystem africa = new Ecosystem(new ImplAfricaFactory());
		// chuyển qua finnish at runtime
		Ecosystem finnish = new Ecosystem(new ImplFinnishFactory());
	}
	
}
