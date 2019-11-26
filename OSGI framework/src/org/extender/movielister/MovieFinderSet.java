package org.extender.movielister;

import java.util.ArrayList;
import java.util.List;


public class MovieFinderSet {
	private List<Pair<String,MovieFinder>> set,newset;
	private static MovieFinderSet mfs = null;
	
	private MovieFinderSet() {
		this.newset=new ArrayList<Pair<String,MovieFinder>>();
		this.set=new ArrayList<Pair<String,MovieFinder>>();
	}
	
	public static MovieFinderSet getInstance() {
		if(mfs==null)
			mfs=new MovieFinderSet();
		return mfs;
	}
	
	public static void clean() {
		mfs=null;
	}
	
	public void addFinder(String name,MovieFinder newInstance) {
		System.out.println("addFinder "+name);
		Pair<String,MovieFinder> p=new Pair<String,MovieFinder>(name,newInstance);
		set.add(p);
		newset.add(p);
		System.out.println(new MovieListerJSON().display(this.getAllFinder()));
	}

	public boolean removeFinder(String name) {
		System.out.println("removeFinder "+name);
		Pair<String,MovieFinder> aux=null;
		for(Pair<String,MovieFinder> p:set)
			if(p.l.equals(name)) {
				aux=p;break;
			}
		if(aux!=null) {
			this.newset.remove(aux);
			boolean ret = set.remove(aux);
			System.out.println(new MovieListerJSON().display(this.getAllFinder()));
			return ret;}
		System.out.println(new MovieListerJSON().display(this.getAllFinder()));
		return false;
	}
	
	
	public MovieFinder getFinder(String name) {
		for(Pair<String,MovieFinder> p:newset)
			if(p.l.equals(name))
				return p.r;
		return null;
	}
	
	public List<MovieFinder> getAllNewFinder() {
		List<MovieFinder> lmf=new ArrayList<MovieFinder>();
		for(Pair<String,MovieFinder> p:newset) {
			lmf.add(p.r);}
		this.newset.clear();
		return lmf;
	}
	
	public List<MovieFinder> getAllFinder() {
		List<MovieFinder> lmf=new ArrayList<MovieFinder>();
		for(Pair<String,MovieFinder> p:set) {
			lmf.add(p.r);}
		return lmf;
	}
}
