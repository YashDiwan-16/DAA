class BS{  
 public static void binarySearch(int arr[], int low, int high, int key){  
   int mid = (low + high)/2;  
   while( low <= high ){  
      if ( arr[mid] < key ){  
        low = mid + 1;     
      }else if ( arr[mid] == key ){  
        System.out.println("Element is found at index: " + mid);  
        break;  
      }else{  
         high = mid - 1;  
      }  
      mid = (low + high)/2;  
   }  
   if ( low > high ){  
      System.out.println("Element is not found!");  
   }  
 }  
 public static void main(String args[]){  
        int arr[] = {10,20,30,40,50};  
        int key = 30;  
        int high=arr.length-1;  
        binarySearch(arr,0,high,key);     
 }  
}  