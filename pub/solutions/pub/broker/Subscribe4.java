/* -*- mode: java -*-
 *	
 * Subscribe4.java
 * 
 */ 

import COM.activesw.api.client.*;
 
class Subscribe4
{
    static String broker_host = "???";
    static String broker_name = ???;
    static String client_group = "???";
    static String event_type_name = "???";

    static int num_to_receive = 10;  

    public void run(String args[])
    {
	BrokerClient c;
	BrokerEvent e;
	boolean can_subscribe;
	SampleCallback4 sample_callback = new SampleCallback4();
	String wait_obj = new String();

	/* Enable threaded callbacks */
	try {
	    BrokerClient.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on enabling threaded callbacks\n"+ex);
	    return;
	}

	/* Create a broker client */
	try {
	    c = new ???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on create client\n"+ex);
	    return;
	}

	/* Check if can subscribe */
	try {
	    can_subscribe = c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on check for can subscribe\n"+ex);
	    return;
	}

	if (can_subscribe == false) {
	    System.out.println("Cannot subscribe to event");
	    System.out.println("Sample::SimpleEvent.");
	    System.out.println("Make sure it is loaded");
	    System.out.println("in the broker and permission");
	    System.out.println("is given to subscribe to it in");
	    System.out.println("the" + client_group + " client group.");
	    return;
	}


	/* Register callback */
	try {
	    c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on registering callback\n"+ex);
	    return;
	}

	/* create a new subscription */
	try {
	    c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on create subscription\n"+ex);
	    return;
	}

	/* Wait for a while */
	while(sample_callback.count < num_to_receive) {
	    try {

		// note: this might skip some pub/sub's, so that we actually 
		// might process a few more events
 
		Thread.sleep(1000);

	    } catch (Exception ex) { 
	    }
	}
  
	/* Disable threaded callbacks */
	try {
	    BrokerClient.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on disabling threaded callbacks\n"+ex);
	    return;
	}

	/* Cancel the subscription */
	try {
	    c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on canceling subscription\n"+ex);
	    return;
	}

	/* Cancel callbacks */
	try {
	    c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on canceling callbacks\n"+ex);
	    return;
	}
  
	/* Clean up */
	try {
	    c.???();
	} catch (BrokerException ex) {
	    System.out.println("Error on client destroy\n"+ex);
	    return;
	}

	return;
    }

    public static void main(String args[]) {
	new Subscribe4().run(args);
    }
}

