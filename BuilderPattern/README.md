BUILDER 


Separate the construction of a complex object from its representation so that the same construction process can create different representations. 

Here are the key consequences of the Builder pattern:
1. It lets you vary a product's internal representation. The Builder object provides the director with an abstract interface for constructing the product. The interfacelets the builder hide the representation and internal structure of the
   product. It also hides how the product gets assembled. Because the product is constructed through an abstract interface, all you have to do to change the product's internal representation is define a new kind of builder.


2. It isolates code for construction and representation. The Builder pattern improves modularity by encapsulating the way a complex object is constructed and represented. Clients needn't know anything about the classes that define the
   product's internal structure; such classes don't appear in Builder's interface.


3. It gives you finer control over the construction process. Unlike creational patterns that construct products in one shot, the Builder pattern constructs the product step by step under the director's control. Only when the product
   is finished does the director retrieve it from the builder. Hence the Builder interface reflects the process of constructing the product more than other creational patterns. This gives you finer control over the construction process and consequently the internal structure of the resulting product.