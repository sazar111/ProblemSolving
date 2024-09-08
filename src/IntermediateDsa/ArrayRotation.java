/*
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.

Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the array A after rotating it B times to the right

Example Input
Input 1:
A = [1, 2, 3, 4]
B = 2
Input 2:
A = [2, 5, 6]
B = 1

Example Output
Output 1:
[3, 4, 1, 2]
Output 2:
[6, 2, 5]

Example Explanation
Explanation 1:
Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Explanation 2:
Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
*/
public class ArrayRotation {
    public static int[] solve(int[] A, int B) {
        int[] resultArray=A;
        int n= resultArray.length-1;
        int rotationRequired= B%A.length;
        if(rotationRequired==0){
            return A;
        }
        reverse(resultArray,0,n);

        reverse(resultArray,0,rotationRequired-1);
        for(int i: resultArray){
            System.out.print(i+" ");
        }
        System.out.println(" ");
        reverse(resultArray,rotationRequired,n);
        // OA: [1,2,3,4]  RA:[4,3,2,1] RA:[2,3,4,1]
        return resultArray;
    }

    public static void reverse(int[] A, int start, int end){
        //OA:[1,1,4,9,4,7,1]
        //RA:[1,7,4,9,4,1,1]
        //ResA:[7,1,1,1,4,9,4]

        for(int i=start; i<end; i++){
            if(i>=end-i+start){
                break;
            }
            int temp = A[i];
            A[i] = A[end-i+start];
            A[end-i+start] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A={1,1,4,9,4,7,1};
        int[] sol=solve(A,9);
        for(int i: sol){
            System.out.print(i+" ");
        }
    }

}
