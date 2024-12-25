package grpctest;

import org.testng.Assert;
import org.testng.annotations.Test;
// import org.testng.Assert;
import clients.InvoiceClient;
import InvoicePayment.CreateRequest;
import InvoicePayment.CreateResponse;

public class myFirstGrpcClass {
    @Test
    public void testGRPC(){
        CreateRequest invoiceRequest = CreateRequest
            .newBuilder()
            .setFlag(true)
            .build();
        InvoiceClient invoiceClient = new InvoiceClient("localhost", 8089);
        CreateResponse InvoicePayment = invoiceClient.CreateRequest(invoiceRequest);
        Assert.assertEquals(InvoicePayment.getAllFields(), "Success");
    }
}
