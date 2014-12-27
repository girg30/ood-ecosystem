package com.annvcit.model;

import org.junit.Test;

public class EcosystemTest {

	@SuppressWarnings("unused")
	@Test
	public void testEcosystem() {
		// ban đầu là africa
		Ecosystem africa = new Ecosystem(new ImplAfricaFacotry());
		// chuyển qua finnish at runtime
		Ecosystem finnish = new Ecosystem(new ImplFinnishFactory());
	}

}
