package hello;



public class TimeWorked {
	
	private String user;
	
	private String timeWorked;
	
	private String reassignmentCount;
	
	private String trackingConfigurationItem;
	
	private String activity;
	
	private String restricted;
	
	private String updated;
	
	private String number;
	
	private String title;
	
	private String subcause;
	
	private String caller;
	
	private String resolvedBy;
	
	private String state;
	
	private String configurationItem;
	
	private String appleKeywords;
	
	private String created;
	
	private String assignmentGroup;
	
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTimeWorked() {
		return timeWorked;
	}

	public void setTimeWorked(String timeWorked) {
		this.timeWorked = timeWorked;
	}

	public String getReassignmentCount() {
		return reassignmentCount;
	}

	public void setReassignmentCount(String reassignmentCount) {
		this.reassignmentCount = reassignmentCount;
	}

	public String getTrackingConfigurationItem() {
		return trackingConfigurationItem;
	}

	public void setTrackingConfigurationItem(String trackingConfigurationItem) {
		this.trackingConfigurationItem = trackingConfigurationItem;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	
	
	public String getRestricted() {
		return restricted;
	}

	public void setRestricted(String restricted) {
		this.restricted = restricted;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubcause() {
		return subcause;
	}

	public void setSubcause(String subcause) {
		this.subcause = subcause;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAppleKeywords() {
		return appleKeywords;
	}

	public void setAppleKeywords(String appleKeywords) {
		this.appleKeywords = appleKeywords;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getAssignmentGroup() {
		return assignmentGroup;
	}

	public void setAssignmentGroup(String assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}

	public TimeWorked() {}

	public String getConfigurationItem() {
		return configurationItem;
	}

	public void setConfigurationItem(String configurationItem) {
		this.configurationItem = configurationItem;
	}

	public TimeWorked(String user, String timeWorked, String reassignmentCount, String trackingConfigurationItem,
			String activity, String restricted, String updated, String number, String title, String subcause,
			String caller, String resolvedBy, String state, String configurationItem, String appleKeywords,
			String created, String assignmentGroup) {
		
		this.user = user;
		this.timeWorked = timeWorked;
		this.reassignmentCount = reassignmentCount;
		this.trackingConfigurationItem = trackingConfigurationItem;
		this.activity = activity;
		this.restricted = restricted;
		this.updated = updated;
		this.number = number;
		this.title = title;
		this.subcause = subcause;
		this.caller = caller;
		this.resolvedBy = resolvedBy;
		this.state = state;
		this.configurationItem = configurationItem;
		this.appleKeywords = appleKeywords;
		this.created = created;
		this.assignmentGroup = assignmentGroup;
	}

	@Override
	public String toString() {
		return "TimeWorked [user=" + user + ", timeWorked=" + timeWorked + ", reassignmentCount=" + reassignmentCount
				+ ", trackingConfigurationItem=" + trackingConfigurationItem + ", activity=" + activity
				+ ", restricted=" + restricted + ", updated=" + updated + ", number=" + number + ", title=" + title
				+ ", subcause=" + subcause + ", caller=" + caller + ", resolvedBy=" + resolvedBy + ", state=" + state
				+ ", configurationItem=" + configurationItem + ", appleKeywords=" + appleKeywords + ", created="
				+ created + ", assignmentGroup=" + assignmentGroup + "]";
	}

	
	

	
	

}
