package com.algo.finalTerm;

/**
 * @author Arya Soman
 *Given a string containing only three types of characters: '(', ')' and '*', write a function to
check whether this string is valid. We define the validity of a string by these rules:
1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or
an empty string.
5. An empty string is also valid.

*Greedy method used for finding solution
 */

public class Solution4 
{
	public boolean checkValidString(String s)
	{
		int low = 0;
		int high = 0;
	    for (char c: s.toCharArray()) 
	    {
	    	if(c == '(' )
	    		low++;
	    	else
	    		low--;
	    	
	    	if(c != ')' )
	    		high++;
	    	else
	    		high--;
	       
	       if (high < 0) 
	    	   break;
	       low = Math.max(low, 0);
	    }
	    if(low == 0)
	       return true;
	    else
	    	return false;
       
	}
	public static void main(String[] args) 
	{
		Solution4 sol = new Solution4();
		System.out.println(sol.checkValidString("(*)"));
	}

}
