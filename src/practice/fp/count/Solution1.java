package practice.fp.count;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new LinkedList<>();
        for(int i =0; i<n ; i++){
            list.add(i);
        }
        System.out.println(list);
    }
}
