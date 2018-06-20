package lambda.handler;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.model.RequestModel;
import lambda.model.ResponseModel;

public class GetWidgetHandler implements RequestHandler<RequestModel, ResponseModel> {

    @Override
    public ResponseModel handleRequest(RequestModel request, Context context) {

        // Create a connection to DynamoDB
        // using default client since our lambda function will be running
        // in AWS so we do not need credentials
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDB dynamoDB = new DynamoDB(client);

        // Get a reference to the Widget table
        Table table = dynamoDB.getTable("Widget");

        // Get our item by ID
        Item item = table.getItem("name", request.getName());
        if(item != null) {
            System.out.println(item.toJSONPretty());

            // Return a new Widget object
            return new ResponseModel(item.getString("name"), item.getDouble("price"));
        }
        else {
            return new ResponseModel();
        }
    }
}
