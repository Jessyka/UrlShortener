package shortened_url_project.model;

import java.util.Date;

import javax.persistence.*;

import com.thoughtworks.xstream.XStream;

//import javax.persistence.Table;

@Entity
@Table(name = "redirecttable", schema = "public")
public class UrlModel {
	@Id 
	@Column(name="redirect_table_id")
	@GeneratedValue( strategy =  GenerationType.AUTO)
	private Long id;
	
	@Column(name = "url")
	private String original_url;
	
	@Column(name = "shortened_url")
	private String shortened_url;
	
	@Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date date_created;
	
	public Long getId() {
		return id;
	}
	
	public String getOriginalUrl() {
		return original_url;
	}
	
	public String getShortnerUrl() {
		return shortened_url;
	}
	
	public Date getDateCreated() {
		return date_created;
	}
	
	public void setOriginalUrl(String url) {
		original_url = url;
	}
	
	public void setShortenedUrl(String url) {
		shortened_url = url;
	}
	
	public void setDate(Date date) {
		date_created = date;		
	}
	
	@Override
	public String toString() {
		return original_url;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof UrlModel)) { 
            return false; 
        } 
		
		UrlModel urlObject = (UrlModel) object;
		
		if(this.original_url == urlObject.getOriginalUrl())
			return true;
		
		return false;
	}
	
	public String toXML() {
		return new XStream().toXML(this);
	}
	

}
