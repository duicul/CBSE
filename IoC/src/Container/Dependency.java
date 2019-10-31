package Container;
import java.util.ArrayList;
import java.util.List;

public class Dependency {
  private String class_name;
  private List<String> dependencies;
  
  public Dependency(String name) {
	  this.class_name=name;
	  this.dependencies=new ArrayList<String>();
  }
  
  public boolean matchName(String name) {
	  return this.class_name.equals(name);}
  
  public boolean addDependency(String name) {
	  if(this.dependencies.contains(name))
		  return false;
	  this.dependencies.add(name);
	  return true;
  }
  
  public String getName() {
	  return this.class_name;
  }
  
  public List<String> getDependencies() {
	  return this.dependencies;
  }
  
  public String toString() {
	  String s = "";
	  s+="class "+this.class_name+" \n";
	  s+="dependencies: ";
	  for(String sdep:this.dependencies)
		  s+="   "+sdep+"\n";
	  return s;}
}
