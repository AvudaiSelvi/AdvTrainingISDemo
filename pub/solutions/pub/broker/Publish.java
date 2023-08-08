/* -*- mode: java -*-
 *
 * Publish.java
 */ 

import COM.activesw.api.client.*;

class Publish
{
    // these settings would typically be read from a .properties file.
    // yopu can find their values in the broker configuration file 
    // Simple.adl

    // *** a.) insert correct values here

    static String broker_host = "???"; // host where broker is running
    static String broker_name = "???"; // name of the broker
    static String client_group = "???"; // name of the client group
    static String event_type_name = "???"; // name of the event

    // configuration options of the program

    static int num_to_publish = 100;  /* Number of events to publish */
    static int delay = 100;   /* milliseconds to wait between publish calls */

    public void run(String args[]) {

	BrokerClient c;
	BrokerEvent e;
	boolean can_publish;
	int count;

	/* Create a client */
	try {

	    // *** b.) create a new BrokerClient

	    c = new BrokerClient(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on create client\n"+ex);
	    return;
	}

	/* Create the event */
	try {

	    // *** c.) create a new broker event

	    e = new BrokerEvent(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on create event\n"+ex);
	    return;
	}

	/* Check publish permission */
	try {

	    // *** d.) test if we can publish documents on the connection 'c'

	    can_publish = c.???(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on check for can publish\n"+ex);
	    return;
	}
 
	if (can_publish == false) {
	    System.out.println("Cannot publish event" + event_type_name);
	    System.out.println("Make sure it is loaded in the broker and");
	    System.out.println("permission is given to publish it in the");
	    System.out.println(client_group + " client group.");
	    return;
	}

	/* Publish */
	for (count = 0; count < num_to_publish; count++) {

	    if (0 < count) {
		try {
		    Thread.sleep(delay); 
		} catch (Exception ex) {
		}
	    }

	    try {

		// *** set e.) the integer Field named "count" to the
		// current value of count

		e.???(???);

		// *** f.) publish the event 'e' on the connection 'c'.

		c.???(???);

	    } catch (BrokerException ex) {
		System.out.println("unexpected broker error\n" + ex);
		return;
	    }

	    System.out.println("Published event with count=" + count);

	}

	try {

	    // *** g.) destroy the connection 'c'

	    c.???(???);

	} catch (BrokerException ex) {
	    System.out.println("Error on client destroy\n"+ex);
	    return;
	}
  
	return;

    }

    public static void main(String args[])
    { 
	new Publish().run(args);
    }
}
