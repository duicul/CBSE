package org.rawservice.movielister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class MovieLister {
	protected Collection<MovieFinder> finders = Collections.synchronizedCollection(new ArrayList<MovieFinder>());
 
	public void bindFinder(MovieFinder finder) {
		boolean ret=finders.add(finder);
		System.out.println(this.getClass().getName()+" added a finder : "+finder.getClass()+" "+ret);
	}
	
	public void unbindFinder(MovieFinder finder) {
		boolean ret=finders.remove(finder);
		System.out.println(this.getClass().getName()+" removed a finder : "+finder.getClass()+" "+ret);
	}
	
	public Collection<MovieFinder> getFinders(){
		return this.finders;
	}
	
	public abstract String display();
}
