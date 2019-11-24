package org.rawservice.moviefinder.database;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class MovieFinderDataBaseActivator implements BundleActivator {
	
	@Override
	public void start(BundleContext context) throws Exception{
		System.out.println("Starting "+context.getBundle().getSymbolicName());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping "+context.getBundle().getSymbolicName());

	}

}
