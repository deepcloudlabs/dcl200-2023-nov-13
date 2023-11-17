package com.example;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

public class StartJfr {

	public static void main(String[] args) throws InstanceNotFoundException, ReflectionException, MBeanException, MalformedObjectNameException, InterruptedException {
		System.out.println("Application is just started.");
		ObjectName objectName = new ObjectName("com.sun.management:type=DiagnosticCommand"); 
		Object[] arguments = new Object[] {
		    new String[] {
		        "dumponexit=true",
		        "filename=c:/tmp/recording.jfr",
		        "duration=20s"
		    }
		};
		String[] sig = new String[] {"[Ljava.lang.String;"};
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

		mBeanServer.invoke(objectName, "jfrStart", arguments, sig);
		TimeUnit.SECONDS.sleep(30);
		System.out.println("Application is done.");
	}

}
