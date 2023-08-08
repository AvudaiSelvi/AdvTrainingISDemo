/* -*-mode: java -*-
 *
 * Subscribe1.java
 */ 

import COM.activesw.api.client.*;
 
class Subscribe1
{
    // *** a.) find the correct values. They must match the values
    // specified in the Publisher1.java

    static String broker_host = "???";
    static String broker_name = "???";
    static String client_group = "???";
    static String event_type_name = "???";

    static int num_to_receive = 10; 

    public void run(String args[])
    {
	BrokerClient c;
	BrokerEvent e;
	boolean can_subscribe;
	int count; 
	int pub_count;

	/* Create a client */
	try {

	    // *** b.) create a new broker client

	    c = new BrokerClient();

	} catch (BrokerException ex) {
	    System.out.println("Error on create client\n"+ex);
	    return;
	}

	/* Check if can subscribe */
	try {

	    // *** c.) test if subscription is possible on the event type

	    can_subscribe = c.???(???);

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

	/* Make a subscription */
	try {

	    // *** d.) create a new subscription for the event type

	    c.???(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on create subscription\n"+ex);
	    return;
	}

	/* Loop getting events */
	count = 1;
	while(count <= num_to_receive) {
	    try {

		// *** e.) get the next Event from the broker. Wait for infinte time
		// for an event to happen.

		e = c.???(???);

	    } catch (BrokerException ex) {
		System.out.println("Error on getting event\n"+ex);
		return;
	    }

	    try {

		// *** f.) get the integer field named "count" from the event 'e'
 
		pub_count = e.???(???);

	    } catch (BrokerException ex) {
		System.out.println("Error on getting count field\n"+ex);
		return;
	    }
	    System.out.println("Event #"+count+
			       " received with count="+pub_count);
  
	    ++count;
	}
  
	/* Cancel the subscription */
	try {

	    // *** g.) cancel the subscription. 

	    c.???(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on canceling subscription\n"+ex);
	    return;
	}
  
	/* Clean up */
	try {
	    
	    // *** h.) destroy the broker client

	    c.???(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on client destroy\n"+ex);
	    return;
	}

	return;
    }
    
    public static void main(String args[]) {
	new Subscribe1().run(args);
    }
}

