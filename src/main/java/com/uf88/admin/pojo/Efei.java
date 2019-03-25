package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Efei:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分08秒 星期三 
 * @version:1.0
 */
public class Efei implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private Integer id;	/**	 *	 */	private String description;	/**	 *	 */	private Integer value;	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getDescription() {	    return this.description;	}	public void setDescription(String description) {	    this.description=description;	}	public Integer getValue() {	    return this.value;	}	public void setValue(Integer value) {	    this.value=value;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Efei ["); 	sb.append("'id':'" + this.getId() + "',"); 	sb.append("'description':'" + this.getDescription() + "',"); 	sb.append("'value':'" + this.getValue() + "'");	sb.append("]");	return sb.toString();	}
}

