package org.rawservice.movielister;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;


public class MovieFinderTracker implements ServiceTrackerCustomizer {
	private final MovieLister lister;
	private int finderCount = 0;
	private ServiceRegistration<?> registration = null;
	private boolean registering = false;
	private BundleContext context;
	
	public MovieFinderTracker(BundleContext context) {
		this.lister =MovieListerJSON.getInstance();
		this.context=context;}

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
		/*System.out.println("context: "+context.toString());
		System.out.println("Bundles:\n");
		for(Bundle b:context.getBundles())
			System.out.println(b.getBundleId()+" "+b.getSymbolicName());
			*/
		return finder; 
	}

	@Override
	public void modifiedService(ServiceReference arg0, Object arg1) {
		System.out.println("Modified service: \n"+context.getService(arg0));

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

	public String displayLister() {
		return this.lister.display();
	}
}
