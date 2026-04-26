import java.util.*;

public class AlienDictionaryTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        String[] test1 = {"z","o"};
        String result1 = solution.foreignDictionary(test1);
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Expected: zo, Got: " + result1);
        System.out.println("Pass: " + "zo".equals(result1) + "\n");
        
        // Test Case 2
        String[] test2 = {"hrn","hrf","er","enn","rfnn"};
        String result2 = solution.foreignDictionary(test2);
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Expected: hernf, Got: " + result2);
        System.out.println("Pass: " + "hernf".equals(result2) + "\n");
        
        // Test Case 3 - THE PROBLEMATIC ONE
        String[] test3 = {"wrt","wrf","er","ett","rftt","te"};
        String result3 = solution.foreignDictionary(test3);
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Expected: wertf, Got: " + result3);
        System.out.println("Pass: " + "wertf".equals(result3) + "\n");
        
        // Test Case 4
        String[] test4 = {"abc", "bat", "ade"};
        String result4 = solution.foreignDictionary(test4);
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Expected: (empty string), Got: " + result4);
        System.out.println("Pass: " + "".equals(result4) + "\n");
        
        // Test Case 5 - Single word
        String[] test5 = {"z"};
        String result5 = solution.foreignDictionary(test5);
        System.out.println("Test 5: " + Arrays.toString(test5));
        System.out.println("Expected: z, Got: " + result5);
        System.out.println("Pass: " + "z".equals(result5) + "\n");
    }
}
