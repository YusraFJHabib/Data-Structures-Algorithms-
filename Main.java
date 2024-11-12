import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(bubbleSortedList);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(insertionSortedList);
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
      int key = integerList.get(i);
      int j = i - 1;
      while (j >= 0 && integerList.get(j) > key) {
          integerList.set(j + 1, integerList.get(j));
          j--;
      }
      integerList.set(j + 1, key);
  }

    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    int n = integerList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                }
            }
        }

    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}




//questions 

//1: If you were implementing a sort algorithm for a new language, which sort would you use?

// If I had to pick a sorting algorithm for a new programming language, I'd probably go with either merge sort or quicksort. 
// These two are pretty fast, especially for big lists of stuff. 
// They're usually much better than bubble sort or insertion sort, which can get slow with large datasets. 
// Plus, they're more reliable, even in the worst-case scenarios.






//2:  Was there a difference in the time it took for bubble and insertion sort to run? Does this make sense given the time complexities for these sorting algorithms?

// Yes, there's usually a pretty big difference in how long bubble sort and insertion sort take. 
// Bubble sort is generally slower because it's always slow, which doesnt make much sense to me as to why to be honest. 
// Insertion sort though can be pretty quick, especially for lists that are already mostly sorted or are small. 
//Insertion sort is often better for smaller or partially sorted lists.





//3: Which sort algorithm has an easier implementation (in terms of understanding) to you?

// Bubble sort is pretty easy to grasp. It's like comparing and swapping neighbors until everything's in order. 
// Insertion sort is a little trickier, kind of like shifting things around to find the right spot. 
// Bubble sort is often the first one people learn because it's simple, 
// but insertion sort can be faster in some situations.  