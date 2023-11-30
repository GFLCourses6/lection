Most common JSON processing libraries in Java:
-Jackson;
-Gson;
-json-io;
-Genson;

The aim of this project is Jackson Library;

***Jackson***
Json namespace provides functionality for serializing to and deserializing from JavaScript Object Notation (JSON):
-Serialization is the process of converting the state of an object, that is, the values of its
properties, into a form that can be stored or transmitted;
//ObjectMapper.writeValueAsString() is used to serialize Object to JSON string;

-Deserialization is transforming the data from a file or stream back into an object to be used in your application.
This can be binary data or structured data like JSON and XML. Deserialization is the opposite of serialization, which
transforms objects into byte streams or structured text;
//ObjectMapper.readValue() is used to deserialize JSON string to Java Object;

-JSON objects are easy to read and write;

-A tree structure JSON data:
    *Navigated;
    *Analyzed;
    *Or modified;

-Provides immutable object models for JSON object and array structures;

-Uses builder patterns to create these object models from scratch:
    -JsonObjectBuilder to create models of JSON objects;
    -JsonArrayBuilder to create models of JSON arrays;
    -Or from an input source (such as InputStream or Reader) using the interface JsonReader.

***json-io***
-Json-io is a simple Java library to serialize/deserialize JSON;

//JsonWriter.objectToJson() is used to serialize Object to JSON.
//JsonReader.jsonToJava() is used to deserialize Json to Java Object.

