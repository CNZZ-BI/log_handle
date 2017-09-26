package com.mvc.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 广告列表
 * 
 * */
public class AdaAdItemModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8457223055422843287L;

	private Integer id;		//ID

    private Integer siteid;	//站点

    private String name;	//广告名称

    private String prefix;	//网页前缀

    private Date createtime;//创建时间

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}