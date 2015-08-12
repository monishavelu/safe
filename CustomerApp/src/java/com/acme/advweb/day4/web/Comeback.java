package com.acme.advweb.day4.web;

import static com.acme.advweb.day4.web.SetJSon.twelve;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
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
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.OutboundEvent;
import setgame.Cards;
import setgame.GameEngine;
import setgame.SetCheck;

@WebServlet("/Cards/comeback")
public class Comeback extends HttpServlet{

   @Inject private ParticipantList participants;
    
    @Override
    protected void doGet (HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException {
        
         int s = Integer.parseInt(req.getParameter("uid"));
         
        resp.setContentType(MediaType.APPLICATION_JSON);
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter pw = resp.getWriter();
        ArrayList<Cards> copy = (ArrayList<Cards>)SetJSon.twelve.clone();
        System.out.println("sixe -- >"+copy.size());
      int a,b,c;
      a=Integer.parseInt(req.getParameter("id1"));
      b=Integer.parseInt(req.getParameter("id2"));
      c=Integer.parseInt(req.getParameter("id3"));
     
              Cards d = new Cards();
              d= d.getCard(a);
              Cards e =new Cards();
              e = e.getCard(b);
              Cards f = new Cards(); 
              f = f.getCard(c);
              
      if(GameEngine.Compare(d,e,f))
      {
          JsonArrayBuilder builder = Json.createArrayBuilder();
          JsonObjectBuilder job = Json.createObjectBuilder();
     
          for(Cards card:SetJSon.twelve){
            if (card.getHashkey() == a || card.getHashkey() == b  ||card.getHashkey() == c) {
              copy.remove(card);
            }
          }
//          SetJSon.twelve.remove(d);
//          SetJSon.twelve.remove(e);
//          SetJSon.twelve.remove(f);
          System.out.println("sixe -- >"+copy.size());
          copy.add(SetCheck.Cardstobesolved.remove(0));
          copy.add(SetCheck.Cardstobesolved.remove(1));
          copy.add(SetCheck.Cardstobesolved.remove(2));
          
          SetJSon.twelve = (ArrayList<Cards>)copy.clone();
          
              for (Cards o: copy)
        {
           
            job.add("img_url","cards/"+o.getHashkey()+".gif");
            job.add("img_id",o.getHashkey().toString());
            builder.add(job.build());
        }
             //pw.println(builder.build().toString());
               OutboundEvent data  = new OutboundEvent.Builder()
                .data(JsonArray.class,builder.build())
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .name(Integer.toString(s))
                .build();
                 participants.send(data);
                 //System.out.println(data);
      }
      else
      { 
           JsonArrayBuilder builder = Json.createArrayBuilder();
            JsonObjectBuilder job = Json.createObjectBuilder();
          
           for (Cards o: copy)
        {
           
            job.add("img_url","cards/"+o.getHashkey()+".gif");
            job.add("img_id",o.getHashkey().toString());
            builder.add(job.build());
        }
         // JsonObjectBuilder job = Json.createObjectBuilder();
            //job.add("Result","false");
           // pw.println(builder.build().toString());
              OutboundEvent data  = new OutboundEvent.Builder()
                .data(JsonArray.class,builder.build())
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .name(Integer.toString(s))
                .build();
              participants.send(data);
              //System.out.println(data);
      }  
       resp.setStatus(HttpServletResponse.SC_OK);
     
//      pw.println(d.getCard(a));
//             pw.println(d.getCard(b));
//             pw.println(d.getCard(c));    
}
}
