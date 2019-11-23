package org.rawservice.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.rawservice.movielister.MovieListerJSON;

public class ClientActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting "+context.getBundle().getSymbolicName());
		System.out.println(MovieListerJSON.getInstance().display());

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		 System.out.println("Stopping "+context.getBundle().getSymbolicName());

	}

}
