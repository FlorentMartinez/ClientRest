package capteurs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.mapper.Mapper;
import obix.Obj;
import obix.io.ObixDecoder;
import obix.io.ObixEncoder;

public class Lampe {
	
	public Lampe(){};
	
	public String getEtat(Client client, String URL) {
		
		Builder request = client.target(URL).request();
		
		request.header("X-M2M-Origin", "admin:admin");	
		request.header("Accept", "application/xml");
		
		Response response = request.get();
		
		
		
		//System.out.println(response.getLastModified());
		String resp_string = response.readEntity(String.class);		
		
		Mapper mapper = new Mapper();
		ContentInstance resp = (ContentInstance) mapper.unmarshal(resp_string);
		
		
		Obj obj = ObixDecoder.fromString(resp.getContent());
		
		String presence = obj.get("Etat").toString();
		
		
		return obj.get("Etat").toString();
	}
		
		
	public void eteindre(Client client, String URL){
		
	
		Builder request = client.target(URL).request();
		
		request.header("X-M2M-Origin", "admin:admin");	
		request.header("Content-Type", "application/xml;ty=4");
		
		
		String body = "<m2m:cin xmlns:m2m='http://www.onem2m.org/xml/protocols'><cnf>message</cnf><con>&lt;obj&gt;&lt;str name=&quot;appId&quot; val=&quot;LAMPE_102&quot;/&gt;&lt;str name=&quot;category&quot; val=&quot;lumiere &quot;/&gt;&lt;str name=&quot;état&quot; val=&quot;éteinte&quot;/&gt;&lt;/obj&gt;</con></m2m:cin>";
		
		
		Entity.entity(body, "application/xml;ty=4");
		
		Response response = request.post(Entity.entity(body, "application/xml;ty=4"));
		
	}
	
	public void allumer(Client client, String URL){
	
	Builder request = client.target(URL).request();
	
	request.header("X-M2M-Origin", "admin:admin");	
	request.header("Content-Type", "application/xml;ty=4");
	
	
	String body = "<m2m:cin xmlns:m2m='http://www.onem2m.org/xml/protocols'><cnf>message</cnf><con>&lt;obj&gt;&lt;str name=&quot;appId&quot; val=&quot;LAMPE_102&quot;/&gt;&lt;str name=&quot;category&quot; val=&quot;lumiere &quot;/&gt;&lt;str name=&quot;état&quot; val=&quot;allumée&quot;/&gt;&lt;/obj&gt;</con></m2m:cin>";
	
	Entity.entity(body, "application/xml;ty=4");
	
	Response response = request.post(Entity.entity(body, "application/xml;ty=4"));
	
				
	}
}
