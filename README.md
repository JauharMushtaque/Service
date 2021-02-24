# Service

Creating a bound service

To create a bound service, implement the onBind() callback method to return an IBinder that defines the interface for communication with the service. 
Other application components can then call bindService() to retrieve the interface and begin calling methods on the service.

Multiple clients can bind to the service simultaneously. 
When a client is done interacting with the service, it calls unbindService() to unbind.
When there are no clients bound to the service, the system destroys the service.

In case of Local Binding, Beginning with Android 5.0 (API level 21), the system throws an exception if you call bindService () with an implicit intent.


