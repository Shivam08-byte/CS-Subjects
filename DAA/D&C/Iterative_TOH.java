import java.util.*;
import java.lang.*;
import java.io.*;

// Tower of Hanoi
public class Iterative_TOH {

   //Stack
   class Stack {
      int size;
      int top;
      int arr[];
   }

   // Creating Stack
   Stack stack_creation(int size) {
      Stack stack = new Stack();
      stack.size = size;
      stack.top = -1;
      stack.arr = new int[size];
      return stack;
   }

   //to check if stack is full
   boolean isFull(Stack stack) {
      return (stack.top == stack.size - 1);
   }

   //to check if stack is empty
   boolean isEmpty(Stack stack) {
      return (stack.top == -1);
   }

   //Insertion in Stack
   void push(Stack stack, int item) {
      if (isFull(stack))
         return;
      stack.arr[++stack.top] = item;
   }

   //Deletion from Stack
   int pop(Stack stack) {
      if (isEmpty(stack))
         return Integer.MIN_VALUE;
      return stack.arr[stack.top--];
   }

   // Function to movement disks between the poles
   void Diskmovement(Stack src, Stack dest, char s, char d) {
      int pole1 = pop(src);
      int pole2 = pop(dest);

      // When pole 1 is empty
      if (pole1 == Integer.MIN_VALUE) {
         push(src, pole2);
         movement(d, s, pole2);
      }

      // When pole2 pole is empty
      else if (pole2 == Integer.MIN_VALUE) {
         push(dest, pole1);
         movement(s, d, pole1);
      }

      // When top disk of pole1 > top disk of pole2
      else if (pole1 > pole2) {
         push(src, pole1);
         push(src, pole2);
         movement(d, s, pole2);
      }

      // When top disk of pole1 < top disk of pole2
      else {
         push(dest, pole2);
         push(dest, pole1);
         movement(s, d, pole1);
      }
   }

   //Function to show the movementment of disks
   void movement(char source, char destination, int disk) {
      System.out.println("Move the disk " + disk + " from " + source + " to " + destination);
   }

   // Implementation
   void Iterative(int num, Stack src, Stack aux, Stack dest) {
      int i, total_count;
      char s = 'S', d = 'D', a = 'A';

      // Rules in algorithm will be followed
      if (num % 2 == 0) {
         char temp = d;
         d = a;
         a = temp;
      }
      total_count = (int)(Math.pow(2, num) - 1);

      // disks with large diameter are pushed first
      for (i = num; i >= 1; i--)
         push(src, i);
      for (i = 1; i <= total_count; i++) {
         if (i % 3 == 1)
            Diskmovement(src, dest, s, d);
         else if (i % 3 == 2)
            Diskmovement(src, aux, s, a);
         else if (i % 3 == 0)
            Diskmovement(aux, dest, a, d);
      }
   }

   // Main Function
   public static void main(String[] args) {

      // number of disks
      int num = 3;
      Iterative_TOH ob = new Iterative_TOH();
      Stack src, dest, aux;
      src = ob.stack_creation(num);
      dest = ob.stack_creation(num);
      aux = ob.stack_creation(num);
      ob.Iterative(num, src, aux, dest);
   }
}