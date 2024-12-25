package clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import InvoicePayment.InvoicePaymentGrpc;
import InvoicePayment.CreateRequest;
import InvoicePayment.CreateResponse;

import java.util.concurrent.TimeUnit;
// import java.util.logging.Level;
// import java.util.logging.Logger;

public class InvoiceClient { 
    private ManagedChannel channel;
    private InvoicePaymentGrpc.InvoicePaymentBlockingStub blockingStub;
    // private InvoicePaymentGrpc.InvoicePaymentStub asyncStub;
    public InvoiceClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext());
        blockingStub = InvoicePaymentGrpc.newBlockingStub(channel);
        // asyncStub = InvoicePaymentGrpc.newStub(channel);
    }
    public InvoiceClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    public CreateResponse CreateRequest(CreateRequest invoiceRequest){
        CreateResponse InvoiceReply = null;

        try{
            InvoiceReply = blockingStub.barcodeGenerate(invoiceRequest);
        }
        catch (StatusRuntimeException e){
            System.out.println(e.getStatus());
        }
        return InvoiceReply;
    }

}