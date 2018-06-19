package lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lambda.model.RequestModel;
import lambda.model.ResponseModel;

public class GetWidgetHandler implements RequestHandler<RequestModel, ResponseModel> {

    @Override
    public ResponseModel handleRequest(RequestModel request, Context context) {
        return new ResponseModel(request.getName(), "Hooray! your first lambda Code " + request.getName());
    }
}
