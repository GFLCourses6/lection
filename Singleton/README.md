SINGLETON 


Ensure a class only has one instance, and provide a global point of access to it. 

The Singleton pattern has several benefits:



1. Controlled access to sole instance. Because the Singleton class encapsulates its sole instance, it can have strict control over how and when clients access it.


2. Reduced name space. The Singleton pattern is an improvement over global variables. It avoids polluting the name space with global variables that store sole instances.


3. Permits refinement of operations and representation. The Singleton class may be subclassed, and it's easy to configure an application with an instance of this extended class. You can configure the application with an instance of the class you need at runtime.


4. Permits a variable number of instances. The pattern makes it easy to change your mind and allow more than one instance of the Singleton class. Moreover, You can use the same approach to control the number of instances that
   the application uses. Only the operation that grants access to the Singleton instance needs to change.


5. More flexible than class operations.