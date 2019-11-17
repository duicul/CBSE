package org.movielister;

import org.moviefinder.MovieFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class MovieListerBasicActivator implements BundleActivator {
	private MovieFinderTracker tracker;
    
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		tracker = new MovieFinderTrackerBasic(context);
		tracker.open();}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping "+arg0.getBundle().getSymbolicName());
		tracker.close();

	}

}
