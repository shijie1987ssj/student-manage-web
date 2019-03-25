package com.uf88.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：</b>Stuscore:<br>
 * @author：<a href="mailto:*@uf88.cn">系统生成</a>
 * @since：2018年09月19日 14时12分09秒 星期三 
 * @version:1.0
 */
public class Stuscore implements Serializable {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private Integer stuid;	/**	 *	 */	private Integer english;	/**	 *	 */	private Integer math;	/**	 *	 */	private Integer chinese;	/**	 *	 */	private Integer computer;	/**	 *	 */	private Integer sumscore;	/**	 *	 */	private Integer rank;	public Integer getStuid() {	    return this.stuid;	}	public void setStuid(Integer stuid) {	    this.stuid=stuid;	}	public Integer getEnglish() {	    return this.english;	}	public void setEnglish(Integer english) {	    this.english=english;	}	public Integer getMath() {	    return this.math;	}	public void setMath(Integer math) {	    this.math=math;	}	public Integer getChinese() {	    return this.chinese;	}	public void setChinese(Integer chinese) {	    this.chinese=chinese;	}	public Integer getComputer() {	    return this.computer;	}	public void setComputer(Integer computer) {	    this.computer=computer;	}	public Integer getSumscore() {	    return this.sumscore;	}	public void setSumscore(Integer sumscore) {	    this.sumscore=sumscore;	}	public Integer getRank() {	    return this.rank;	}	public void setRank(Integer rank) {	    this.rank=rank;	}	@Override	public String toString() {	StringBuffer sb = new StringBuffer();	sb.append("Stuscore ["); 	sb.append("'stuid':'" + this.getStuid() + "',"); 	sb.append("'english':'" + this.getEnglish() + "',"); 	sb.append("'math':'" + this.getMath() + "',"); 	sb.append("'chinese':'" + this.getChinese() + "',"); 	sb.append("'computer':'" + this.getComputer() + "',"); 	sb.append("'sumscore':'" + this.getSumscore() + "',"); 	sb.append("'rank':'" + this.getRank() + "'");	sb.append("]");	return sb.toString();	}
}

