/* -*- mode: java -*-
 *
 * Subscribe2.java
 * 
 */ 

import COM.activesw.api.client.*;
 
class Subscribe2
{
    static String broker_host = "???";
    static String broker_name = "???";
    static String client_group = "???";
    static String event_type_name = "Sample::SimpleEvent";


    static int num_to_receive = 10;  

    public void run(String args[])
    {
	BrokerClient c;
	BrokerEvent e;
	boolean can_subscribe;
	SampleCallback2 sample_callback = new SampleCallback2();
	int count;

	/* Create a client */
	try {
	    c = new ??? (???);
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

	/* Open the subscription */
	try {
	    c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on create subscription\n"+ex);
	    return;
	}

	/* Do dispatch loop */
	count = 1;
	while(count <= num_to_receive) {
	    try {
		// dispatch events, wait forever for an event to arrive
		BrokerClient.???(???);
	    } catch (BrokerException ex) {
		System.out.println("Error on dispatch\n"+ex);
		return;
	    }
	    ++count;
	}
  
	/* Cancel the subscription */
	try {
	    c.??? (???);
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
	    c.???(???);
	} catch (BrokerException ex) {
	    System.out.println("Error on client destroy\n"+ex);
	    return;
	}

	return;
    }

    public static void main(String args[]) {
	new Subscribe2().run(args);
    }
}
