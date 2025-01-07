package d4m.acc.microservice;

public class RCVs {

	final String[] r;
	final String[] c;
	final String[] v;

	public RCVs(String[] r, String[] c, String[] v) {
		super();
		this.r = r;
		this.c = c;
		this.v = v;
	}

	public String[] getR() {
		return r;
	}

	public String[] getC() {
		return c;
	}

	public String[] getV() {
		return v;
	}

	public String toString() {
		StringBuilder bld = new StringBuilder();
		bld.append(String.join(",", getR()));
		bld.append(String.join(",", getC()));
		bld.append(String.join(",", getV()));
		return bld.toString();
	}
}
