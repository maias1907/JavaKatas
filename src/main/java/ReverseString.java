public class ReverseString {
    public void reverseString(char[] s) {

        int first=0,last=s.length-1;
        char temp;
        while(first<last)
        {
            temp=s[first];
            s[first]= s[last];
            s[last]=temp;
            first++;
            last--;
        }

    }
}
