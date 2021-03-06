package optNet.prova;

public class MTFApache implements org.apache.commons.math3.random.RandomGenerator { //classe creata per fare in modo che TriangularDistribution sfrutti l'algoritmo Mersenne-Twister fast - copiata da Mason 
	
	ec.util.MersenneTwisterFast random;
	
	public MTFApache(ec.util.MersenneTwisterFast random) { this.random = random; }
	
	public boolean nextBoolean() { return random.nextBoolean(); }
	
	public void nextBytes(byte[] bytes) { random.nextBytes(bytes); }
	
	public double nextDouble() { return random.nextDouble(); }
	
	public float nextFloat() { return random.nextFloat(); }
	
	public double nextGaussian() { return random.nextGaussian(); }
	
	public int nextInt() { return random.nextInt(); }
	
	public int nextInt(int n) { return random.nextInt(n); }
	
	public long nextLong() { return random.nextLong(); }
	
	public void setSeed(int seed) { random.setSeed(seed); }
	
	public void setSeed(int[] array) { random.setSeed(array); }
	
	public void setSeed(long seed) { random.setSeed(seed); }
	
}
