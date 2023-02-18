package CSDN;

import java.util.ArrayList;
import java.util.Scanner;

class 求并集 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String str_0 = scan.nextLine();
        String[] line_list_0 = str_0.trim().split(" ");        
        ArrayList<Integer> arr0 = new ArrayList<>();
        for(int i = 0; i < line_list_0.length; i++){
            arr0.add(Integer.parseInt(line_list_0[i]));
        }
    
        
        String str_1 = scan.nextLine();
        String[] line_list_1 = str_1.trim().split(" ");        
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i = 0; i < line_list_1.length; i++){
            arr1.add(Integer.parseInt(line_list_1[i]));
        }
    
        
        String str_2 = scan.nextLine();
        String[] line_list_2 = str_2.trim().split(" ");        
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i < line_list_2.length; i++){
            arr2.add(Integer.parseInt(line_list_2[i]));
        }
    

        scan.close();

        ArrayList<Integer> result = solution(arr0, arr1, arr2);

        
        for (int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    

    }

    public static ArrayList<Integer> solution(ArrayList<Integer> arr0, ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> result = new ArrayList<>();

        // TODO: 请在此编写代码
        Integer m=arr0.get(0);
        Integer n=arr0.get(1);
        int i=0;
        int j=0;
        while(i<m&&j<n){
            if(arr1.get(i)<=arr2.get(j)){
                if(!result.contains(arr1.get(i))){
                    result.add(arr1.get(i));
                }
                i++;
            }else{
                if(!result.contains(arr2.get(j))){
                    result.add(arr2.get(j));
                }
                j++;
            }
        }
        while(i<m){
            if(!result.contains(arr1.get(i))){
                result.add(arr1.get(i));
            }
            i++;
        }
        while(j<n){
            if(!result.contains(arr2.get(j))){
                result.add(arr2.get(j));
            }
            j++;
        }
        return result;
    }
}