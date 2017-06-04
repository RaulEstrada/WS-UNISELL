package uniovi.miw.unisell.model;

import java.io.Serializable;

public class EditCompanyData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CompanyData companyData;
	
	public Long getId() {
		return id;
	}
	
	public EditCompanyData setId(Long id) {
		this.id = id;
		return this;
	}
	
	public CompanyData getCompanyData() {
		return companyData;
	}
	
	public EditCompanyData setCompanyData(CompanyData companyData) {
		this.companyData = companyData;
		return this;
	}
}
