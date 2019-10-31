package Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class IoCContainer {
	private List<Dependency> depend;
	
	public void addDependency(JSONObject dep) {
		String class_name=(String) dep.get("class");
		Dependency d=new Dependency(class_name);
		JSONArray dependencies=(JSONArray) dep.get("dependency");
		for(int i=0;i<dependencies.size();i++)
			d.addDependency((String) ((JSONObject)dependencies.get(i)).get("class"));
		this.depend.add(d);
	}
	
	public IoCContainer(String config) {
		this.depend= new ArrayList<Dependency>();
		this.addConfig(config);
	}
	
	public void addConfig(String file_name) {
		File file = new File(file_name);
		String data=null;
		try {
			FileReader fr = new FileReader(file);
			JSONParser parser = new JSONParser();
			try {
				JSONArray conf=(JSONArray)parser.parse(fr);
			    for(int i=0;i<conf.size();i++) 
			    	this.addDependency((JSONObject)conf.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	public Object retrieve(String class_name) {
		Object o=null;
		for(Dependency d:this.depend)
			if(d.matchName(class_name)) {
				try {
					Class<?> cl=Class.forName(d.getName());
					Class<?>[] conssign=new Class<?>[d.getDependencies().size()];
					List<Object> consobj=new ArrayList<Object>();
					int ind=0;
					for(String s:d.getDependencies()) {
						boolean found=false;
						for(Dependency d1:this.depend)
							if(s.equals(d1.getName())) {
								Object oaux=this.retrieve(s);
								consobj.add(oaux);
								conssign[ind++]=oaux.getClass();
								found=true;break;}
						if(!found) {
						Class<?> c = Class.forName(s);
						Object oaux = c.getConstructor().newInstance();
						consobj.add(oaux);
						conssign[ind++]=c;
						}
						
						Constructor depcons = null ;
						Constructor[] conslis=cl.getConstructors();
						for(Constructor c: conslis) {
							int find=0;
							Class<?>[] param=c.getParameterTypes();
							for(int i=0;i<param.length;i++)
								
								for(int j=0;j<conssign.length;j++)
									if(param[i].isAssignableFrom(conssign[j])) {
										find++;break;}
							if(find==conslis.length)
								{depcons=c;break;}
						}
						if(depcons!=null)
							o=depcons.newInstance(consobj.toArray());
					}
					
					
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return o;
	}
		
	public String toString() {
		String s="";
		for(Dependency d:this.depend)
			s+=d.toString()+"\n----------------------\n";
		return s;
	}

}