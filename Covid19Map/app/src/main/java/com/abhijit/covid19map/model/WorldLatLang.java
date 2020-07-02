package com.abhijit.covid19map.model;
/**
 * Description for WorldLatLang
 */
public class WorldLatLang {
 
   /** Property id */
   int id;
 
   /** Property city */
   String city;
 
   /** Property lat */
   String lat;
 
   /** Property lng */
   String lng;
 
   /** Property country */
   String country;
 
   /** Property ios2 */
   String iso2;
 
   /**
 * @return the iso2
 */
public String getIso2() {
	return iso2;
}

/**
 * @param iso2 the iso2 to set
 */
public void setIso2(String iso2) {
	this.iso2 = iso2;
}

/**
    * Constructor
    */
   public WorldLatLang() {
   }
 
   /**
    * Gets the id
    */
   public int getId() {
      return this.id;
   }
 
   /**
    * Sets the id
    */
   public void setId(int value) {
      this.id = value;
   }
 
   /**
    * Gets the city
    */
   public String getCity() {
      return this.city;
   }
 
   /**
    * Sets the city
    */
   public void setCity(String value) {
      this.city = value;
   }
 
   /**
    * Gets the lat
    */
   public String getLat() {
      return this.lat;
   }
 
   /**
    * Sets the lat
    */
   public void setLat(String value) {
      this.lat = value;
   }
 
   /**
    * Gets the lng
    */
   public String getLng() {
      return this.lng;
   }
 
   /**
    * Sets the lng
    */
   public void setLng(String value) {
      this.lng = value;
   }
 
   /**
    * Gets the country
    */
   public String getCountry() {
      return this.country;
   }
 
   /**
    * Sets the country
    */
   public void setCountry(String value) {
      this.country = value;
   }
 
   
}