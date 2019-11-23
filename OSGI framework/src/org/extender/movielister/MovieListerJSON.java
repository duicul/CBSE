package org.extender.movielister;

public class MovieListerJSON implements MovieLister {
	    
	@Override
	public String display(MovieFinder mf) {
		StringBuffer sb=new StringBuffer();
	    sb.append("{");
	    int t=0;
	    for(String s:mf.extract())
	        sb.append("\""+(t++)+"\":\""+s+"\",");
	    sb.deleteCharAt(sb.length()-1);
	    sb.append("}");
		return sb.toString();
	}

}
