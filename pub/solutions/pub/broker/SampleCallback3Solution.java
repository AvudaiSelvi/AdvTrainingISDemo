/* -*- mode: java -*-
 *	 
 * SampleCallback3Solution.java
 */ 

import COM.activesw.api.client.*;

public class SampleCallback3Solution implements BrokerCallback
{
    public int count;
    public int num_to_receive;

    public SampleCallback3Solution(int num_to_receive)
    {
	count = 0;
	this.num_to_receive = num_to_receive;
    }

    /**
     *  method to handle the Information Broker event callbacks.
     */

    public boolean handleBrokerEvent(BrokerClient client,
				     BrokerEvent event,
				     Object client_data)
    {
	int pub_count;

	try {

	    pub_count = event.getIntegerField("count");

	    ++count;
	    System.out.println("Event #"+count+
			       " received with count="+pub_count);
	    
	    if (num_to_receive < count) {
		client.stopMainLoop();
	    }

	} catch (BrokerException ex) {
	    System.out.println("unexpected BrokerException received\n"+ex);
	    return true;
	}

	return false;
    }
}
