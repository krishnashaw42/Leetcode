class Solution {
    public int romanToInt(String s) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int num = 0;
        
        for (int i = 0; i < value.length; i++) {
            while (s.startsWith(roman[i])) {
                num += value[i];
                s = s.substring(roman[i].length());
            }
        }
        return num;
    }
}