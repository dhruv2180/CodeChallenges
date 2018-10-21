import java.util.*;
public class HelloWorld{

     public static void main(String []args){
       
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        map.put(0,1);
        map.put(1,1);

        for(int i=0;i<25;i++){
        
            System.out.print( fib(i,map)+" ");
        }
     }
     
     public static int fib(int n, Map<Integer,Integer> map){
         if(map.get(n)==null){   
              int num=fib(n-1,map)+fib(n-2,map);
              map.put(n,num);
              return num;
         }
         else{
             return map.get(n);
         }
     }
}
