package com.calsoft.nexenta.vcp;

public class ExcelPojoForSikuliGUI {
	
	
	private String step;
	private String action;
	private String imageFilepath;
	private String input;
	private String testCaseID;
	private String description;
	private String sectionName;
	private String includeInSuite;
	private String iteration;
	
	public ExcelPojoForSikuliGUI(String step, String action,String imageFilepath, String input) {
		super();
		this.step = step;
		this.action = action;
		this.imageFilepath = imageFilepath;
		this.input = input;
	}
	
	public ExcelPojoForSikuliGUI(String testCaseID,String description, String sectionName,String includeInSuite, String iteration) {
		super();
		this.testCaseID = testCaseID;
		this.description=description;
		this.sectionName=sectionName;
		this.includeInSuite = includeInSuite;
		this.iteration = iteration;
	}

	public String getImageFilepath() {
		return imageFilepath;
	}

	public void setImageFilepath(String imageFilepath) {
		this.imageFilepath = imageFilepath;
	}

	public String getTestCaseID() {
		return testCaseID;
	}

	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getIncludeInSuite() {
		return includeInSuite;
	}

	public void setIncludeInSuite(String includeInSuite) {
		this.includeInSuite = includeInSuite;
	}

	public String getIteration() {
		return iteration;
	}

	public void setIteration(String iteration) {
		this.iteration = iteration;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPropertyValue() {
		return imageFilepath;
	}

	public void setPropertyValue(String propertyValue) {
		this.imageFilepath = propertyValue;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
}

