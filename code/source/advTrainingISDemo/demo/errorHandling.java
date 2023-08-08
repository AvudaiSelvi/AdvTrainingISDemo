package advTrainingISDemo.demo;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2009-03-27 16:55:34 CET
// -----( ON-HOST: VMTVO02

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class errorHandling

{
	// ---( internal utility methods )---

	final static errorHandling _instance = new errorHandling();

	static errorHandling _newInstance() { return new errorHandling(); }

	static errorHandling _cast(Object o) { return (errorHandling)o; }

	// ---( server methods )---




	public static final void myIntDivide (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(myIntDivide)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required num1
		// [i] field:0:required num2
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		String	num1 = IDataUtil.getString( pipelineCursor, "num1" );
		String	num2 = IDataUtil.getString( pipelineCursor, "num2" );
		
		int inum1 = Integer.parseInt(num1);
		int inum2 = Integer.parseInt(num2);
		
		if (inum1<0 || inum2 < 0) {
			throw new ServiceException("Demo: thrown Checked Exception (cannot divide negative numbers :-)");
		} else {
			int iresult = inum1 / inum2;
			IDataUtil.putInt(pipelineCursor, "result", iresult);
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

