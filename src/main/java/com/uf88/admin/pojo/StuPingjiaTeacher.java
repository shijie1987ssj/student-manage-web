package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>StuPingjiaTeacher:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月25日 21时12分18秒 星期二 
 * @version:1.0
 */
public class StuPingjiaTeacher implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *编号	 */	private Integer id;	/**	 *学生编号，外键	 */	private Integer stuid;	/**	 *教师编号，外键	 */	private Integer teacherid;	/**	 *	 */	private Integer pingjiascore;	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public Integer getStuid() {	    return this.stuid;	}	public void setStuid(Integer stuid) {	    this.stuid=stuid;	}	public Integer getTeacherid() {	    return this.teacherid;	}	public void setTeacherid(Integer teacherid) {	    this.teacherid=teacherid;	}	public Integer getPingjiascore() {	    return this.pingjiascore;	}	public void setPingjiascore(Integer pingjiascore) {	    this.pingjiascore=pingjiascore;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("StuPingjiaTeacher ["); 	sb.append("'id':'" + this.getId() + "',"); 	sb.append("'stuid':'" + this.getStuid() + "',"); 	sb.append("'teacherid':'" + this.getTeacherid() + "',"); 	sb.append("'pingjiascore':'" + this.getPingjiascore() + "'");	sb.append("]");	return sb.toString();	}
}

