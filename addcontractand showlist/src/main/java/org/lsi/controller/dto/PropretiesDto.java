package org.lsi.controller.dto;

import java.math.BigInteger;
import java.util.Objects;

public class PropretiesDto {
	
	BigInteger param0;

	public BigInteger getParam0() {
		return param0;
	}

	public void setParam0(BigInteger param0) {
		this.param0 = param0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(param0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropretiesDto other = (PropretiesDto) obj;
		return Objects.equals(param0, other.param0);
	}
	
}
