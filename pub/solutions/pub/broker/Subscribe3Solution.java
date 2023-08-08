/* -*- mode: java -*-
 *
 * Subscribe3Solution
 */ 

import COM.activesw.api.client.*;
 
class Subscribe3Solution
{
    static String broker_host = "localhost";
    static String broker_name = null;
    static String client_group = "sample";
    static String event_type_name = "Sample::SimpleEvent";

    static int num_to_receive = 10;  

    public void run(String args[])
    {
	BrokerClient c;
	BrokerEvent e;
	boolean can_subscribe;
	SampleCallback3Solution sample_callback = new SampleCallback3Solution(num_to_receive);

	/* Create a client */
	try {
	    c = new BrokerClient(broker_host, broker_name,
				 null, client_group,
				 "Subscriber Sample #3",null);
	} catch (BrokerException ex) {
	    System.out.println("Error on create client\n"+ex);
	    return;
	}

	/* Check if can subscribe */
	try {
	    can_subscribe = c.canSubscribe(event_type_name);
	} catch (BrokerException ex) {
	    System.out.println("Error on check for can subscribe\n"+ex);
	    return;
	}
	if (can_subscribe == false) {
	    System.out.println("Cannot subscribe to event");
	    System.out.println(event_type_name + ".");
	    System.out.println("Make sure it is loaded");
	    System.out.println("in the broker and permission");
	    System.out.println("is given to subscribe to it in");
	    System.out.println("the" + client_group + " client group.");
	    return;
	}

	/* Register callback */
	try {
	    c.registerCallback(sample_callback,null);
	} catch (BrokerException ex) {
	    System.out.println("Error on registering callback\n"+ex);
	    return;
	}

	/* Open the subscription */
	try {
	    c.newSubscription(event_type_name, null);
	} catch (BrokerException ex) {
	    System.out.println("Error on create subscription\n"+ex);
	    return;
	}

	/* Do main loop */
	try {
	    BrokerClient.mainLoop();
	} catch (BrokerException ex) {
	    System.out.println("Error on dispatch\n"+ex);
	    return;
	}
  
	/* Cancel the subscription */
	try {
	    c.cancelSubscription(event_type_name, null);
	} catch (BrokerException ex) {
	    System.out.println("Error on canceling subscription\n"+ex);
	    return;
	}

	/* Cancel callbacks */
	try {
	    c.cancelCallbacks();
	} catch (BrokerException ex) {
	    System.out.println("Error on canceling callbacks\n"+ex);
	    return;
	}
  
	/* Clean up */
	try {
	    c.destroy();
	} catch (BrokerException ex) {
	    System.out.println("Error on client destroy\n"+ex);
	    return;
	}

	return;
    }

    public static void main(String args[])
    {
	new Subscribe3Solution().run(args);
    }
}
