### [Challenge Name: Encryption](/contests/slate-top-hacker/challenges/encryption)


An English text needs to be encrypted using the following encryption scheme.  
First, the spaces are removed from the text. Let $L$ be the length of this text.  
Then, characters are written into a grid, whose rows and columns have the following constraints:

$$\lfloor\sqrt{L}\rfloor \le row \le column \le \lceil\sqrt{L}\rceil\text{, where }\lfloor x \rfloor \text{ is floor function and }\lceil x \rceil\text{ is ceil function}$$ 
 
For example, the sentence $s = \texttt{if man was meant to stay on the ground god would have given us roots}$, after removing spaces is $54$ characters long.  $\sqrt{54}$ is between $7$ and $8$, so it is written in the form of a grid with 7 rows and 8 columns. 

    ifmanwas  
    meanttos          
    tayonthe  
    groundgo  
    dwouldha  
    vegivenu  
    sroots

+ Ensure that $rows \times columns \ge L$   
+ If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. $rows \times columns$.  

The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:  
    
`imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau`  
    
You will be given a message to encode and print.

**Function Description**  

Complete the *encryption* function in the editor below.  It should return a single string composed as described.  

encryption has the following parameter(s):  

- *s*: a string to encrypt  


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        
         if(s !=null && s.length() > 0){

            String strWithoutSpace = s.replaceAll("\\s", "");
            if(strWithoutSpace.matches("^[a-z]+$"))
            {

                double length = (double)strWithoutSpace.length();
                int rows = (int)Math.floor(Math.sqrt(length));
                int columns = (int)Math.ceil(Math.sqrt(length));

                while(!(rows*columns >= (int)length)){
                      rows = rows + 1;
                }

                char[][] array2 = new char [rows][columns];
                int index = 0;
                List<Character> characters = new ArrayList<Character>();
                for(int row=0; row<rows; row++){

                    for (int col = 0; col < columns; col++)
                    {
                        if(index < strWithoutSpace.length()) {
                            array2[row][col] = strWithoutSpace.charAt(index);
                            index++;
                        }
                        else break;

                    }

                }

                index = 0;
                for (int col = 0; col < columns; col++)
                {
                    for (int row = 0; row < rows; row++)
                    {
                            if (array2[row][col] != 0) {
                                characters.add(index, array2[row][col]);
                                index++;
                            }

                        else break;

                    }
                    characters.add(index, ' ');
                    index++;
                }


                return characters.toString().replaceAll(", |\\[|\\]", "");

            }
            else {
                return "Input doesn't meet the criteria of ascii [a-z]";
            }


        }
        else{
            return "Input is Empty";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
