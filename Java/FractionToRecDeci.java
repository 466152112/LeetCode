// The key insight here is to notice that once the remainder starts repeating, so does the divided result.
// Also int*int or int/int will overflow in some case, Integer.MIN_VALUE*-1
public String fractionToDecimal(int numerator, int denominator) {
  if (denominator == 0)
      return "NaN";
  if (numerator == 0)
      return "0";
  StringBuilder result = new StringBuilder();
  Long n = new Long(numerator);
  Long d = new Long(denominator);
  // negative or positive
  if (n*d < 0)
      result.append("-");
  n = Math.abs(n);
  d = Math.abs(d);
  result.append(Long.toString(n / d));
  // result is integer or float
  if (n % d == 0)
      return result.toString();
  else
      result.append(".");
  // deal with the float part
  // key is the remainder, value is the start positon of possible repeat numbers
  HashMap<Long, Integer> map = new HashMap<Long, Integer>();
  Long r = n % d; 
  while (r > 0) {
      if (map.containsKey(r)) {
          result.insert(map.get(r), "(");
          result.append(")");
          break;
      }
      map.put(r, result.length());
      r *= 10;
      result.append(Long.toString(r / d));
      r %= d;
  }
  return result.toString();
}
