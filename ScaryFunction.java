import static java.lang.Math.*;

public class ScaryFunction {
	public static void main(String[] args) {
		int[] d = new int[10];
		for (int i = 0; i <= 9; i++) {
			d[i] = (11- i) * 2;
		};
		double[] x = new double[11];
		double min = -9.0;
		double max = 13.0;
		for (int i = 0; i < 11; i++) {
			x[i] = rnd(min, max);
		};
		double[][] k = new double[10][11];
		int[] someNumbers = {8, 12, 14, 16, 18};
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 11; j++) {
				if (d[i] == 6) {
					k[i][j] = firstScaryFunction(x[j]);
				} else if (isNumberInSet(d[i], someNumbers)) {
					k[i][j] = secondScaryFunction(x[j]);
				} else {
					k[i][j] = thirdScaryFunction(x[j]);
				};
				System.out.printf((String.valueOf(k[i][j]).equals("Infinity")) ? "%-13.3e" : "%-+13.3e", k[i][j]);
			}
			System.out.println();
		}
	}

	public static double rnd(double min, double max) {
		return (random() * (max - min)) + min;
	}

	public static double firstScaryFunction(double x) {
		return (pow(0.5 / (sin(pow(x, x * (x - 2))) - 1), asin(sin(x))));
	}

	public static double secondScaryFunction(double x) {
		return (pow(cos(pow(x, (0.25 + x) / 4)) / 4, pow(E, log(abs(x))))); 
	}

	public static double thirdScaryFunction(double x) {
		return (pow(2 / (0.75 - sin(pow(atan((x + 2) / 22) / 3, 3))), pow((pow((1 / 3) / (1 - 2 * x), 3) - 4) / cos(pow(E, x)), 3))); 
	}

	public static boolean isNumberInSet(int a, int[] setNumber) { 
		boolean flag = false;
		for (int i: setNumber) {
			if (i == a) {
				flag = true;
			}
		}
		return (flag); 
	}
}