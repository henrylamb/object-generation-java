package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.objectGeneration.client.Client;
import org.objectGeneration.client.Response;
import org.objectGeneration.jsonSchema.Definition;
import org.objectGeneration.jsonSchema.JsonUtils;
import org.objectGeneration.jsonSchema.ModelType;
import org.objectGeneration.testingLite.CodeProcessor;
import org.objectGeneration.testingLite.CodeTest;
import org.objectGeneration.testingLite.DefaultCodeProcessor;
import org.objectGeneration.testingLite.ProcessResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;
import static org.objectGeneration.testingLite.Assumptions.WorkingAssumption;
import static org.objectGeneration.testingLite.EvaluateGrade.evaluateGrade;
import static org.objectGeneration.testingLite.EvaluateGrade.printResult;
import static org.objectGeneration.testingLite.TestComparison.testComparison;
import static org.objectGeneration.testingLite.TestConstructor.testConstructor;
import static org.objectGeneration.testingLite.TestingLiteUtils.getModerateTesting;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class TestClient {
    private static final Logger logger = Logger.getLogger(TestClient.class.getName());
    static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        try {
            // Create a client using environment variables
            // Access environment variables
            String password = dotenv.get("MULTIPLE_PASSWORD");
            String baseUrl = dotenv.get("BASE_URL");
            Client client = Client.newDefaultClient(password, baseUrl);

            // Create the code processor
            CodeProcessor processor = new DefaultCodeProcessor();
            String codePath = "src/main/java/org/objectGeneration/client/RequestSender.java";

            // Read the code file into a String using Scanner
            StringBuilder code = new StringBuilder();
            try (Scanner scanner = new Scanner(new File(codePath))) {
                while (scanner.hasNextLine()) {
                    code.append(scanner.nextLine()).append("\n");
                }
            }

            String codeString = code.toString();

            // Construct the definition and code with assumed utility method TestConstructor
            ProcessResult processResult = testConstructor(WorkingAssumption, codePath, ModelType.GPT4, processor);
            Definition definition = processResult.getCodeQA();
            //System.out.println("Definition: " + definition);
            // Send request using the client
            Response response = client.sendRequest(codeString, definition);

            //System.out.println("Response: " + response.getData());

            // Convert the response to JSON string


            // Deserialize into a CodeTest object using the generic method
            CodeTest testVal = JsonUtils.deserialize(response.getData(), CodeTest.class);

            // Compare values using a utility method for testing
            if (!testComparison(testVal, getModerateTesting())) {
                logger.severe(String.format(
                        "Failed to meet all the requirements. Expected Minimum: %s | Got: %s",
                        getModerateTesting().print(),
                        testVal.print()
                ));
                logger.severe("Recommendation on how to fix this test: " + testVal.getReview().getFeedback());
            }

            // Evaluate the grade based on the test result
            String grade = evaluateGrade(testVal);

            // Print the results in verbose mode
            printResult(grade, testVal, false);

        } catch (IOException | InterruptedException e) {
            logger.severe("Error during the client test: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}