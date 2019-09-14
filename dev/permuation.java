
/**
 * Write a description of class Permutation2 here.
 this is a test a java exercise and also a git test
 *
 * @author Yvan Ramos
 * @version (11/09/2019_2)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
public class Permutation
{
    public static void main(String[] args) {

    Permutation p = new Permutation();
    String s = "A 3B2 C6D";
    String[] resultFinal =p.solution(s); 
    System.out.print(Arrays.toString(resultFinal));

  }

  public String[] solution(String input) throws NumberFormatException {
    String strDigit = "";
    String[] res;
    strDigit = checkIfCharacterisANumber(input);
    int l = strDigit.length();
    List<String> result = new ArrayList<String>();
    permute(strDigit, 0, l - 1, result);

    Collections.sort(result, Collections.reverseOrder());
     res = new String[result.size()];
    for (int i = 0; i< result.size(); i++) {
      
      res[i] = result.get(i);
    }
    return res;
  }

  public String checkIfCharacterisANumber(String input) {
    String temp = "";
    for (int i = 0; i <= input.length() - 1; i++) {
      if (Character.isDigit(input.charAt(i)))
        temp = temp + input.charAt(i);
    }
    return temp;
  }

  
  public void permute(String s, int limitInf, int limitSup, List<String> res) {
    if (limitInf == limitSup)
      res.add(s);
    else {
      for (int i = limitInf; i <= limitSup; i++) {
        s = swap(s, limitInf, i);
        permute(s, limitInf + 1, limitSup, res);
      }
    }
  }

  public String swap(String s, int a, int b) {
    char temp;
    char[] charArray = s.toCharArray();
    temp = charArray[a];
    charArray[a] = charArray[b];
    charArray[b] = temp;
    return String.valueOf(charArray);

  }
}
