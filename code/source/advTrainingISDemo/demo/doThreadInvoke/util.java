package advTrainingISDemo.demo.doThreadInvoke;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-03-25 12:06:55 EDT
// -----( ON-HOST: TrainHost.webmethods.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSName;
import com.wm.app.b2b.server.ServiceThread;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

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
			st = Service.doThreadInvoke(invokedSvc.create(target),clonedPipe);
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
			ServiceThread serviceThread = (ServiceThread)IDataUtil.get( pipelineCursor, "serviceThread" );
			IData	outputPipeline = IDataFactory.create();
		
		//Attempt to get the output from the thread
					try
					{
						//block and wait for serviceThread to finish execution
						outputPipeline = serviceThread.getData();
					}
					catch ( Exception e ) 
					{
						//implement custom exception handling here.
					}
		
		IDataUtil.put( pipelineCursor, "outputPipeline", outputPipeline );
		pipelineCursor.destroy();
		 
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	//helper used for converting the target namespace string into an NSName object
	private static NSName invokedSvc = null;
	// --- <<IS-END-SHARED>> ---
}

