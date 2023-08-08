/* -*- mode: java -*-
 *
 * Subscribe2Solution.java
 * 
 */ 

import COM.activesw.api.client.*;
 
class Subscribe2Solution
{
  static String broker_host = "localhost";
  static String broker_name = null;
  static String client_group = "sample";
  static int num_to_receive = 10;  

  public void run(String args[])
  {
    BrokerClient c;
    BrokerEvent e;
    boolean can_subscribe;
    SampleCallback2Solution sample_callback = new SampleCallback2Solution();
    int count;

    /* Create a client */
    try {
        c = new BrokerClient(broker_host, broker_name,
                             null, client_group,
                             "Subscriber Sample #2",null);
    } catch (BrokerException ex) {
        System.out.println("Error on create client\n"+ex);
        return;
    }

    /* Check if can subscribe */
    try {
        can_subscribe = c.canSubscribe("Sample::SimpleEvent");
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
        c.registerCallback(sample_callback,null);
    } catch (BrokerException ex) {
        System.out.println("Error on registering callback\n"+ex);
        return;
    }

    /* Open the subscription */
    try {
        c.newSubscription("Sample::SimpleEvent",null);
    } catch (BrokerException ex) {
        System.out.println("Error on create subscription\n"+ex);
        return;
    }

    /* Do dispatch loop */
    count = 1;
    while(count <= num_to_receive) {
        try {
            BrokerClient.dispatch(-1);
        } catch (BrokerException ex) {
            System.out.println("Error on dispatch\n"+ex);
            return;
        }
        ++count;
    }
  
    /* Cancel the subscription */
    try {
        c.cancelSubscription("Sample::SimpleEvent",null);
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

    public static void main(String args[]) {
	new Subscribe2Solution().run(args);
    }
}
