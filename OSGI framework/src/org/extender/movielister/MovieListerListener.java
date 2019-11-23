package org.extender.movielister;

import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

public class MovieListerListener implements BundleListener {
	
	public MovieListerListener() {
	}
	
	@Override
	public void bundleChanged(BundleEvent event) {
		System.out.println("Listener: Event type=" + event.getType() +
				 " bundle" + event.getBundle() + 
				 " source=" + event.getSource());

				Bundle bundle = event.getBundle();

				if (event.getType() == BundleEvent.STARTED) {
					if (isExtension(bundle))
						addExtension(bundle);
					}

				if (event.getType() == BundleEvent.STOPPED) {
					if (isExtension(bundle))
						removeExtension(bundle);
					}


	}
	
	private void removeExtension(Bundle bundle) {
		 System.out.println("MovieFinder extension will be removed: "
				  + bundle.getSymbolicName());

				  Dictionary<String,String> dict = bundle.getHeaders();
				  String name = (String) dict.get("Finder-Extension-Name");
				  // Get the class of the extension.
				  //String className = (String) dict.get("Extension-Class");
				  //Class<?> clazz = null;
				  try {
				    MovieFinderSet.getInstance().removeFinder(name);
				    } catch (Exception e) {
				         e.printStackTrace();
				         }
		
	}

	private boolean isExtension(Bundle bundle) {

		Dictionary<String,String> dict = bundle.getHeaders();

		// Try to get the name of the extension.
		String name = (String) dict.get("Finder-Extension-Name");
		// Return immediately if the bundle is not an extension.
		if (name == null) {
		System.out.println("Bundle " + bundle.getSymbolicName()
		+ " not a Finder Extension");
		return false;
		}
		System.out.println("Bundle " + bundle.getSymbolicName()
		+ " is a Finder Extension");
		return true;
		}

	private void addExtension(Bundle bundle) {
		  System.out.println("MovieFinder extension will be added: "
		  + bundle.getSymbolicName());

		  Dictionary<String,String> dict = bundle.getHeaders();
		  String name = (String) dict.get("Finder-Extension-Name");
		  // Get the class of the extension.
		  String className = (String) dict.get("Extension-Class");
		  Class<?> clazz = null;
		  try {
			System.out.println("Extension-Class "+className);
		    clazz = bundle.loadClass(className);
		    Object o =  clazz.getDeclaredConstructor().newInstance();
		    System.out.println(clazz.getCanonicalName());
		    System.out.println(o.toString());
		    MovieFinder mf=(MovieFinder) o;
		    System.out.println("Receive object ");
		    MovieFinderSet.getInstance().addFinder(name,mf);
		    } catch (Exception e) {
		    	System.out.println("exception ");
		         e.printStackTrace();
		         }
		  System.out.println("Added extension ");
	}

}
