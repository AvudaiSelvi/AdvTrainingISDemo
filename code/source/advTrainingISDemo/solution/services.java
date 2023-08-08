package advTrainingISDemo.solution;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-04-02 03:42:58 CEST
// -----( ON-HOST: sagbase

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class services

{
	// ---( internal utility methods )---

	final static services _instance = new services();

	static services _newInstance() { return new services(); }

	static services _cast(Object o) { return (services)o; }

	// ---( server methods )---




	public static final void myCustomJ (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(myCustomJ)>> ---
		// @sigtype java 3.5
		// [i] field:0:required BuyerIdentity
		// [o] field:0:required BuyerIdentity
		// [o] field:0:required ErrorMsg
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	BuyerIdentity = IDataUtil.getString( pipelineCursor, "BuyerIdentity" );
		
		if ("Fox".equalsIgnoreCase(BuyerIdentity)) {
			IDataUtil.put( pipelineCursor, "BuyerIdentity", BuyerIdentity.toUpperCase() + " INDUSTRIES" );
		} else {
			String ErrorMsg = "Invalid Buyer: " + BuyerIdentity;
			IDataUtil.put( pipelineCursor, "ErrorMsg", ErrorMsg );
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void myCustomJ_IDataMap (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(myCustomJ_IDataMap)>> ---
		// @sigtype java 3.5
		// [i] field:0:required BuyerIdentity
		// [o] field:0:required BuyerIdentity
		// [o] field:0:required ErrorMsg
		// pipeline
		IDataMap myPipeline = new IDataMap(pipeline);
			String	BuyerIdentity = myPipeline.getAsString("BuyerIdentity");
		
		if ("Fox".equalsIgnoreCase(BuyerIdentity)) {
			myPipeline.put( "BuyerIdentity", BuyerIdentity.toUpperCase() + " INDUSTRIES" );
		} else {
			String ErrorMsg = "Invalid Buyer: " + BuyerIdentity;
			myPipeline.put( "ErrorMsg", ErrorMsg );
		}
		
			
		// --- <<IS-END>> ---

                
	}
}

