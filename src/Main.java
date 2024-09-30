public class Main {
    public static void main(String[] args) {
//        System.out.println(reverseInteger(10239));
//        System.out.println(encryptThis("Money doesn't mean anything to me"));
//        System.out.println(decipherThis("71fier 99sangeh 115eaph 98tu 105t 110rvee 101sdn"));
    }
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                balance++;
            }
            else {
                balance--;
            }
            if (balance < 0){
                return false;
            }
        }
        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        String result = "";
        while (n > 0) {
            int lastIndex = n % 10; //mod to get last digit
            result = result + lastIndex;
            n = n / 10;
        }
        return result;
    }

    // 3. encryptThis
    public static String encryptThis(String str){
        str += " ";
        String result = "";
        String word = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                //System.out.println("word1="+word);
                result += (int)word.charAt(0);
                //System.out.println("result1="+result);
                result += word.charAt(word.length()-1);
                //System.out.println("result2="+result);
                if(word.length()>2){
                    result+=word.substring(2,word.length()-1);
                    result+=word.charAt(1);
                }

                if(i!=str.length()-1) result+=" ";
                word="";
            }
            else{
                //System.out.println("word2="+word);
                word+=str.charAt(i);
            }
        }
        return result;
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        str += " ";
        String result = "";
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                int num = 0, pos = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) >= '0' && word.charAt(j) <= '9') {
                        num *= 10;
                        num += Integer.parseInt(word.substring(j, j + 1));
                        pos = j;
                    } else {
                        break;
                    }
                }
                result += (char) num;
                result += word.charAt(word.length() - 1);
                if (word.length() - 1 > 1 + pos) {
                    result += word.substring(pos + 2, word.length() - 1);
                    result += word.charAt(pos + 1);
                }
                if (i != str.length() - 1) {
                    result += " ";
                }
                word = "";
            } else {
                word += str.charAt(i);
            }
        }
        return result;
    }

}
