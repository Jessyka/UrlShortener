package shortened_url_project.business;

import java.net.URL;
import java.util.Date;
import java.util.Random;

import javax.persistence.NoResultException;

import shortened_url_project.dao.UrlDao;
import shortened_url_project.model.UrlModel;

public class UrlBusiness {

	UrlModel urlmodel;
	UrlDao urlDao;
	String static final urlbase = "http://shortenedurl.com/";

	public UrlBusiness() {
		urlDao = new UrlDao();
	}
	
	public UrlBusiness(UrlDao dao) {
		urlDao = dao; 
	}
	
	//Get UrlModel by shortened Url
	public UrlModel getUrlModelByShortenedUrl(String url) {
		if(urlValidator(url)) {
			try {
				String urlId = url.replace(urlbase,"");

				urlDao.openCurrentSession();
				UrlModel urlmodel = urlDao.getByShortened(Long.parseInt(urlId));
				urlDao.closeCurrentSession();

				return urlmodel;
			}catch (NoResultException nre){
				return null;
			}
		}else
			return null;
	}
	
	///Get UrlModel by original Url
	public UrlModel getUrlModelByOriginalUrl(String url) {
		
		if(urlValidator(url)) {
			
			try {
				urlDao.openCurrentSession();
				UrlModel urlmodel = urlDao.getByOriginalUrl(url);
				urlDao.closeCurrentSession();
				return urlmodel;
			}catch (NoResultException nre){
				return null;
			}
			
		}else
			return urlmodel;
	}

	//Insert new UrlModel
	public UrlModel createNewShortenedUrl(String originalurl) {		
		if(urlValidator(originalurl)) {
			
			UrlModel auxiliarModel = new UrlModel(); 
			
			//Validar se a URL já existe no banco de dados.
			try {
				urlDao.openCurrentSession();
				auxiliarModel = urlDao.getByOriginalUrl(originalurl);
				urlDao.closeCurrentSession();
				
				//Check if Url already exists
				if(originalurl.compareTo(auxiliarModel.toString()) == 0) {				
					return auxiliarModel;	
				}
				
			}catch (NoResultException nre){
				
				//Create new Url record.
				urlmodel = new UrlModel();		
				urlmodel.setOriginalUrl(originalurl);		
				urlmodel.setDate(new Date());			
				
				urlDao.openCurrentSessionwithTransaction();
				urlDao.persist(urlmodel);
				urlDao.closeCurrentSessionwithTransaction();
			
				return urlmodel;
			}
			
			return null;
		}else
			return null;
	}
	
	private boolean urlValidator(String urlString) {
		try
	    {
	        URL url = new URL(urlString);
	        url.toURI();
	        return true;
	    } catch (Exception ex)
	    {
	        return false;
	    }
	}

}
