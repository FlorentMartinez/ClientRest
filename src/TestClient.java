import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.mapper.Mapper;
import obix.Obj;
import obix.io.ObixDecoder;

import javax.ws.rs.client.Invocation.Builder;

import capteurs.*;



public class TestClient {

	public static void main (String[] args) {
		Client client = ClientBuilder.newClient();
		
		CapteurPresence capteur_pres = new CapteurPresence();
		CapteurTemperature capteur_temp = new CapteurTemperature();
		Lampe lampe = new Lampe();
		
		//String presence = capteur_pres.getPresence(client, "http://localhost:8080/~/in-cse/in-name/PRES_SENSOR_102/DATA/la");
		
		//String temp = capteur_temp.getTemp(client,"http://localhost:8080/~/in-cse/in-name/TEMP_SENSOR_102/DATA/la");
		
		lampe.allumer(client, "http://localhost:8080/~/in-cse/cnt-636364854");
		


		//System.out.println(zz.);
		
		
		
	}
}
		
		/*Builder request = client.target("http://localhost:8080/~/in-cse/in-name/PRES_SENSOR_102/DATA/la").request();
		
		request.header("X-M2M-Origin", "admin:admin");	
		request.header("Accept", "application/xml");
		
		Response response = request.get();
		
		
		
		//System.out.println(response.getLastModified());
		String resp_string = response.readEntity(String.class);		
		
		Mapper mapper = new Mapper();
		
		ContentInstance resp = (ContentInstance) mapper.unmarshal(resp_string);
		
		
		Obj obj = ObixDecoder.fromString(resp.getContent());
		
		String presence = obj.get("presence").toString();
		
		
		if (presence.equals("false")) 
			System.out.println("Il n'y a personne");
		else if (presence.equals("true"))
			System.out.println("Il y a quelqu'un");
		else
			System.out.println("Erreur");
		
		//System.out.println("presence");
				
	}
}*/
