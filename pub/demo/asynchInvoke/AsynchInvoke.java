/*
 * This class has been automatically generated by the webMethods Developer(TM).
 *
 */

import java.io.*;
import java.util.Vector;
import com.wm.util.Table;
import com.wm.util.Values;
import com.wm.data.*;
import com.wm.util.coder.IDataCodable;
import com.wm.app.b2b.util.GenUtil;
import com.wm.app.b2b.client.Context;
import com.wm.app.b2b.client.ServiceException;
import com.wm.app.b2b.client.InvokeThread;

public class AsynchInvoke {

    public static void main(String[] args)
    {
        // Connect to server - edit for alternate server
        String  server = "trainhost.softwareag.com:5555";
        Context context = new Context();

        // Set username and password for protected services
        String username = "tvogler"; // fix as needed
        String password = "wmdev";

		System.out.println("\n");

        try {
            context.connect(server, username, password);
        } catch (ServiceException e) {
            System.out.println("\n\tCannot connect to server \""+server+"\"");
            System.exit(0);
        }

        try {

			boolean synch = false;
			
			IData inputDocument = IDataFactory.create();
            IData outputDocument = null;
			
            // *** Invoke the Service ***
			if (synch) {
				System.out.println("Invoking the service synchronous");
	            outputDocument = context.invoke(
					"advTrainingISDemo.demo.doThreadInvoke", 
					"getInfoMultiThreaded", 
					inputDocument);
			} else {
				System.out.println("Invoking the service asynchronous");
				InvokeThread thr = context.invokeThreaded(
					"advTrainingISDemo.demo.doThreadInvoke", 
					"getInfoMultiThreaded", 
					Values.use(inputDocument));
				System.out.println("Call submitted.");
				try {
					System.out.println("Waiting for results...");
					
					boolean finished = false;
					while (! finished) {

						System.out.println("waiting.");
						Thread.sleep(500);
						
						finished = thr.getState().compareTo(Thread.State.TERMINATED) == 0;
					}
					outputDocument = thr.getData();
					
				} catch (InterruptedException e) {
				} catch (Exception e) {
					//do exception handling here
				}
				//IData out = context.invoke("pub.flow", "debugLog", inputDocument);
			}

            // *** Disconnect ***
            context.disconnect();
            
            System.out.println("\nOutputs:\n");

		    IDataCursor odc =  outputDocument.getCursor();

		    String sName   = IDataUtil.getString(odc, "CustName");
		    String sCity   = IDataUtil.getString(odc, "CustCity");
		    String sStreet = IDataUtil.getString(odc, "CustStreet");

	        System.out.printf ("got %s, %s, %s", sName, sCity, sStreet);

        } catch (ServiceException e) {
            System.err.println(e);
        }
        System.exit(0);
    }
}

