package org.rawservice.moviefinder.database;
import java.util.ArrayList;
import java.util.List;

import org.rawservice.movielister.MovieFinder;


public class MovieFinderDataBase implements MovieFinder{

	@Override
	public List<String> extract() {
		List<String> l=new ArrayList<String>();
		l.add("Terminator 1");
		l.add("Terminator 2");
		l.add("Rush Hour 2");
		return l;
	}
	

}
