/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
 * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package weibo4j.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * A data class representing Basic user information element
 */
public class Geo extends WeiboResponse implements java.io.Serializable {

	private static final long serialVersionUID = -332738032648843482L;
	private String longitude;   
	private String latitude;  
	private String city;  
	private String province;  
	private String city_name;  
	private String province_name;  
	private String address;  
	private String pinyin;  
	private String more;
   /**
    * @return the longitude
    */
   public String getLongitude() {
      return longitude;
   }
   /**
    * @param longitude the longitude to set
    */
   public void setLongitude(String longitude) {
      this.longitude = longitude;
   }
   /**
    * @return the latitude
    */
   public String getLatitude() {
      return latitude;
   }
   /**
    * @param latitude the latitude to set
    */
   public void setLatitude(String latitude) {
      this.latitude = latitude;
   }
   /**
    * @return the city
    */
   public String getCity() {
      return city;
   }
   /**
    * @param city the city to set
    */
   public void setCity(String city) {
      this.city = city;
   }
   /**
    * @return the province
    */
   public String getProvince() {
      return province;
   }
   /**
    * @param province the province to set
    */
   public void setProvince(String province) {
      this.province = province;
   }
   /**
    * @return the city_name
    */
   public String getCity_name() {
      return city_name;
   }
   /**
    * @param city_name the city_name to set
    */
   public void setCity_name(String city_name) {
      this.city_name = city_name;
   }
   /**
    * @return the province_name
    */
   public String getProvince_name() {
      return province_name;
   }
   /**
    * @param province_name the province_name to set
    */
   public void setProvince_name(String province_name) {
      this.province_name = province_name;
   }
   /**
    * @return the address
    */
   public String getAddress() {
      return address;
   }
   /**
    * @param address the address to set
    */
   public void setAddress(String address) {
      this.address = address;
   }
   /**
    * @return the pinyin
    */
   public String getPinyin() {
      return pinyin;
   }
   /**
    * @param pinyin the pinyin to set
    */
   public void setPinyin(String pinyin) {
      this.pinyin = pinyin;
   }
   /**
    * @return the more
    */
   public String getMore() {
      return more;
   }
   /**
    * @param more the more to set
    */
   public void setMore(String more) {
      this.more = more;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "Geo [longitude=" + longitude + ", latitude=" + latitude + ", city=" + city + ", province=" + province + ", city_name=" + city_name + ", province_name=" + province_name + ", address="
            + address + ", pinyin=" + pinyin + ", more=" + more + "]";
   }  
	
	
	
	


}
