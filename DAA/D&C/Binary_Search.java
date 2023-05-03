public class Binary_Search {
   public static int binarySearch(int arr[], int low, int high, int key) {
      int mid = (low + high)/2;
      while( low <= high ) {
         if ( arr[mid] < key ) {
            low = mid + 1;
         } else if ( arr[mid] == key ) {
            return mid;
         } else {
            high = mid - 1;
         }
         mid = (low + high)/2;
      }

      return -1;
   }
   public static void main(String args[]) {
      int[] arr = { 10, 20, 30, 40, 50, 60 };
      int key = 30;
      int high=arr.length-1;
      int i = binarySearch(arr,0,high,key);
      if (i != -1) {
         System.out.println(key + " is present at index: " + i);
      } else {
         System.out.println(key + " is not present.");
      }
   }
}