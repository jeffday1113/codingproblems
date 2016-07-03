package javasolutions;

public class Substring {

    public static void main(String[] args) {
        Substring s = new Substring();
        System.out.println(s.isSubstring("hello", "i"));
    }

    public boolean isSubstring(String str, String substr) {
        if (str.equals("") || substr.equals("") || substr.length() > str.length()) {
            return false;
        } else if (str.length() == substr.length()) {
            return str.equals(substr);
        }
        char[] strArray = str.toCharArray();
        char[] substrArray = substr.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray.length - i < substrArray.length) {
                return false;
            } else if (strArray[i] != substrArray[0]) {
                continue;
            } else {
                if (substr.length() == 1) {
                    return true;
                }
                int temp = i + 1;
                for (int j = 1; j < substrArray.length; j++) {
                    if (substrArray[j] == strArray[temp]) {
                        if (j == substrArray.length - 1) {
                            return true;
                        } else {
                            temp++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
