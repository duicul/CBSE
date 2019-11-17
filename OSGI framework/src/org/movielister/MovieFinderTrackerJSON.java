package org.movielister;

import org.moviefinder.MovieFinder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MovieFinderTrackerJSON extends MovieFinderTracker {
	
	public MovieFinderTrackerJSON(BundleContext context) {
		super(context,new MovieListerJSON());
	}
	
	@Override
	public Object addingService(ServiceReference reference) {
		MovieFinder finder = (MovieFinder) context.getService(reference); 
		lister.bindFinder(finder); 
		System.out.println("Adding service: \n"+this.displayLister());
		synchronized(this) { 
			finderCount ++; 
			if (registering) 
				return finder; 
			registering = (finderCount == 1); 
			if (!registering) 
				return finder; 
		} 
 
		ServiceRegistration reg = context.registerService( 
		MovieLister.class.getName(), lister, null); 
 
		synchronized(this) { 
			registering = false; 
			registration = reg; 
		} 
		System.out.println("Service added : \n"+this.displayLister());
		return finder; 
	}

	@Override
	public void modifiedService(ServiceReference arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void removedService(ServiceReference reference, Object service) {
		MovieFinder finder = (MovieFinder) service; 
		lister.unbindFinder(finder); 
		context.ungetService(reference); 
 
		ServiceRegistration needsUnregistration = null; 
		synchronized(this) { 
			finderCount --; 
			if (finderCount == 0) { 
				needsUnregistration = registration; 
				registration = null; 
			} 
		} 
 
		if(needsUnregistration != null) { 
			needsUnregistration.unregister(); 
		} 
		System.out.println("Service removed : \n"+this.displayLister());

	}

	@Override
	public String displayLister() {
		return this.lister.display();
	}

}
