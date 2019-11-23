package org.rawservice.movielister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.rawservice.movielister.MovieFinder;
import org.rawservice.movielister.MovieLister;


public class MovieListerJSON extends MovieLister {
	
	private static MovieListerJSON mlj=null;
	
	private MovieListerJSON() {
		super();}
	
	public static MovieListerJSON getInstance() {
		if(mlj==null)
			mlj=new MovieListerJSON();
		return mlj;
	}
	
	public String display() {
		StringBuffer sb=new StringBuffer();
		MovieFinder[] finderArray = (MovieFinder[])this.finders.toArray(new MovieFinder[finders.size()]);
		if(finderArray.length>0) {
		sb.append("{");
		for(int i=0;i<finderArray.length;i++) {
	        	sb.append("\""+(i)+"\":{");
	        	int t=0;
	        	for(String s:finderArray[i].extract())
	        		sb.append("\""+(t++)+"\":\""+s+"\",");
	        	sb.deleteCharAt(sb.length()-1);
	        	sb.append("},");}
		 sb.deleteCharAt(sb.length()-1);
		 sb.append("}");}
		 return sb.toString();
	}

}
