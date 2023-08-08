               			Generated Java Client
_____________________________________________________________________

   The Java code produced by the Developer(TM) demonstrates the most 
   common uses of the webMethods client API and should serve as a good 
   starting point for your own development.

   Make sure you have installed a fully functional JDK and have an 
   Integration Server running. 
   
   If you are running the client with a different JVM, other than the one that
   was installed with the Integration Server or Developer, please refer to the 
   'Building a Java Client' section in the Developer Users Guide for the files
   required in the JVM for the Java client to support signed libraries:
   
   Next, make sure that your classpath consists of at least the following:
   
         .:[COMMON DIR]/lib/wm-isclient.jar:[COMMON DIR]/lib/ext/mail.jar
   
      
   If the client wants to connect to the Integration Server using the 
   Secure Socket Layer (SSL), you need to
      
   (1) uncomment line context.setSecure(true).
   (2) edit authentication certificates information and uncomment
       line context.setSSLCertificates(cert, privKey, cacert).
   (3) Make sure that your classpath also consists of:
          [COMMON DIR]/lib/ext/enttoolkit.jar   
     
   The client will attempt to connect to the Integration Server you used 
   when generating the client. If you require a different Integration Server,
   please modify as indicated in the source. Also, for protected services, edit
   the source to supply your username and password.
   
   You will be prompted to supply values for all input variables of type 
   string, string list and string table at the command line.
   
   Compile the generated Java classes:

        > javac *.java

   You may then invoke a generated service 'svcName' by typing

        > java [svcName]

   
   The results of the service are displayed on standard output.

