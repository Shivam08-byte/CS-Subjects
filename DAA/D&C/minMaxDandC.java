public class minMaxDandC {
    public static void main(String[] args) {
        int[] arr = {3, 1, -8, 4, 10, -5};
        Pair result = getMinMax(arr, 0, arr.length - 1);
        System.out.println("Minimum element is " + result.min);
        System.out.println("Maximum element is " + result.max);
    }

    static class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static Pair getMinMax(int[] arr, int low, int high) {
        if (low == high) {
            return new Pair(arr[low], arr[low]);
        } else if (high - low == 1) {
            return arr[low] < arr[high] ? new Pair(arr[low], arr[high]) : new Pair(arr[high], arr[low]);
        } else {
            int mid = (low + high) / 2;
            Pair leftPair = getMinMax(arr, low, mid);
            Pair rightPair = getMinMax(arr, mid + 1, high);
            return new Pair(Math.min(leftPair.min, rightPair.min), Math.max(leftPair.max, rightPair.max));
        }
    }
}
