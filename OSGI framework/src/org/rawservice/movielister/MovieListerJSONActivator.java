package org.rawservice.movielister;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class MovieListerJSONActivator implements BundleActivator {
	private ServiceTracker tracker;
    
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		new Thread(new Runnable() {

			@Override
			public void run() {
				tracker = new ServiceTracker(context,MovieFinder.class.getName(),new MovieFinderTracker(context));
				tracker.open();
				
			}
			
		}).start();
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping "+arg0.getBundle().getSymbolicName());
		tracker.close();

	}

}
