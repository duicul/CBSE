package org.rawservice.moviefinder.web;
import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.rawservice.movielister.MovieFinder;

public class MovieFinderWebActivator implements BundleActivator {
	private ServiceRegistration registration;
	
	@Override
	public void start(BundleContext context) throws Exception{
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		String[] interfaces = new String[] { MovieFinder.class.getName()};
		
		MovieFinder finder = (MovieFinder) new MovieFinderWeb();
		System.out.println(finder.extract());
		Dictionary props = new Properties();
		props.put("source", "web");

		registration = context.registerService(
                           interfaces,
                           finder, props);
		System.out.println("Registered "+context.getBundle().getSymbolicName());

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		System.out.println("Stopping "+context.getBundle().getSymbolicName());

	}

}
