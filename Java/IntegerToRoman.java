public String intToRoman(int num) {
    int[] digits = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
    int len = digits.length;
    for (int i = 0; i < len; i++) {
        while (num >= digits[i]) {
            num -= digits[i];
            sb.append(romans[i]);
        }
    }
    return sb.toString();
}
