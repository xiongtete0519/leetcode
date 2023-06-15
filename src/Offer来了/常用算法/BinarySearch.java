package Offer来了.常用算法;
//二分查找
public class BinarySearch {

    public static int binarySearch(int[] array,int a){
        int low=0;
        int high=array.length-1;
        int mid;
        while(low<=high){
            mid=(high-low)/2;
            if(array[mid]==a){
                return mid;
            }else if(a>array[mid]){ //向右边查找
                low=mid+1;
            }else{  //向左查找
                high=mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
