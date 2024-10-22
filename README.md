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

## Example Setup within Gradle

For the below setup, a grade.properties file with the `gpr.user` and `gpr.token` values will be your GitHub username along with a classic GitHub token with read permissions. This will allow you to pull the package to your project.

```groovy
repositories {
    mavenCentral()
     maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/henrylamb/object-generation-java")
       credentials {
            username = project.findProperty("gpr.user") as String ?: System.getenv("GITHUB_ACTOR")
             password = project.findProperty("gpr.token") as String ?: System.getenv("GITHUB_TOKEN")
         }
     }
}
```



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

## Example of Generation on Rails being used with Spring Boot

```java

@Component
public class ApplicationGenerator {
    private Client client;

    @Autowired
    private Environment environment;

    private String password;

    private String baseUrl;

    public ApplicationGenerator() {}

    @PostConstruct
    public void init() {
        // Fetch the properties from application.properties using the environment object
        password = environment.getProperty("multiple.password");
        baseUrl = environment.getProperty("base.url");

        this.client = Client.newDefaultClient(password, baseUrl);
    }


    public Application sendApplication(Application application) throws Exception {

        Definition def = this.getDefinition(application.getJob().getModelResume(), application.getJob().getModelCoverLetter(), application.getCustomResume(), application.getCoverLetter(), ModelType.GPT3);

        // Construct the prompt by combining the model and user resume and cover letter details
        String prompt = String.format(
                "Model Resume:\n%s\n\nModel Cover Letter:\n%s\n\nUser Resume:\n%s\n\nUser Cover Letter:\n%s",
                application.getJob().getModelResume(),
                application.getJob().getModelCoverLetter(),
                application.getCustomResume(),
                application.getCoverLetter()
        );

        Response response = client.sendRequest(prompt, def);

        // Deserialize into a CodeTest object using the generic method

        return JsonUtils.deserialize(response.getData(), Application.class);
    }

    public Definition getDefinition(String modelResume, String modelCoverLetter, String userResume, String userCoverLetter, String model) throws Exception {
        String systemPromptGeneral = "You are an expert HR hiring manager with a keen eye for identifying top candidates. You will be reviewing a candidate's resume and cover letter for a specific job position. Evaluate the candidate's qualifications, work experience, and how well they align with the job requirements.";

        // Create the Definition object for the application evaluation
        Definition applicationEvaluation = new Definition();
        applicationEvaluation.setType(DataType.OBJECT);
        applicationEvaluation.setInstruction("Thoroughly analyze the candidate's application materials (resume and cover letter). Assess their suitability for the job based on their qualifications, experience, and alignment with the job's requirements. Provide an in-depth evaluation.");
        applicationEvaluation.setSystemPrompt(systemPromptGeneral);
        applicationEvaluation.setModel(model);

        Map<String, Definition> properties = new HashMap<>();

        // Define property for averageScore
        Definition averageScoreDef = new Definition();
        averageScoreDef.setType(DataType.NUMBER);
        averageScoreDef.setInstruction("Evaluate the overall quality and professionalism of the candidate's resume and cover letter. Provide a score between 1 and 100, where 1 indicates poor quality and 100 indicates exceptional quality.");
        properties.put("averageScore", averageScoreDef);

        // Define property for extenuatingCircumstancesScore
        Definition extenuatingCircumstancesScoreDef = new Definition();
        extenuatingCircumstancesScoreDef.setType(DataType.NUMBER);
        extenuatingCircumstancesScoreDef.setInstruction("Assess if the candidate mentions any special circumstances or challenges that may have affected their career path. Rate their ability to present these circumstances effectively, using a score between 1 and 100.");
        properties.put("extenuatingCircumstancesScore", extenuatingCircumstancesScoreDef);

        // Define property for trajectoryScore
        Definition trajectoryScoreDef = new Definition();
        trajectoryScoreDef.setType(DataType.NUMBER);
        trajectoryScoreDef.setInstruction("Evaluate the candidate's career growth and progression over time. Consider whether their career trajectory suggests upward mobility and potential. Provide a score between 1 and 100.");
        properties.put("trajectoryScore", trajectoryScoreDef);

        // Define property for pedigreeScore
        Definition pedigreeScoreDef = new Definition();
        pedigreeScoreDef.setType(DataType.NUMBER);
        pedigreeScoreDef.setInstruction("Assess the quality of the candidate's educational background, certifications, and professional affiliations. Provide a score between 1 and 100 based on how prestigious or relevant these credentials are for the role.");
        properties.put("pedigreeScore", pedigreeScoreDef);

        // Define property for academicAchievementScore
        Definition academicAchievementScoreDef = new Definition();
        academicAchievementScoreDef.setType(DataType.NUMBER);
        academicAchievementScoreDef.setInstruction("Evaluate the candidate's academic achievements, such as degrees, honors, and other scholastic accomplishments. Score between 1 and 100 based on their relevance and excellence.");
        properties.put("academicAchievementScore", academicAchievementScoreDef);

        // Define property for matchJobDescriptionScore
        Definition matchJobDescriptionScoreDef = new Definition();
        matchJobDescriptionScoreDef.setType(DataType.NUMBER);
        matchJobDescriptionScoreDef.setInstruction("Assess how closely the candidate's skills, experience, and qualifications match the job description. Provide a score between 1 and 100, where a higher score indicates a better match.");
        properties.put("matchJobDescriptionScore", matchJobDescriptionScoreDef);

        // Define property for pastExperienceScore
        Definition pastExperienceScoreDef = new Definition();
        pastExperienceScoreDef.setType(DataType.NUMBER);
        pastExperienceScoreDef.setInstruction("Evaluate the relevance and quality of the candidate's past work experience. Focus on roles, responsibilities, and achievements that are pertinent to the job they are applying for. Provide a score between 1 and 100.");
        properties.put("pastExperienceScore", pastExperienceScoreDef);

        // Define property for yearsOfExperience
        Definition yearsOfExperienceDef = new Definition();
        yearsOfExperienceDef.setType(DataType.NUMBER);
        yearsOfExperienceDef.setInstruction("Provide the number of years of relevant work experience the candidate has. Consider experience that directly relates to the job requirements.");
        properties.put("yearsOfExperience", yearsOfExperienceDef);

        // Define property for review
        Definition reviewDef = new Definition();
        reviewDef.setType(DataType.STRING);
        reviewDef.setInstruction("Provide a detailed review of the candidate's qualifications, experience, and overall fit for the role. Highlight strengths, any areas for improvement, and a summary of how well the candidate meets the job's requirements.");
        properties.put("review", reviewDef);

        // Set properties to the applicationEvaluation Definition
        applicationEvaluation.setProperties(properties);

        return applicationEvaluation;
    }


}

```

## Conclusion

This guide provides a structured approach to creating a Java client for sending JSON definitions via HTTP POST requests. Ensure to adapt the `Definition` class and example usage to fit your specific API requirements and data structures.
