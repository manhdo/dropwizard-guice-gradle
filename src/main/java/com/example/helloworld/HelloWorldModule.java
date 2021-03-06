package com.example.helloworld;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;


public class HelloWorldModule extends AbstractModule {
	@Override
	protected void configure() {
		// TODO: Implement this method.
	}

	@Provides
	@Named("template")
	public String provideTemplate(HelloWorldConfiguration configuration) {
		return configuration.getTemplate();
	}

	@Provides
	@Named("defaultName")
	public String provideDefaultName(HelloWorldConfiguration configuration) {
		return configuration.getDefaultName();
	}
}
