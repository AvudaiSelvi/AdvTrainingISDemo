package advTrainingISDemo.demo;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2009-01-12 08:07:17 EST
// -----( ON-HOST: trainhost.softwareag.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.Thread;
// --- <<IS-END-IMPORTS>> ---

public final class utilities

{
	// ---( internal utility methods )---

	final static utilities _instance = new utilities();

	static utilities _newInstance() { return new utilities(); }

	static utilities _cast(Object o) { return (utilities)o; }

	// ---( server methods )---




	public static final void milliSleep (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(milliSleep)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required milliSeconds
		  int m = 100;
		  // pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  String  milliSeconds = IDataUtil.getString( pipelineCursor, "milliSeconds" );
		  try {
		    m = Integer.parseInt(milliSeconds);
		  } catch (Exception e) {
		  }
		
		  try {
		    Thread.sleep(m);
		  } catch (Exception e) {
		  }
		
		  pipelineCursor.destroy();
		
		// pipeline
		// --- <<IS-END>> ---

                
	}



	public static final void nanoTime (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(nanoTime)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required nanoTime
		
		// pipeline
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "nanoTime", String.valueOf(System.nanoTime()) );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

