package advTrainingISDemo.solution.codeSvc;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-04-02 03:42:35 CEST
// -----( ON-HOST: sagbase

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void fastJavaMapper (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fastJavaMapper)>> ---
		// @sigtype java 3.5
		// [i] record:1:required InSKUList
		// [i] - field:0:required qty
		// [o] record:1:required OutSKUList
		// [o] - field:0:required QUANTITY
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			// InSKUList
			IData[]	InSKUList = IDataUtil.getIDataArray( pipelineCursor, "InSKUList" );
			if ( InSKUList != null)
			{
				IData[]	OutSKUList = new IData[InSKUList.length];
				for ( int i = 0; i < InSKUList.length; i++ )
				{
					IDataCursor InSKUListCursor = InSKUList[i].getCursor();
					OutSKUList[i] = IDataFactory.create();
					IDataCursor OutSKUListCursor = OutSKUList[i].getCursor();
						String	qty = IDataUtil.getString( InSKUListCursor, "qty" );
						IDataUtil.put( OutSKUListCursor, "QUANTITY", qty );
					InSKUListCursor.destroy();
				}
				IDataUtil.put( pipelineCursor, "OutSKUList", OutSKUList );
			}
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}
}

