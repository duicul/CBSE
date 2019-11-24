package org.rawservice.movielister;

import org.rawservice.movielister.MovieFinder;
import org.rawservice.movielister.MovieLister;


public class MovieListerJSON extends MovieLister {
	
	public MovieListerJSON() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(!MovieListerJSONActivator.stop) {
				display();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
			
		}).start();
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
