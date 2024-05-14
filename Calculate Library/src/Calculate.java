/*Anthony Ma
 *September 24, 2023
 *Math Library Class, contains all the methods for math calculations
 */

public class Calculate {

	public static int square(int squaredNum) {//square the number inputed
		return squaredNum*squaredNum;	
	}
	
	public static int cube(int cubedNum) {//cube the number inputed
		return cubedNum*cubedNum*cubedNum;
	}
	
	public static double average(double num1, double num2) {//finds the average of the 2 numbers inputed
		return (num1+num2)/2;
	}
	
	public static double average(double num1, double num2, double num3) {//find the average of the 3 numbers inputed
		return (num1+num2+num3)/3;
	}
	
	public static double toDegrees(double radians) {//converts Radians into degrees
		return radians*180/3.14159;
	}
	
	public static double toRadians(double degrees) {//converts degrees to Radians
		return degrees*3.14159/180;
	}
	
	public static double discriminant(double a, double b, double c) {//returns the discriminant
		return (b*b)-(4*a*c);
	}
	
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {//converts a mixed number into an improper fraction
		return ((wholeNum*denominator+numerator)+"/"+denominator);
	}
	
	public static String toMixedNum (int numerator, int denominator) {//converts a improper fraction into a mixed number
		int wholeNum = numerator/denominator;
		int remainder = numerator%denominator;
		return (wholeNum+"_"+remainder+"/"+denominator);
	}
	
	public static String foil (int binom1Num1, int binom1Num2, int binom2Num1, int binom2Num2, String variable) {//foils the 2 binomial provided
		int a = binom1Num1*binom2Num1;
		int b = (binom1Num1*binom2Num2)+(binom1Num2*binom2Num1);
		int c = binom1Num2*binom2Num2;
		return (a+variable+"^2 + "+b+variable+" + "+c);
	}
	
	public static boolean isDivisibleBy (int dividend, int divisor) {//determines whether number 1 is divisible by number 2
		if (divisor == 0) {
			throw new IllegalArgumentException("Can't divide by 0");
		}
		if (dividend%divisor == 0){
			return true;
		}else {
			return false;
		}
	}
	
	public static double absValue(double num) {//returns the absolute value of the input
		if (num<0) {
			return num*-1.0;
		}else{
			return num;
		}
	}
	
	public static double max (double num1, double num2) {//returns the larger of the 2 inputs
		if (num1>num2) {
			return num1;
		}else {
			return num2;
		}
	}
	
	public static double max (double num1, double num2, double num3) {//returns the largest of the 3 inputs
		if (num1>num2&&num1>num3) {
			return num1;
		}else if (num2>num3){
			return num2;
		}else {
			return num3;
		}
	}
	
	public static int min (int num1, int num2) {//returns the smaller of the 2 integer inputs
		if (num1<num2) {
			return num1;
		}else {
			return num2;
		}
	}
	
	public static double min (double num1, double num2) {//returns the smaller of the 2 real number inputs
		if (num1<num2) {
			return num1;
		}else {
			return num2;
		}
	}
	
	public static double round2 (double num) {//rounds the input to the hundredth place
		double roundedNum = Calculate.absValue(num);
		roundedNum += 0.005;
		roundedNum *= 100;
		roundedNum = (int)roundedNum;
		roundedNum = roundedNum/100.0;
		if (num<0) {
			roundedNum*=-1;
		}
		num = roundedNum;
		return num;
	}
	
	public static double exponent (double base, int powerOf) {//raises the first number to the power of the second number
		if (powerOf<0) {
			throw new IllegalArgumentException("Can't raise to the power of a negative number");
		}else if (powerOf==0) {
			if (base==0) {
				throw new IllegalArgumentException("Can't raise 0 to the power of 0");
			}
			base = 1;
			return base;
		}else{
			double product=1;
			for (int i = 1;i<=powerOf;i++) {
				product=product*base;
			}
			return product;
		}
	}
	
	public static int factorial (int num) {//takes the factorial of the number inputed
		if (num<0) {
			throw new IllegalArgumentException("Can't take the factorial of a negative number");
		}else if (num==0) {
			return 1;
		}else{
			int product = 1;
			for (int i=1;i<=num;i++) {
				product*=i;
			}
			return product;
		}
	}
	
	public static boolean isPrime (int num) {//determines if the number inputed is a prime number
		if (num<0) {
			num*=-1;
		}
		for (int i=2;i<num;i++) {
			if (Calculate.isDivisibleBy(num, i)==true) {
				return false;
			}
		}
		return true;
	}
	
	public static int gcf (int num1, int num2) {//determines the greatest common factor of the 2 numbers inputed
		if (num1==0||num2==0) {
			return (int)Calculate.max(num1, num2);
		}else {
			int startFactor = Calculate.min(num1, num2);
			for (int i=startFactor; i>0;i--) {
				if (Calculate.isDivisibleBy(num1, i)&&Calculate.isDivisibleBy(num2, i)) {
					return i;
				}
			}
		}
		return 1;
	}
	
	public static double sqrt (double num) {//returns the square root of the number inputed
		if (num<0) {
			throw new IllegalArgumentException("Can't square root a negative number");
		}
		double guess = num/2;
		while (Calculate.absValue(num-guess*guess)>0.000025) {
			guess = 0.5*(num/guess+guess);
		}
		return Calculate.round2(guess);
	}
	
	public static String quadForm (int a, int b, int c) {//Tells us the number of roots and what they are
		double discriminant = Calculate.discriminant(a, b, c);
		if (discriminant<0) {
			return "no real roots";
		}
		double root1 = ((-b)+Calculate.sqrt(discriminant))/(a*2);
		double root2 = ((-b)-Calculate.sqrt(discriminant))/(a*2);
		if (root1==root2) {
			return ""+Calculate.round2(root1);
		}else {
			return Calculate.round2(Calculate.min(root1, root2))+" and "+Calculate.round2(Calculate.max(root1, root2));
		}
		
	}
}