/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.advweb.day4.web;

import com.acme.advweb.day4.web.ParticipantList;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.sse.OutboundEvent;
import setgame.Cards;
//import setgame.GameInstance;
import setgame.ListOfGames;
import setgame.SetCheck;
/**
 *
 * @author A0136582b
 */



@WebServlet("/Cards")
public class SetJSon extends HttpServlet
{
    
    
    static ArrayList<Cards> twelve = new ArrayList<Cards>();
    
    
    @Inject private ParticipantList participants;
    @Override
    protected void doGet (HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException {
        
         int s = Integer.parseInt(req.getParameter("uid"));
         ListOfGames l = new ListOfGames();
         l.makelist(1);
         l.makelist(2);
         l.makelist(3);
//         ArrayList<Cards> Al = l.getInstance(s);
         
        JsonArray js = null;
        resp.setContentType(MediaType.APPLICATION_JSON);
        resp.setStatus(HttpServletResponse.SC_OK);
        twelve = l.getInstance(s);
        
//        ListOfGames l = new ListOfGames();
//        twelve = ListOfGames.uids;
    
        JsonArrayBuilder builder = Json.createArrayBuilder();

        PrintWriter pw =  resp.getWriter();
       
        for (Cards c: twelve)
        {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("img_url","cards/"+c.getHashkey()+".gif");
            job.add("img_id",c.getHashkey().toString());
            builder.add(job.build());
        }

        
        //pw.println((builder.build().toString()));

         
        OutboundEvent data  = new OutboundEvent.Builder()
                .data(JsonArray.class,builder.build())
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .name(Integer.toString(s))
                .build();
        
        System.out.println(">> firing to game " + s);
      
        //participants.add();
        participants.send(data);
        System.out.println(data);
        
       resp.setStatus(HttpServletResponse.SC_OK);
        
    }
    
  
    
}
