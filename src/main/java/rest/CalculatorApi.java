package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Model.Calculator;
import Service.CalculationService;

@Stateless
@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorApi {

    @EJB
    CalculationService calculationService;

    @POST//http://localhost:8080/IndvTask/api/api/calc
    @Path("/calc")
    public Response createCalculation(Calculator calculator) {
    	try {
            int result = calculationService.calculate(calculator);
            return Response.ok().entity("{\"Result\": " + result + "}").build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();//500
        }
    }


    @GET //http://localhost:8080/IndvTask/api/api/calculations
    @Path("/calculations")
    public Response getCalculation() {
            List<Calculator> calculations = calculationService.getAllCalculations();
            return Response.ok().entity(calculations).build();
        
    }
}
