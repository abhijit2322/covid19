package com.abhijit.covid19map.model;

/**
 * Description for IndiaData
 */
public class IndiaData {
 
   /** Property id */
   int id;
 
   /** Property type */
   String type;
 
   /** Property totalcase */
   String totalcase;
 
   /** Property activecase */
   String activecase;
 
   /** Property deaths */
   String deaths;
 
   /** Property cured */
   String cured;
 
   /**
    * Constructor
    */
   public IndiaData() {
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
    * Gets the type
    */
   public String getType() {
      return this.type;
   }
 
   /**
    * Sets the type
    */
   public void setType(String value) {
      this.type = value;
   }
 
   /**
    * Gets the totalcase
    */
   public String getTotalcase() {
      return this.totalcase;
   }
 
   /**
    * Sets the totalcase
    */
   public void setTotalcase(String value) {
      this.totalcase = value;
   }
 
   /**
    * Gets the activecase
    */
   public String getActivecase() {
      return this.activecase;
   }
 
   /**
    * Sets the activecase
    */
   public void setActivecase(String value) {
      this.activecase = value;
   }
 
   /**
    * Gets the deaths
    */
   public String getDeaths() {
      return this.deaths;
   }
 
   /**
    * Sets the deaths
    */
   public void setDeaths(String value) {
      this.deaths = value;
   }
 
   /**
    * Gets the cured
    */
   public String getCured() {
      return this.cured;
   }
 
   /**
    * Sets the cured
    */
   public void setCured(String value) {
      this.cured = value;
   }
}