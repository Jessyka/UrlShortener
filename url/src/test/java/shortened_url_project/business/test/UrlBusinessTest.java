package shortened_url_project.business.test;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import shortened_url_project.business.UrlBusiness;
import shortened_url_project.dao.UrlDao;
import shortened_url_project.model.UrlModel;

public class UrlBusinessTest {
	
	private UrlBusiness urlbus;
	
	@Mock
	private UrlDao urldao;
	 
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		urlbus = new UrlBusiness(urldao);
	}

	@Test
	public void getUrlModelByOriginalUrl_invalidUrl_nullValueExpected() {
		UrlModel model = new UrlModel();		
		model = urlbus.getUrlModelByOriginalUrl("");		
		
		assertTrue(model == null);	
	}
	
	@Test
	public void getUrlModelByShortenedUrl_invalidUrl_nullValueExpected() {
		UrlModel model = new UrlModel();		
		model = urlbus.getUrlModelByShortenedUrl("");		
		
		assertTrue(model == null);	
	}
	
	@Test
	public void createNewShortenedUrl_invalidUrl_nullValueExpected() {
		UrlModel model = new UrlModel();		
		model = urlbus.createNewShortenedUrl("");		
		
		assertTrue(model == null);	
	}
}
