package com.mvc.model;

import java.io.Serializable;

/**
 * 
 * 地区 实体
 * */
public class SysRegionModel  implements Serializable{

	private static final long serialVersionUID = -7597810101189737207L;

	private Integer id;   			//地区ID

    private String name;  			//简称

    private String fullname; 	 	//全称

    private Integer level;   		//行政级别{1:省,2:市,3:区,4:街道}

    private String jianpin;			//简拼

    private String pinyin;   		//全拼

    private String zipcode; 		//邮政编码

    private Integer sort; 			//排序

    private Integer ishot;  		//是否热点{1:是,0:否}

    private String lng;   			//经度

    private String lat;   			//纬度

    private Integer parentid;  		//上级ID

    private Integer provinceid; 	//所属省ID

    private String provincename; 	//所属省名称

    private Integer cityid;  		//所属市ID

    private String cityname;		//所属市名称

    private Integer districtid; 	//所属区县ID

    private String districtname; 	//所属区名称
    
    

    public SysRegionModel(Integer provinceid, Integer cityid, Integer districtid) {
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.districtid = districtid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getJianpin() {
        return jianpin;
    }

    public void setJianpin(String jianpin) {
        this.jianpin = jianpin == null ? null : jianpin.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname == null ? null : districtname.trim();
    }
}