import java.util.HashMap;
import java.util.HashSet;

public class SortedRotatedArrayPairSearch {

    HashMap<Integer,Integer> map = new HashMap<>();

    public int  binarySearch(int arr[],int s,int e,int x) {
        if(s==e && arr[s] != x) {
            return -1;
        }

        int mid = (s+e)/2;

        if(arr[mid]==x) {
            return mid;
        }
        if(arr[s]<arr[mid-1]) {

            if(x>=arr[s] &&  x<=arr[mid-1]) {
                return binarySearch(arr,s,mid-1,x);
            }else{
                return binarySearch(arr,mid+1,e,x);
            }
        }else {
            if(x>=arr[mid+1] && x<=arr[e]) {
                return binarySearch(arr,mid+1,e,x);
            }else {
                return binarySearch(arr,s,mid-1,x);
            }
        }
    }
    public int  pairSearch(int arr[],int x){
        int z = 0;
        int l = arr.length;
        for (int i = 0;i<l;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<l;i++){
            int y = x-arr[i];
            if(map.containsKey(y)){
                z =  map.get(y);
                return z;
            }else{
                return -1;
            }
        }
        return z;
    }
}
