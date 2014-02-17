package com.example.helloworld;


import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	public HelloWorldApplication() {
		super();

	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

		// Configure GuiceBundle
		GuiceBundle<HelloWorldConfiguration> guiceBundle = GuiceBundle.<HelloWorldConfiguration>newBuilder()
				.addModule(new HelloWorldModule())
				.enableAutoConfig(getClass().getPackage().getName())
				.setConfigClass(HelloWorldConfiguration.class)
				.build();

		// add GuiceBundle to bootstrap
		bootstrap.addBundle(guiceBundle);

	}

	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
		// TODO: Implement this method.
	}
}
