package org.moviefinder;
import java.util.ArrayList;
import java.util.List;

public class MovieFinderWeb implements MovieFinder {

	@Override
	public List<String> extract() {
		List<String> l=new ArrayList<String>();
		l.add("Rocky 5 -Stallone");
		l.add("Home Alone 1");
		l.add("Home Alone 2");
		return l;
	}

}
