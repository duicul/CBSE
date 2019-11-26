package org.extender.movielister;

import java.util.List;

public class MovieListerJSON implements MovieLister {
	    
	@Override
	public String display(MovieFinder mf) {
		StringBuffer sb=new StringBuffer();
	    sb.append("{");
	    List<String> mov=mf.extract();
	    if(mov.size()>0) {
	    int t=0;
	    for(String s:mov)
	        sb.append("\""+(t++)+"\":\""+s+"\",");
	    sb.deleteCharAt(sb.length()-1);}
	    sb.append("}");
		return sb.toString();
	}

	@Override
	public String display(List<MovieFinder> mf) {
		StringBuffer sb=new StringBuffer();
	    sb.append("{");
	    if(mf.size()>0) {
	    int t=0;
	    for(MovieFinder s:mf)
	        sb.append("\""+(t++)+"\":\""+this.display(s)+"\",");
	    sb.deleteCharAt(sb.length()-1);}
	    sb.append("}");
		return sb.toString();
	}

}
