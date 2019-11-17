package org.movielister;

import org.moviefinder.MovieFinder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;


public abstract class MovieFinderTracker extends ServiceTracker {
	protected final MovieLister lister;
	protected int finderCount = 0;
	protected ServiceRegistration registration = null;
	protected boolean registering = false;
	
	public MovieFinderTracker(BundleContext context,MovieLister l) {
		super(context, MovieFinder.class.getName(),null);
		this.lister = l;}

	public abstract String displayLister();
}
