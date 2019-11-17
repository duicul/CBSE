package org.movielister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.moviefinder.MovieFinder;
import org.osgi.util.tracker.ServiceTracker;

public class MovieListerBasic implements MovieLister {
	private Collection finders = Collections.synchronizedCollection(new ArrayList());
	
	public void bindFinder(MovieFinder finder) {
			finders.add(finder);
			System.out.println(this.getClass().getName()+" added a finder : "+finder.getClass());
		}
		
	public void unbindFinder(MovieFinder finder) {
			finders.remove(finder);
			System.out.println(this.getClass().getName()+" removed a finder : "+finder.getClass());
		}
	
	/*private final ServiceTracker finderTrack;
	 
    public MovieListerBasic(ServiceTracker finderTrack) {
        this.finderTrack = finderTrack;
    }*/
	
	@Override
	public String display() {
		StringBuffer sb=new StringBuffer();
		MovieFinder[] finderArray = (MovieFinder[])finders.toArray(new MovieFinder[finders.size()]);
		for(int i=0;i<finderArray.length;i++) {
	        	int t=0;
	        	for(String s:finderArray[i].extract())
	        		sb.append(s+"\n");}    	
            return sb.toString();
	}

}
