/* -*- mode: java -*-
 *
 * SampleCallback4.java
 */ 

import COM.activesw.api.client.*;

public class SampleCallback4 implements BrokerCallback
{
  public int count;

  public SampleCallback4()
  {
    count = 0;
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
	// get the count field
        pub_count = event.???(???);
    } catch (BrokerException ex) {
        System.out.println("Error on getting count field\n"+ex);
        return true;
    }

    ++count;
    System.out.println("Event #"+count+
                       " received with count="+pub_count);

    return true;
  }
}

