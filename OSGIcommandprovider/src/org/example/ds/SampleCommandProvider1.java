package org.example.ds;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

public class SampleCommandProvider1 implements CommandProvider {
	
	private Runnable runnable;
	
	public synchronized void setRunnable(Runnable r) {
		runnable = r;
	}
	public synchronized void unsetRunnable(Runnable r) {
		runnable = null;
	}
	public synchronized void _run(CommandInterpreter ci) {
		if(runnable != null) {
			runnable.run();
		} else {
			ci.println("Error, no Runnable available");
		}
	}
	public String getHelp() {
		return "\trun - execute a Runnable service";
	}
}