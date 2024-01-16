package practice.hackerrank.hackfest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maximumStones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int maximumStones(List<Integer> arr) {
        // Write your code here
        /*
        Input
        4
        5 1 1 4
        Output
        10

        Input
        3
        2 1 2
        Output
        2
        */
        int max = 0;
        int evenSum = 0;
        int oddSum = 0;
        for(int i=0; i<arr.size(); ){
            evenSum = evenSum + arr.get(i);
            i += 2;
        }
        for(int j=1; j<arr.size(); ){
            oddSum = oddSum + arr.get(j);
            j += 2;
        }
        int total = evenSum + oddSum;
        if(evenSum < oddSum){
            max = total - (oddSum - evenSum);
        }else if(evenSum > oddSum) {
            max = total - (evenSum - oddSum);
        }else{  // evenSum == oddSum
            max = total;
        }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.maximumStones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.maximumStones(arr);
        System.out.println(result);
    }
}

