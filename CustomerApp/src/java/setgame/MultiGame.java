/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



// @GET
//    @Path("{cid}")   
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
//    public Response get(@PathParam("cid") Integer custId
//            , @HeaderParam("Accept") String acceptHeader)

@WebServlet("/multigame")
public class MultiGame extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        
     
       
       GameInstance gi = new GameInstance();
       JsonArray js = null;
        
       
        response.setContentType(MediaType.APPLICATION_JSON);
        response.setStatus(HttpServletResponse.SC_OK);
        ArrayList<Cards> twelve =  GameInstance.getgame(id);
        JsonArrayBuilder builder = Json.createArrayBuilder();

        PrintWriter pw =  response.getWriter();
       
        for (Cards c: twelve)
        {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("img_url","cards/"+c.getHashkey()+".gif");
            job.add("img_id",c.getHashkey().toString());
            builder.add(job.build());
        }

        pw.println((builder.build().toString()));
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
