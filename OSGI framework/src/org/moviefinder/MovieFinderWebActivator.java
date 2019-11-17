package org.moviefinder;
import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class MovieFinderWebActivator implements BundleActivator {
	private ServiceRegistration registration;
	
	@Override
	public void start(BundleContext context) throws Exception{
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		MovieFinder finder = new MovieFinderWeb();
		System.out.println(finder.extract());
		Dictionary props = new Properties();
		props.put("source", "web");

		registration = context.registerService(
                           MovieFinder.class.getName(),
                           finder, props);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		System.out.println("Stopping "+context.getBundle().getSymbolicName());

	}

}
