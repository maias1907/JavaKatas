package ArraysAndStrings;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int length = 0;
        int revX = 0,temp=x;
        if (x < 0) {
            return false;
        }
       while(temp>0)
       {
           length++;
           temp=temp/10;
       }
       temp=x;
       for(int i=length-1;i>=0;i--)
       {
           int digit=temp%10;
           revX+=digit*Math.pow(10,i);
           temp=temp/10;

       }
       if(revX==x)
       {
           return true;
       }
       return false;
    }

}
