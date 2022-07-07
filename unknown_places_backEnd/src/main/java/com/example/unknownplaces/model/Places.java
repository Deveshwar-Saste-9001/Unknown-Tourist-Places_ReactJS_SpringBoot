package com.example.unknownplaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Places {
	@Id
	@GeneratedValue
	private int placeid;
	private String placename;
	private String placecity;
	private String address;
	private String placestate;
	private String placecountry;
	private int pincode;
	private String placedesc;
	private int roadcondition;
	private int safetylevel;
	private int touritlevel;
	private double latitude;
	private double longtitude;
	private int adventurelevel;
	private int costlevel;
	private boolean hostelpresent;
	private boolean guesthousepresent;
	private boolean campingspot;
	private boolean hotelpresent;
	private boolean otherpresent;
	private String placeimage;
	private boolean isVerified;
	private String category;
	private String request;
	
	public int getPlaceid() {
		return placeid;
	}
	public void setPlaceid(int placeid) {
		this.placeid = placeid;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public String getPlacecity() {
		return placecity;
	}
	public void setPlacecity(String placecity) {
		this.placecity = placecity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlacestate() {
		return placestate;
	}
	public void setPlacestate(String placestate) {
		this.placestate = placestate;
	}
	public String getPlacecountry() {
		return placecountry;
	}
	public void setPlacecountry(String placecountry) {
		this.placecountry = placecountry;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPlacedesc() {
		return placedesc;
	}
	public void setPlacedesc(String placedesc) {
		this.placedesc = placedesc;
	}
	public int getRoadcondition() {
		return roadcondition;
	}
	public void setRoadcondition(int roadcondition) {
		this.roadcondition = roadcondition;
	}
	public int getSafetylevel() {
		return safetylevel;
	}
	public void setSafetylevel(int safetylevel) {
		this.safetylevel = safetylevel;
	}
	public int getTouritlevel() {
		return touritlevel;
	}
	public void setTouritlevel(int touritlevel) {
		this.touritlevel = touritlevel;
	}
	public int getAdventurelevel() {
		return adventurelevel;
	}
	public void setAdventurelevel(int adventurelevel) {
		this.adventurelevel = adventurelevel;
	}
	public int getCostlevel() {
		return costlevel;
	}
	public void setCostlevel(int costlevel) {
		this.costlevel = costlevel;
	}
	public boolean isHostelpresent() {
		return hostelpresent;
	}
	public void setHostelpresent(boolean hostelpresent) {
		this.hostelpresent = hostelpresent;
	}
	public boolean isGuesthousepresent() {
		return guesthousepresent;
	}
	public void setGuesthousepresent(boolean guesthousepresent) {
		this.guesthousepresent = guesthousepresent;
	}
	public boolean isCampingspot() {
		return campingspot;
	}
	public void setCampingspot(boolean campingspot) {
		this.campingspot = campingspot;
	}
	public boolean isHotelpresent() {
		return hotelpresent;
	}
	public void setHotelpresent(boolean hotelpresent) {
		this.hotelpresent = hotelpresent;
	}
	public boolean isOtherpresent() {
		return otherpresent;
	}
	public void setOtherpresent(boolean otherpresent) {
		this.otherpresent = otherpresent;
	}
	public String getPlaceimage() {
		return placeimage;
	}
	public void setPlaceimage(String placeimage) {
		this.placeimage = placeimage;
	}
	
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Places(int placeid, String placename, String placecity, String address, String placestate,
			String placecountry, int pincode, String placedesc, int roadcondition, int safetylevel, int touritlevel,
			double latitude, double longtitude, int adventurelevel, int costlevel, boolean hostelpresent,
			boolean guesthousepresent, boolean campingspot, boolean hotelpresent, boolean otherpresent,
			String placeimage, boolean isVerified, String category, String request) {
		super();
		this.placeid = placeid;
		this.placename = placename;
		this.placecity = placecity;
		this.address = address;
		this.placestate = placestate;
		this.placecountry = placecountry;
		this.pincode = pincode;
		this.placedesc = placedesc;
		this.roadcondition = roadcondition;
		this.safetylevel = safetylevel;
		this.touritlevel = touritlevel;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.adventurelevel = adventurelevel;
		this.costlevel = costlevel;
		this.hostelpresent = hostelpresent;
		this.guesthousepresent = guesthousepresent;
		this.campingspot = campingspot;
		this.hotelpresent = hotelpresent;
		this.otherpresent = otherpresent;
		this.placeimage = placeimage;
		this.isVerified = isVerified;
		this.category = category;
		this.request = request;
	}
	public Places() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
}
