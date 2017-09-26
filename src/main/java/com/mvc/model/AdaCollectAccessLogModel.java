package com.mvc.model;

import java.io.Serializable;
import java.util.Date;

public class AdaCollectAccessLogModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer siteid;

    private Integer logtype;

    private String requestid;

    private String clientid;

    private String useragent;

    private String requesturl;

    private String referer;

    private String realreferer;

    private String remoteip;

    private String realip;

    private String os;

    private String domain;

    private Integer countryid;

    private Integer provinceid;

    private Integer cityid;

    private Date accesstime;

    private Date createtime;
    
    
    
    

    public AdaCollectAccessLogModel(Integer siteid, Integer logtype, String requestid, String clientid,
			String useragent, String requesturl, String referer, String realreferer, String remoteip, String realip,
			String os, String domain, Integer countryid, Integer provinceid, Integer cityid, Date accesstime) {
		super();
		this.siteid = siteid;
		this.logtype = logtype;
		this.requestid = requestid;
		this.clientid = clientid;
		this.useragent = useragent;
		this.requesturl = requesturl;
		this.referer = referer;
		this.realreferer = realreferer;
		this.remoteip = remoteip;
		this.realip = realip;
		this.os = os;
		this.domain = domain;
		this.countryid = countryid;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.accesstime = accesstime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public Integer getLogtype() {
        return logtype;
    }

    public void setLogtype(Integer logtype) {
        this.logtype = logtype;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid == null ? null : requestid.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent == null ? null : useragent.trim();
    }

    public String getRequesturl() {
        return requesturl;
    }

    public void setRequesturl(String requesturl) {
        this.requesturl = requesturl == null ? null : requesturl.trim();
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    public String getRealreferer() {
        return realreferer;
    }

    public void setRealreferer(String realreferer) {
        this.realreferer = realreferer == null ? null : realreferer.trim();
    }

    public String getRemoteip() {
        return remoteip;
    }

    public void setRemoteip(String remoteip) {
        this.remoteip = remoteip == null ? null : remoteip.trim();
    }

    public String getRealip() {
        return realip;
    }

    public void setRealip(String realip) {
        this.realip = realip == null ? null : realip.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Date getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(Date accesstime) {
        this.accesstime = accesstime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}