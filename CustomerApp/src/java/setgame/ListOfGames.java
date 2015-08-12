/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Singleton
@WebServlet("/List")
public class ListOfGames extends HttpServlet {
    
//	@GET
//	@Path("/query")
//	public Response getUsers(
//		@QueryParam("from") int from,
//		@QueryParam("to") int to,
//		@QueryParam("orderBy") List<String> orderBy) {
//
//		return Response
//		   .status(200)
//		   .entity("getUsers is called, from : " + from + ", to : " + to
//			+ ", orderBy" + orderBy.toString()).build();
//
//	}

    
  HashMap<Integer, ArrayList<Cards>> something = new HashMap<Integer, ArrayList<Cards>>();
  public static ArrayList<Integer> uids = new ArrayList<Integer>();
   
    
  
   @Override
    protected void doGet (HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException {
        
 //       makelist(uid);
//        makelist();
//        makelist();
       
        Integer uid = null;
        PrintWriter pw = resp.getWriter();
       for (Integer uuid : uids) {
           pw.println("<a href=/customer/Cards/List?"+uuid +">"+ uuid +"</a></br>");
       }
    }
  
    public void makelist(int uid)
    {
        uids.add(uid);
        something.put(uid, SetCheck.CardsOnTableMethod());
    }
    
     public ArrayList<Cards> getInstance(int uid)
     {
         return something.get(uid);
     }
}
