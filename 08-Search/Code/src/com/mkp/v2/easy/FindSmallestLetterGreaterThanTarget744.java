package src.com.mkp.v2.easy;

public class FindSmallestLetterGreaterThanTarget744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length,s=0,e=n-1;
        while(s <= e){
            int mid=s+(e-s)/2;
            if (letters[mid] > target) e=mid-1;
            else s=mid+1;
        }
        return s < n ? letters[s] : letters[0];
    }
}
