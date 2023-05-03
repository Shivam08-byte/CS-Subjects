class maxMin{
    public static void main(String[] args )
    {
        int[] arr={1,5,6,9,7,8,3,4,2};
        arr=func(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
    public static int[] func(int arr[])
    {
       int max=arr[0];
       int min=arr[0];
       for(int i=0;i<arr.length;i++)
       {
        if(arr[i]>max)
            max=arr[i];
        if(arr[i]<min)
            min=arr[i]; 
       }
       int brr[]={max,min};
       return brr;
    }
}