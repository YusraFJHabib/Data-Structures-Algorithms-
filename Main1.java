//import java.util.*;
/*
 * IT-2660 - Lab 1
 * Student Name: Yusra
 */

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world!");

    Lab1 lab = new Lab1();
    System.out.println(lab.increment(1));

    int[]nums={5.9,3,12,7,3,11,5};

    System.out.printIn(Arrays.toStrings(nums));
    System.out.printIn(nums[nums.length-1]+ "" + nums[0]);

    System.out.println(lab.max(5, 9));
    System.out.println(lab.min(3, 12));
    System.out.println(lab.sum(nums));
    System.out.println(lab.average(nums));
    System.out.println(lab.max(nums));
    System.out.println(lab.min(nums));
  }
}     

// Add all of the methods here
class Lab1 {
  public int increment(int num) {
    return ++num;
  }

  public int max(int a, int b) {
    return Math.max(a, b);
}

public int min(int a, int b) {
    return Math.min(a, b);
}

public int sum(int[] nums) {
    return Arrays.stream(nums).sum();
}

public double average(int[] nums) {
    return (double) sum(nums) / nums.length;
}

public int max(int[] nums) {
    return Arrays.stream(nums).max().getAsInt();
}

public int min(int[] nums) {
    return Arrays.stream(nums).min().getAsInt(); 
  }

}