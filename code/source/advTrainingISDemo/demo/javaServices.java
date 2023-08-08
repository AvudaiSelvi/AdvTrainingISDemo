package advTrainingISDemo.demo;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2009-03-27 15:53:33 CET
// -----( ON-HOST: VMTVO02

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSName;
import com.wm.app.b2b.server.ServiceThread;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void checkServiceThread (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkServiceThread)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required serviceThread
		// [o] field:0:required status
		 
		// pipeline   
		IDataCursor pipelineCursor = pipeline.getCursor();
			ServiceThread serviceThread = (ServiceThread)IDataUtil.get( pipelineCursor, "serviceThread" );
			String status = null;
		
		//Attempt to see if thread is running or finished
					try
					{
						//check to see if serviceThread is executing
						//returns null if not done, output if done
						IData output = serviceThread.getData();
						status ="ok";
					}
					catch ( Exception e ) 
					{
						status = "kaput";
						//implement custom exception handling here.
					}
		
		IDataUtil.put( pipelineCursor, "status", status );
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void doThreadInvoke (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(doThreadInvoke)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required target
		// [o] object:0:required serviceThread
		// get pipeline input data
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	target = IDataUtil.getString( pipelineCursor, "target" );
		
		//construct a new service thread
		ServiceThread st = null;
		
		//try to clone the pipeline and execute threaded invoke
		//this protects the thread invoke from subsequent changes to the pipeline
		IData clonedPipe = IDataFactory.create();
		try
		{
			clonedPipe = IDataUtil.deepClone(pipeline);	
		
			//do threaded invoke
			st = Service.doThreadInvoke(NSName.create(target),clonedPipe);
		}
		catch (Exception e)
		//catch any errors in cloning or creating the new service thread
		{
			System.out.println("Error executing myDoThreadInvoke:"+e.toString());
			//insert your meaningful exception handling here
		}
		//put the service thread back in the pipeline
		IDataUtil.put(pipelineCursor,"serviceThread",st);
		
		//always destroy your cursor when done using it
		pipelineCursor.destroy();
		
		 
		// --- <<IS-END>> ---

                
	}



	public static final void getServiceThreadResults (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServiceThreadResults)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required serviceThread
		// [o] record:0:required outputPipeline
		// pipeline
		  IDataCursor pipelineCursor = pipeline.getCursor();
		  ServiceThread serviceThread = (ServiceThread)IDataUtil.get( pipelineCursor, "serviceThread");
		  IData	outputPipeline;
		
		  //Attempt to get the output from the thread
		  try {
		    //block and wait for serviceThread to finish execution
		    outputPipeline = serviceThread.getData();
		  } catch ( Exception e ) {
		    //implement custom exception handling here.
		    throw(new ServiceException(e));
		  }
		
		  IDataUtil.put( pipelineCursor, "outputPipeline", outputPipeline );
		  pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void invokeDebugLog (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(invokeDebugLog)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required message
		try
		{
			Service.doInvoke( "pub.flow", "debugLog", pipeline);
		}
		catch( Exception e) 
		{	
		
		/*
		implement meaningful exception handling here
		If the invoke fails, this service will not report a failure 
		unless you throw a ServiceException here 
		*/
		
		}
		// --- <<IS-END>> ---

                
	}



	public static final void navigateIData (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(navigateIData)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required root
		// [i] - record:1:required nestedArray
		// [i] -- field:1:required nestedStringArray
		// [o] field:0:required message
  String message = null;
  
  IDataCursor pipelineCursor = pipeline.getCursor();

  IData	root = IDataUtil.getIData( pipelineCursor, "root" );
  if ( root != null)  {
    IDataCursor rootCursor = root.getCursor();

    // i.nestedArray
    IData[]  nestedArray = IDataUtil.getIDataArray( rootCursor, "nestedArray" );
    if ( nestedArray != null)  {
      for ( int i = 0; i < nestedArray.length; i++ )  {
	IDataCursor nestedArrayCursor = nestedArray[i].getCursor();
	String[]  nestedStringArray = IDataUtil.getStringArray( nestedArrayCursor, "nestedStringArray" );
	int salength = nestedStringArray.length;
	message = nestedStringArray[salength-1];
	nestedArrayCursor.destroy();
      }
    }
    rootCursor.destroy();
  }

  IDataUtil.put( pipelineCursor, "message", message );
  pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void recursiveClient (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(recursiveClient)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required depth
		// get pipeline input data  
		IDataCursor pipelineCursor = pipeline.getCursor();
			Integer depth = new Integer(IDataUtil.getString( pipelineCursor, "depth" ));
			int d = depth.intValue();
		pipelineCursor.destroy();
		
		if (d > 0)
		{
		    System.out.println("Invoking serviceClient with depth of:"+d);
			d--;
			//recursive invoke of serviceClient
			// create an input IData pipeline
			IData input = IDataFactory.create();
			IDataCursor inputCursor = input.getCursor();
			IDataUtil.put( inputCursor, "depth", ""+d);
			inputCursor.destroy();
		
			try{
				Service.doInvoke( "demo.javaServices", "recursiveClient", input );
			}catch( Exception e)
			{	//implement meaningful exception handling here
			}
		}
		else
		{ System.out.println("Max deepest invoke: depth = 0"); }
		
		// --- <<IS-END>> ---

                
	}
}

