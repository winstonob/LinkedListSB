// CS 0445 Fall 2020
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a singly linked list of nodes.  See more comments below on the specific
// requirements for the class.

// For more details on the general functionality of most of these methods,
// see the specifications of the similar method in the StringBuilder class.
public class MyStringBuilder
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder initialized with the chars in String s
	// Note: This method is implemented for you.  See A2Help.java
	public MyStringBuilder(String s)
	{
		if (s == null || s.length() == 0) {
			firstC = null;
			lastC = null;
			length = 0;
		} else {

			firstC = new CNode(s.charAt(0));
			CNode curNode = firstC;
			length = 1;
			for (int index = 1; index < s.length(); index++) {
				curNode.next = new CNode(s.charAt(index));
				curNode = curNode.next;
				length++;
			}
			lastC = curNode;
		}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
	{
		if (s == null || s.length == 0) {
			firstC = null;
			lastC = null;
			length = 0;
		}
		else {
			firstC = new CNode(s[0]);
			length = s.length;
			CNode curNode = firstC;
			for(int index = 1; index < length; index++)
			{
				curNode.next = new CNode(s[index]);
				curNode = curNode.next;
			}
			lastC = curNode;
		}

	}

	// Copy constructor -- make a new MyStringBuilder from an old one.  Be sure
	// that you make new nodes for the copy.
	public MyStringBuilder(MyStringBuilder old)
	{
			firstC = new CNode(old.firstC.data);
			length = old.length;

			CNode oldCurNode = old.firstC;
			CNode newCurNode = firstC;

			while(oldCurNode.next != null) {
				newCurNode.next = new CNode(oldCurNode.next.data);
				oldCurNode = oldCurNode.next;
				newCurNode = newCurNode.next;
			}

			lastC = new CNode(oldCurNode.data);
	}

	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		length = 0;
		firstC = null;
		lastC = null;
	}

	// Return the entire contents of the current MyStringBuilder as a String
	// For this method you should do the following:
	// 1) Create a character array of the appropriate length
	// 2) Fill the array with the proper characters from your MyStringBuilder
	// 3) Return a new String using the array as an argument, or
	//    return new String(charArray);
	// Note: This method is implemented for you.  See A2Help.java
	public String toString()
	{
		CNode curCNode = firstC;
		char[] cArray = new char[length];

		for(int index = 0; index < length; index++) {
			cArray[index] = curCNode.data;
			curCNode = curCNode.next;
		}
		return new String(cArray);
	}

	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
		// Edge Case: Provided MyStringBuilder is empty.
		if(b.length == 0) {
			return this;
		}

		// Constructing and storing the first node creating using the provided MyStringBuilder.
		CNode firstCB = new CNode(b.firstC.data);
		CNode bCurNode = b.firstC.next; // This is preemptively iterating the second node of the provided MyStringBuilder.

		// Edge Case: MyStringBuilder is empty.
		if(length == 0) {
			firstC = firstCB;
			lastC = firstC;
		}
		else {
			lastC.next = firstCB;
		}

		// Constructing remaining nodes using the provided MyStringBuilder.
		for (int index = 1; index < b.length; index++) {
			firstCB.next = new CNode(bCurNode.data);
			firstCB = firstCB.next;
			bCurNode = bCurNode.next;
		}
		lastC = firstCB;
		length += b.length;
		return this;
	}

	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		// Edge Case: Provided String is empty.
		if(s == null || s.length() == 0) {
			return this;
		}

		// Constructing and storing the first node creating using the provided String.
		CNode stringNode = new CNode(s.charAt(0));

		// Edge Case: Current MyStringBuilder is empty.
		if(length == 0) {
			firstC = stringNode;
			lastC = firstC;
		}
		else {
			lastC.next = stringNode;
		}

		// Constructing remaining nodes using the provided the String.
		for (int index = 1; index < s.length(); index++) {
			stringNode.next = new CNode(s.charAt(index));
			stringNode = stringNode.next;
		}
		lastC = stringNode;
		length += s.length();
		return this;
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
		// Edge Case: Provided Character Array is empty.
		if(c.length == 0) {
			return this;
		}

		// Constructing and storing the first node creating using the provided Character Array.
		CNode charNode = new CNode(c[0]);

		// Edge Case: Current MyStringBuilder is empty.
		if(length == 0) {
			firstC = charNode;
			lastC = firstC;
		}
		else {
			lastC.next = charNode;
		}

		// Constructing remaining nodes using the provided the Character Array.
		for (int index = 1; index < c.length; index++) {
			charNode.next = new CNode(c[index]);
			charNode = charNode.next;
		}
		lastC = charNode;
		length += c.length;
		return this;

	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		// Edge Case: Appending to an empty MyStringBuilder.
		if(firstC == null || length == 0) {
			firstC = new CNode(c);
			lastC = firstC;
			length = 1;
			return this;
		}

		lastC.next = new CNode(c);
		lastC = lastC.next;
		length++;
		return this;

	}

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		return getCNode(firstC, index).data;
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder,
	// only remove up until the end of the MyStringBuilder. Be careful for
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
		// Edge Case: MyStringBuilder is empty.
		if(length == 0) {
			return this;
		}

		// Edge Case: Invalid start/end position.
		if(end <= start || start < 0  || start > length) {
			return this;
		}

		// Edge Case: End index is greater than length of MyStringBuilder.
		if(end > length) {
			end = length;
		}

		int range = end - start;
		// Edge Case: If start index is located at the front of MyStringBuilder.
		if(start == 0) {
			firstC = getCNode(firstC, end);
		}
		// Normal Case.
		else {
			CNode beforeNode = getCNode(firstC, start - 1);
			CNode afterNode = getCNode(beforeNode, end - start + 1);
			beforeNode.next = afterNode;
		}

		length -= range;
		return this;
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		delete(index, index + 1);
		return this;
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		int index = 0;
		CNode curNode = firstC;

		while(curNode.next != null)
		{
			if(containsString(curNode, str))
				return index;

			curNode = curNode.next;
			index++;
		}
		return -1;
	}

	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" ==
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
		// Edge Case: The provided String is empty.
		if(str == null || str.length() == 0) {
			return this;
		}

		// Edge Case: Invalid Offset.
		if(offset < 0 || offset > length) {
			return this;
		}

		// Edge Case: Offset is located at the end of MyStringBuilder
		// While this isn't a case that would cause an error, it is much more efficient
		// to make a call back to a previously defined method that does as specified.
		if(offset == length) {
			append(str);
			return this;
		}

		CNode beforeNode;
		CNode afterNode;
		// Constructing and storing the first node creating using the provided String.
		CNode strCurNode = new CNode(str.charAt(0));

		// Determining the location in which the String will be inserted.
		// Edge Case: Offset is located at the front of MyStringBuilder.
		if(offset == 0) {
			afterNode = firstC;
			firstC = strCurNode;
		}
		else {
			beforeNode = getCNode(firstC, offset - 1);
			afterNode = beforeNode.next;
			beforeNode.next = strCurNode;
		}

		// Constructing remaining nodes using the provided the String.
		for (int index = 1; index < str.length(); index++) {
			strCurNode.next = new CNode(str.charAt(index));
			strCurNode = strCurNode.next;
		}
		strCurNode.next = afterNode;
		length += str.length();
		return this;
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid,
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
		// Edge Case: Invalid Offset.
		if(offset < 0 || offset > length) {
			return this;
		}

		// Edge Case: Offset is located at the end of MyStringBuilder
		// While this isn't a case that would cause an error, it is much more efficient
		// to make a call back to a previously defined method that does as specified.
		if(offset == length) {
			append(c);
			return this;
		}

		CNode beforeNode;
		CNode afterNode;
		// Constructing and storing the first node creating using the provided String.
		CNode charCurNode = new CNode(c);

		// Determining the location in which the String will be inserted.
		// Edge Case: Offset is located at the front of MyStringBuilder.
		if(offset == 0) {
			charCurNode.next = firstC;
			firstC = charCurNode;
			return this;
		}

		beforeNode = getCNode(firstC, offset - 1);
		afterNode = beforeNode.next;
		beforeNode.next = charCurNode;
		charCurNode.next = afterNode;
		length++;

		return this;
	}

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{
		// Edge Case: The provided String is empty.
		if(c == null || c.length == 0) {
			return this;
		}

		// Edge Case: Invalid Offset.
		if(offset < 0 || offset > length) {
			return this;
		}

		// Edge Case: Offset is located at the end of MyStringBuilder
		// While this isn't a case that would cause an error, it is much more efficient
		// to make a call back to a previously defined method that does as specified.
		if(offset == length) {
			append(c);
			return this;
		}

		CNode beforeNode;
		CNode afterNode;
		// Constructing and storing the first node creating using the provided String.
		CNode strCurNode = new CNode(c[0]);

		// Determining the location in which the String will be inserted.
		// Edge Case: Offset is located at the front of MyStringBuilder.
		if(offset == 0) {
			afterNode = firstC;
			firstC = strCurNode;
		}
		else {
			beforeNode = getCNode(firstC, offset - 1);
			afterNode = beforeNode.next;
			beforeNode.next = strCurNode;
		}

		// Constructing remaining nodes using the provided the String.
		for (int index = 1; index < c.length; index++) {
			strCurNode.next = new CNode(c[0]);
			strCurNode = strCurNode.next;
		}
		strCurNode.next = afterNode;
		length += c.length;
		return this;

	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder replace(int start, int end, String str)
	{
		// Edge Case: The provided String is empty.
		if(str == null || str.length() == 0) {
			return this;
		}

		// Edge Case: Invalid start/end index.
		if(end <= start || start > length || start < 0) {
			return this;
		}

		int curEnd = end;
		CNode curNode = firstC;
		CNode beforeNode = null;
		CNode afterNode;
		CNode strCurNode = new CNode(str.charAt(0));

		// Edge Case: End is located beyond the last index of MyStringBuilder
		if(end > length) {
			curEnd = length;
		}

		int range = curEnd - start;

		// Edge Case: Replacement starts at the front of MyStringBuilder.
		if(start == 0) {
			firstC = strCurNode;
			for (int index = 0; index < curEnd; index++) {
				curNode = curNode.next;
			}
			afterNode = curNode;
		} else {
			// Normal Case.
			// Logic for determining the location in which the String will be replaced.
			for (int index = 0; index < curEnd; index++) {
				if (index == start - 1)
					beforeNode = curNode;
				curNode = curNode.next;
			}
			afterNode = curNode;
			beforeNode.next = strCurNode;

		}
		// Constructing the String LList that will be inserted.
		for (int index = 1; index < str.length(); index++) {
			strCurNode.next = new CNode(str.charAt(index));
			strCurNode = strCurNode.next;
		}
		strCurNode.next = afterNode;
		length += (str.length() - range);
		return this;
	}

	// Reverse the characters in the current MyStringBuilder and then
	// return the current MyStringBuilder.
	public MyStringBuilder reverse()
	{
		lastC = firstC;
		CNode beforeNode = firstC;
		CNode curNode = firstC.next;
		CNode afterNode = curNode.next;

		// Logic for the first N - 2 CNodes
		// This can only be done for the first N - 2 before afterNode points to Null
		for (int index = 0; index < length - 3; index++) {
			curNode.next = beforeNode;
			beforeNode = curNode;
			curNode = afterNode;
			afterNode = afterNode.next;
		}
		// Final CNode reversal
		curNode.next = beforeNode;
		afterNode.next = curNode;
		firstC = afterNode;
		return this;
	}

	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder.  For this method
	// you should do the following:
	// 1) Create a character array of the appropriate length
	// 2) Fill the array with the proper characters from your MyStringBuilder
	// 3) Return a new String using the array as an argument, or
	//    return new String(charArray);
	public String substring(int start, int end)
	{
		int range = end - start;
		CNode curNode = firstC;
		char [] cArray = new char[range];

		// Edge Case: Invalid start/end index.
		if(end <= start || start > length || end > length || start < 0) {
			return "";
		}

		for(int index = 0; index < start; index++) {
			curNode = curNode.next;
		}
		for(int index = 0; index < range; index++ ) {
			cArray[index] = curNode.data;
			curNode = curNode.next;
		}

			return new String(cArray);
	}

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}

	// A helper method for finding nodes
	private CNode getCNode(CNode n, int index)
	{
		CNode node = n;
		for (int i = 0; i < index; i++)
			node = node.next;
		return node;
	}

	// A helper method for determining if a sequence of nodes matches a string
	private boolean containsString(CNode n, String s)
	{
		CNode curNode = n;
		int index = 0;

		//Second condition of if statement is very important
		//If we just check for curNode.next !=, reaching the end of the list will cut loop of early
		while(index < s.length() && curNode != lastC.next)
		{
			if (curNode.data != s.charAt(index))
				return false;
			curNode = curNode.next;
			index++;
		}

		if(index != s.length())
			return false;

		return true;
	}

	// An extra credit method.
	// Produces the same results as String.toLowerCase().
	public MyStringBuilder toLowerCase()
	{
		CNode curNode = firstC;
		while(curNode != null) {
			if (Character.isUpperCase(curNode.data))
			{
				curNode.data = Character.toLowerCase(curNode.data);
			}
			curNode = curNode.next;
		}
		return this;
	}

	// An extra credit method.
	// Produces the same results as String.toUpperCase().
	public MyStringBuilder toUpperCase()
	{
		CNode curNode = firstC;
		while(curNode!= null) {
			if (Character.isLowerCase(curNode.data))
			{
				curNode.data = Character.toUpperCase(curNode.data);
			}
			curNode = curNode.next;
		}
		return this;
	}

}

