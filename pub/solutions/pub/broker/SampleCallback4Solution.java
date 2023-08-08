/* -*- mode: java -*-
 *
 * SampleCallback4Solution.java
 */ 

import COM.activesw.api.client.*;

public class SampleCallback4Solution implements BrokerCallback
{
  public int count;

  public SampleCallback4Solution()
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
        pub_count = event.getIntegerField("count");
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

