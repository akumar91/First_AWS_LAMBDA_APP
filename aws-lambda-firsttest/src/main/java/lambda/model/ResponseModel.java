package lambda.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Widget")
public class ResponseModel {

    String name;
    double price;

    public ResponseModel(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public ResponseModel() {

    }

    @DynamoDBHashKey(attributeName="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBHashKey(attributeName="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
