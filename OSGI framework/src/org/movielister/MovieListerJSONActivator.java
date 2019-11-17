package org.movielister;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class MovieListerJSONActivator implements BundleActivator {
	private MovieFinderTracker tracker;
    
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		tracker = new MovieFinderTrackerJSON(context);
		tracker.open();}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping "+arg0.getBundle().getSymbolicName());
		tracker.close();

	}

}
