package com.dromero.paymentservice;

import com.dromero.paymentservice.entities.Client;
import com.dromero.paymentservice.entities.Payment;
import com.dromero.paymentservice.repositories.ClientRepository;
import com.dromero.paymentservice.repositories.PaymentRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentController {

    @Inject
    ClientRepository clientrepository;

    @Inject
    PaymentRepository paymentRepository;

    @GET
    @Path("{name}")
    public Response getClientByname(@PathParam("name") String  name) {

        Client client = clientrepository.findByName(name);
        Jsonb jsonb = JsonbBuilder.create();
        return Response
                .status(Response.Status.OK)
                .entity(jsonb.toJson(client))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @POST
    public Response createPayment(Payment payment){
        System.out.println("Este es el pago" + payment.toString());
        System.out.println(payment.getNameClient());
        Client resclient = clientrepository.findByName(payment.getNameClient());
        System.out.println(resclient.getName());
        if(resclient != null && resclient.isActive()){
            System.out.println("Pago Aceptado" + payment.toString());
            paymentRepository.create(payment);
            Jsonb jsonb = JsonbBuilder.create();
            return Response
                    .status(Response.Status.OK)
                    .entity(jsonb.toJson(payment))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        System.out.println("Pago Rechazado" + payment.toString());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Payment not accepted")
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @Path("/new")
    @POST
    public Response createClients(Client client){
        clientrepository.create(client);
        Jsonb jsonb = JsonbBuilder.create();
        return Response
                .status(Response.Status.OK)
                .entity(jsonb.toJson(client))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
