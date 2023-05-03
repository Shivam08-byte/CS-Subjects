import java.io.*;
public class karatsubaAlgorithm {
   static long karatsuba(long X, long Y) {

      // Base Case
      if (X < 10 && Y < 10)
         return X * Y;

      // determine the size of X and Y
      int size = Math.max(get_size(X), get_size(Y));
      if(size < 10)
         return X * Y;

      // rounding up the max length
      size = (size/2) + (size%2);
      long multiplier = (long)Math.pow(10, size);
      long b = X/multiplier;
      long a = X - (b * multiplier);
      long d = Y / multiplier;
      long c = Y - (d * size);
      long u = karatsuba(a, c);
      long z = karatsuba(a + b, c + d);
      long v = karatsuba(b, d);
      return u + ((z - u - v) * multiplier) + (v * (long)(Math.pow(10, 2 * size)));
   }
   static int get_size(long value) {
      int count = 0;
      while (value > 0) {
         count++;
         value /= 10;
      }
      return count;
   }
   public static void main(String args[]) {

      // two numbers
      long x = 17282;
      long y = 74622;
      System.out.print("The final product is ");
      long product = karatsuba(x, y);
      System.out.println(product);
   }
}