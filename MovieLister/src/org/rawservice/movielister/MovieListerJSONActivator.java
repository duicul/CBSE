package org.rawservice.movielister;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class MovieListerJSONActivator implements BundleActivator {
    public static boolean stop=false;
	public MovieListerJSONActivator() {
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		stop=false;
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping "+arg0.getBundle().getSymbolicName());
		stop=true;
	}

}
