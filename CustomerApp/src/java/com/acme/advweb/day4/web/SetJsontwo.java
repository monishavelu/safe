/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.advweb.day4.web;

import setgame.SetCheck;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.OutboundEvent;
import setgame.Cards;
import setgame.SetCheck;

/**
 *
 * @author A0136582b
 */
@WebServlet("/Cards/two")
public class SetJsontwo  extends HttpServlet{
    
         @Inject private ParticipantList participants;
    @Override
    protected void doGet (HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException {
        
        
   
         JsonArray js = null;
      
       // Cards c = null;
//       for(int i=0;i<12;i++)
//       {
//       //  = twelve.get(i);
//      //  js.add(builder.add("#",c.getHashkey()).build());
        JsonArrayBuilder builder = Json.createArrayBuilder();
//     0   JsonObject jObj = builder.add("#",c.getHashkey()).build();
//        js.add(jObj);
//        //js.
//        System.out.println(jObj.toString());
//        builder = null;
//       }
        PrintWriter pw =  resp.getWriter();
       
     
       ArrayList<Cards> Balance =  SetCheck.Cardstobesolved;
       ArrayList<Cards> Replacement =  SetJSon.twelve;
      
           Replacement.add(9,Balance.remove(0));
            Replacement.add(10,Balance.remove(1));
             Replacement.add(11,Balance.remove(2));
       
             
             
       
       for (Cards c: Replacement)
        {
            JsonObjectBuilder jobj = Json.createObjectBuilder();
            jobj.add("img_url","cards/"+c.getHashkey()+".gif");
            jobj.add("img_id",c.getHashkey().toString());
            builder.add(jobj.build());
        }
        //pw.println((builder.build().toString()));
       // pw.println(builder.build().toString());
        //return (builder.build());
      // System.out.println(builder.build().toString());
        
           
        OutboundEvent data  = new OutboundEvent.Builder()
                .data(JsonArray.class,builder.build())
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build();
      
        participants.send(data);
        //System.out.println(data);
        
       resp.setStatus(HttpServletResponse.SC_OK);
        
    }
    
}

