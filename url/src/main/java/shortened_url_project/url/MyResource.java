package shortened_url_project.url;

import javax.ws.rs.Consumes;

//import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import shortened_url_project.business.UrlBusiness;
import shortened_url_project.model.UrlModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("url")
public class MyResource {

	UrlBusiness urlBusiness = new UrlBusiness();
      
    @Path("getshortered")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getShorteredUrl(String url) {
		UrlModel urlmodel = new UrlModel();
    	urlmodel = urlBusiness.createNewShortenedUrl(url);  	
        return urlmodel.getShortnerUrl();
	}
	
	@Path("getoriginal")
	@POST    
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getOriginalUrl(String url) {  
		UrlModel urlmodel = new UrlModel();
    	urlmodel = urlBusiness.getUrlModelByShortenedUrl(url);  
        return urlmodel.toString();
    }
}
