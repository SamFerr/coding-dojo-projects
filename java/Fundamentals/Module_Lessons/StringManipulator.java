public class StringManipulator {
    public String trimAndConcat(String s1, String s2){
        return s1.trim() + s2.trim();
    }
    public Integer getIndexOrNull(String s3, char z){
        int indx = s3.indexOf(z);
        if(indx == -1){
            return null;
        }
        else{
            return indx;
        }
    }
    public Integer getIndexorNull(String s4, String s5){
        int indx = s4.indexOf(s5);
        if (indx == -1){
            return null;
        }
        else{
            return indx;
        }
    }
    public String concatSubstring(String x1, int int1, int int2, String x2){
        String substring = x1.substring(int1, int2);
        return substring + x2;
    }
}