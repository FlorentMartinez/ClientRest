package capteurs;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.mapper.Mapper;
import obix.Obj;
import obix.io.ObixDecoder;

public class CapteurPresence {
	
	public CapteurPresence(){};
	
	public String getPresence(Client client, String URL) {
		
		Builder request = client.target(URL).request();
		
		request.header("X-M2M-Origin", "admin:admin");	
		request.header("Accept", "application/xml");
		
		Response response = request.get();
		
		
		
		//System.out.println(response.getLastModified());
		String resp_string = response.readEntity(String.class);		
		
		Mapper mapper = new Mapper();
		ContentInstance resp = (ContentInstance) mapper.unmarshal(resp_string);
		
		
		Obj obj = ObixDecoder.fromString(resp.getContent());
		
		String presence = obj.get("presence").toString();
		
		
		return obj.get("presence").toString();
		
				
	}
}

