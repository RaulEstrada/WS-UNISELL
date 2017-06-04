package uniovi.miw.unisell.model;

import java.io.Serializable;

import uniovi.miw.unisell.data.LegalPersonIdDocumentType;
import uniovi.miw.unisell.data.LocationInfo;

public class CompanyData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name, description, idDocument;
	private LegalPersonIdDocumentType idDocumentType;
	private LocationInfo locationInfo = new LocationInfo();
	
	public String getName() {
		return name;
	}
	
	public CompanyData setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public CompanyData setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public String getIdDocument() {
		return idDocument;
	}
	
	public CompanyData setIdDocument(String idDocument) {
		this.idDocument = idDocument;
		return this;
	}
	
	public LegalPersonIdDocumentType getIdDocumentType() {
		return idDocumentType;
	}
	
	public CompanyData setIdDocumentType(LegalPersonIdDocumentType idDocumentType) {
		this.idDocumentType = idDocumentType;
		return this;
	}
	
	public LocationInfo getLocationInfo() {
		return locationInfo;
	}
	
	public CompanyData setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
		return this;
	}
	
}
