package com.example.demo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;

public class GameCenter {
    public static void main(String args[] ) throws Exception {
        Scanner input_scanner = new Scanner(System.in);
        int n=input_scanner.nextInt();
        List<Result> result = new ArrayList<Result>();
       
        String[] str;
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++){
             str = (input_scanner.next()).split("#");
             for(int j=0; j<n;j++){
                 a[i][j]=Integer.parseInt(str[j]);
            }
        }

        //x, y==>-1,+1, if <0 and >n-1 not consider 
        /*(0,0)==> (-1,-1)(-1,0)(-1,1)(0,-1)(0,0)(0,1)(1,-1)(1,0)(1,1) */
        int min;
        for(int k=0;k<n;k++){
           
             for(int l=0; l<n;l++){
                  min=a[k][l];
                 for(int p=k-1;p<=k+1;p++)
                    for(int q=l-1;q<=l+1;q++){
                        if(!(p<0 || p>n-1 || q<0 || q>n-1)){
                            if(min>a[p][q])
                                min=a[p][q];
                            
                        }      
                    }
                result.add(new Result((k+1)+"#"+(l+1),min));
                
            }
        }
        
        
       
        
        
        int max= result.stream()
        .mapToInt(Result::getMin)
				.summaryStatistics().getMax();


        result.stream()
        .filter(r->r.getMin()==max)
        .map(Result::getPos)
        .forEach(System.out::println);
    	//Write code here

   }

  
}

class Result{
    String pos;
    int min;
    Result(String p, int m){
        pos=p;
        min=m;
    }

    public int getMin(){
        return min;
    }

    public String getPos(){
        return pos;
    }
}


