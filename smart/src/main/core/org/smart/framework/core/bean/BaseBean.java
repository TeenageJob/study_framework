package org.smart.framework.core.bean;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 提供 Bean 类的基础特性
 *
 * @author TY
 * @Time 2017年9月20日 下午9:34:44
 * @since 1.0.0
 */
public abstract class BaseBean implements Serializable {

    /**
	 * create by ty on TY 2017年11月10日 下午2:16:33
	 */
	private static final long serialVersionUID = 1948590189182344009L;

	@Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
