package lab6;

public class Fractions {
		private int numerator;
		private int denominator;
		public Fractions(int numerator, int denominator){
		  this.numerator=numerator;
		  this.denominator=denominator;
		}
		public double getvalue(){
		  return (double)numerator/denominator;
		}
		public String toString(){
		  return numerator+"/"+denominator;
		}
}
