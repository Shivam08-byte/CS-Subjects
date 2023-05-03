public class mergeSort {
    static int a[] = { 16, 18, 12, 8, 22, 14, 9 };
    static int b[] = new int[10];
    static void merging(int low, int mid, int high) {
       int l1, l2, i;
       for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
          if(a[l1] <= a[l2])
             b[i] = a[l1++];
          else
             b[i] = a[l2++];
       }
       while(l1 <= mid)
          b[i++] = a[l1++];
       while(l2 <= high)
          b[i++] = a[l2++];
       for(i = low; i <= high; i++)
          a[i] = b[i];
    }
    static void sort(int low, int high) {
       int mid;
       if(low < high) {
          mid = (low + high) / 2;
          sort(low, mid);
          sort(mid+1, high);
          merging(low, mid, high);
       } else {
          return;
       }
    }
    public static void main(String args[]) {
       int i;
       int n = a.length;
       System.out.println("List before sorting");
       for(i = 0; i < n; i++)
          System.out.print(a[i] + " ");
       sort(0, n-1);
       System.out.println("\nList after sorting");
       for(i = 0; i < n; i++)
          System.out.print(a[i]+" ");
    }
 }



//  public class MergeSort {

//     public static void mergeSort(int[] array) {
//         if (array == null || array.length == 0) {
//             return;
//         }
//         int[] tempArray = new int[array.length];
//         mergeSortHelper(array, 0, array.length - 1, tempArray);
//     }

//     private static void mergeSortHelper(int[] array, int left, int right, int[] tempArray) {
//         if (left >= right) {
//             return;
//         }
//         int mid = (left + right) / 2;
//         mergeSortHelper(array, left, mid, tempArray);
//         mergeSortHelper(array, mid + 1, right, tempArray);
//         merge(array, left, mid, right, tempArray);
//     }

//     private static void merge(int[] array, int left, int mid, int right, int[] tempArray) {
//         for (int i = left; i <= right; i++) {
//             tempArray[i] = array[i];
//         }
//         int i = left;
//         int j = mid + 1;
//         int k = left;
//         while (i <= mid && j <= right) {
//             if (tempArray[i] <= tempArray[j]) {
//                 array[k] = tempArray[i];
//                 i++;
//             } else {
//                 array[k] = tempArray[j];
//                 j++;
//             }
//             k++;
//         }
//         while (i <= mid) {
//             array[k] = tempArray[i];
//             i++;
//             k++;
//         }
//         while (j <= right) {
//             array[k] = tempArray[j];
//             j++;
//             k++;
//         }
//     }
// }
