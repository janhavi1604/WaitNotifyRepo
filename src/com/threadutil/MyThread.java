package com.threadutil;

class Cab 
{ 
	
}

class CabDriver implements Runnable
{
	
	Cab cab;
	String name;
	public CabDriver(Cab cab,String name)
	{ 
		this.cab=cab;
		this.name=name;
	}
	public void run() 
	{ 
		synchronized(cab)
		{
			 try
			 { 
				 System.out.println("The cab is "+this.cab);
				 cab.wait();
				 System.out.println("The cab Driver is "+this.name);
			 }
			 catch(InterruptedException e)
			 {
				 System.out.println(e);
			 }
		}
	}
}

class Notify implements Runnable
{ 
	Cab cab;
	Notify(Cab cab)
	{ 
		this.cab=cab;
	}
	public void run()
	{
		synchronized(cab)
		{
			try {
				Thread.sleep(5000);
				 cab.notify();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
public class MyThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Cab cab1=new Cab();
		 CabDriver cabd=new CabDriver(cab1,"James");
		 Notify not=new Notify(cab1);
		 Thread t1=new Thread(cabd);
		 Thread t2=new Thread(not);
		 t1.start();
		 t2.start();

	}

}
