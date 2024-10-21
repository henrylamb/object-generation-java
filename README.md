# Object Generation Java

<p align="center">
  <img src="https://i.postimg.cc/K8TjGy01/3-BD4-B9-DD-B0-B4-4033-B561-50-B5-CB6-A37-B0.jpg" alt="Alt text" width="200"/>
</p>

This module provides a client implementation for sending JSON definitions via HTTP POST requests. It is designed to be simple and easy to integrate into your existing Java projects.

To find more in-depth documentation please visit: [Multiple - Generation on Rails](https://go-multiple.com/)

## Prerequisites

- **Java Development Kit (JDK) 11 or higher**
- **An HTTP client library** (we'll use `java.net.http.HttpClient` introduced in Java 11)
- **Jackson library** for JSON serialization/deserialization
- **Dotenv library** for environment variable management (optional)

## Example Usage

Here's how you can use the `Client` to send a JSON definition.

```java
package client;

import org.objectGeneration.client.Client;
import org.objectGeneration.client.Response;
import org.objectGeneration.jsonSchema.Definition;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TestClient {
    private static final Logger logger = Logger.getLogger(TestClient.class.getName());
    static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        try {
            // Access environment variables
            String password = dotenv.get("MULTIPLE_PASSWORD");
            String baseUrl = dotenv.get("BASE_URL");
            Client client = Client.newDefaultClient(password, baseUrl);

            // Define a sample definition
            Definition definition = new Definition();
            definition.setType("Object");
            definition.setInstruction("Sample instruction for the definition.");

            Map<String, Definition> properties = new HashMap<>();
            Definition property1 = new Definition();
            property1.setType("String");
            property1.setInstruction("Description of property1");
            properties.put("property1", property1);

            Definition property2 = new Definition();
            property2.setType("Number");
            property2.setInstruction("Description of property2");
            properties.put("property2", property2);

            definition.setProperties(properties);

            // Send the request
            Response response = client.sendRequest("Your prompt here", definition);

            // Process response as needed
            System.out.printf("Response Status: %d%n", response.getStatus());
            System.out.printf("Response Data: %s%n", response.getData());

        } catch (Exception e) {
            logger.severe("Error during the client test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

## Environment Variables

To manage sensitive data like passwords and URLs, you can use environment variables with the Dotenv library.

```java
// Load environment variables
Dotenv dotenv = Dotenv.load();

// Access variables
String password = dotenv.get("MULTIPLE_PASSWORD");
String baseUrl = dotenv.get("BASE_URL");
```

### JSON Serialization/Deserialization

We use the Jackson library for handling JSON. Make sure to include it in your project dependencies.

```xml
<!-- For Maven projects, add this to your pom.xml -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.0</version>
</dependency>
```

## Conclusion

This guide provides a structured approach to creating a Java client for sending JSON definitions via HTTP POST requests. Ensure to adapt the `Definition` class and example usage to fit your specific API requirements and data structures.
