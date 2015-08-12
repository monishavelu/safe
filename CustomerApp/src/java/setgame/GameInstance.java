
package setgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.json.JsonArrayBuilder;


public class GameInstance {
    
    static HashMap<Integer, ArrayList<Cards>> something = new HashMap<Integer, ArrayList<Cards>>();
    UUID uid = UUID.randomUUID();
    
    
    public GameInstance()
    {
    something.put(1,SetCheck.CardsOnTableMethod());
    something.put(2,SetCheck.CardsOnTableMethod());
    something.put(3,SetCheck.CardsOnTableMethod());
    }
    
    public static ArrayList<Cards> getgame (int id)
    {
        return something.get(id);
    }
     JsonArray js = null;
     JsonArrayBuilder builder = Json.createArrayBuilder();
}

