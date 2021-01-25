package Compress;

public class Run implements Comparable<Run> {
	
	public byte symbol;
	public int length;
	public int frequency;
	public Run left;
	public Run right;
	
	public int codeword;
	public int codewordLength;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + symbol;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Run other = (Run) obj;
		if (length != other.length)
			return false;
		if (symbol != other.symbol)
			return false;
		return true;
	}

	@Override
	public int compareTo(Run o) {
		return Integer.compare(this.frequency, o.frequency);
	}

	@Override
	public String toString() {
		return "Run [symbol=" + symbol + ", length=" + length + "]";
	}	
	
	
}
