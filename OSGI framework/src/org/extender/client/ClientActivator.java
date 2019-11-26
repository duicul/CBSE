package org.extender.client;

import org.extender.movielister.MovieFinder;
import org.extender.movielister.MovieFinderSet;
import org.extender.movielister.MovieLister;
import org.extender.movielister.MovieListerJSON;
import org.extender.movielister.MovieListerListener;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ClientActivator implements BundleActivator {
	private boolean stop;
	private MovieFinderSet mfs;
    
	@Override
	public void start(BundleContext context) throws Exception {
		stop = false;
		mfs = MovieFinderSet.getInstance();
		MovieLister ml=new MovieListerJSON();
		//context.addBundleListener(new MovieListerListener());

		new Thread(new Runnable() {
		  public void run() {
		    while (!stop) {
		      try {
		        Thread.sleep(8000);
		        System.out.println(ml.display(mfs.getAllFinder()));
		        System.out.println(ml.display(mfs.getAllNewFinder()));
		      } catch (Exception e) {}
		    }
		   }
		}).start();

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping "+arg0.getBundle().getSymbolicName());
		this.stop=true;

	}

}
