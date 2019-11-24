package org.example.ds;

public class ImplementedBinding implements BindingService {

	
	private Runnable runnable;
	
	public synchronized void setRunnable(Runnable r) {
		runnable = r;
		System.out.println("setRunnable");
		r.run();
	}
	public synchronized void unsetRunnable(Runnable r) {
		System.out.println("unsetRunnable");
		runnable = null;
	}
	@Override
	public void bind() {
		System.out.println("Bind service");

	}

	@Override
	public void unbind() {
		System.out.println("Unbind service");
	}

}
