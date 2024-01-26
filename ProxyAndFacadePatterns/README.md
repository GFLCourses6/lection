FACADE 


Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use. 


The Facade pattern offers the following benefits:


1. It shields clients from subsystem components, thereby reducing the number of objects that clients deal with and making the subsystem easier to use. 




2. It promotes weak coupling between the subsystem and its clients. Often the components in a subsystem are strongly coupled. Weak coupling lets you vary the components of the subsystem without affecting its clients. Facades help layer a system and the dependencies between objects. They can eliminate complex or circular dependencies. This can be an important consequence when the client and the subsystem are implemented independently. Reducing compilation dependencies is vital in large software systems. You want to save time by minimizing recompilation when subsystem classes change. Reducing compilation dependencies with facades can limit the recompilation needed for a small change in an important subsystem. A facade can also simplify porting systems to other platforms, because it's less likely that building one subsystem requires building all others.




3. It doesn't prevent applications from using subsystem classes if they need to. Thus you can choose between ease of use and generality. 






PROXY


Provide a surrogate or placeholder for another object to control access to it.

Also known as Surrogate 

The Proxy pattern introduces a level of indirection when accessing an object. The additional indirection has many uses, depending on the kind of proxy:
1. A remote proxy can hide the fact that an object resides in a different address space. 




2. A virtual proxy can perform optimizations such as creating an object on demand.




3. Both protection proxies and smart references allow additional housekeeping tasks when an object is accessed. There's another optimization that the Proxy pattern can hide from the client. It's called copy-on-write, and it's related to creation on demand. Copying a large and complicated object can be an expensive operation. If the copy is never modified, then there's no need to incur this cost. Byusing a proxy to postpone the copying process, we ensure that we pay the price of copying the object only if it's modified. To make copy-on-write work, the subject must be reference counted. Copying the proxy will do nothing more than increment this reference count. Only when the client requests an operation that modifies the subject does the proxy actually copy it. In that case the proxy must also decrement the subject's reference count. When the reference count goes to zero, the subject gets deleted. Copy-on-write can reduce the cost of copying heavyweight subjects significantly.