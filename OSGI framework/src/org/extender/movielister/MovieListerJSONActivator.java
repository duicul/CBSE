package org.extender.movielister;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class MovieListerJSONActivator implements BundleActivator {
	//private boolean stop;
	private MovieFinderSet mfs;
    
	@Override
	public void start(BundleContext context) throws Exception {
		//stop = false;
		MovieFinderSet.clean();
		mfs = MovieFinderSet.getInstance();
		MovieLister ml=new MovieListerJSON();
		context.addBundleListener(new MovieListerListener());
		/*
		new Thread(new Runnable() {
		  public void run() {
		    while (!stop) {
		      try {
		        Thread.sleep(8000);
		        String text = "";
		        for (MovieFinder mf : mfs.getAllNewFinder()) {
		           text = text + " " + ml.display(mf);
		        }
		        System.out.println(text);
		      } catch (Exception e) {}
		    }
		   }
		}).start();*/

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		MovieFinderSet.clean();
		System.out.println("Stopping "+arg0.getBundle().getSymbolicName());
		//this.stop=true;

	}

}
