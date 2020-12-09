//// CS 445 Fall 2020
//// Help with Assignment 2 -- one way of doing one of the
//// constructor methods plus the toString() method.
//// Carefully read over this code, since it can give you hints to
//// other methods.
//
//// Create a new MyStringBuilder which contains the contents of the
//// String argument.
//public MyStringBuilder(String s)
//{
//	if (s == null || s.length() == 0) // Special case for empty String
//	{					 			  // or null reference
//		firstC = null;
//		lastC = null;
//		length = 0;
//	}
//	else
//	{
//		// Create front node to get started
//		firstC = new CNode(s.charAt(0));
//		length = 1;
//		CNode currNode = firstC;
//		// Create remaining nodes, copying from String.  Note
//		// how each new node is simply added to the end of the
//		// previous one.  Trace this to see what is going on.
//		for (int i = 1; i < s.length(); i++)
//		{
//			CNode newNode = new CNode(s.charAt(i));
//			currNode.next = newNode;
//			currNode = newNode;
//			length++;
//		}
//		lastC = currNode;
//	}
//}
//
//// Create and return a String from the characters in the
//// MyStringBuilder.  To do this efficiently, we first make
//// an array of the appropriate size, fill it with the
//// characters, and then construct and return a String from
//// that array.  Note that generally you CANNOT use arrays to
//// implement your methods but for this method (and substring()
//// also) we are using an array just for the purposes of
//// storing the characters in order to return a new String.
//public String toString()
//{
//	char [] c = new char[length];  // Make array of correct size
//	int i = 0;
//	CNode currNode = firstC;
//	while (currNode != null)   	// Iterate through the MyStringBuilder
//	{							// putting the characters into the
//		c[i] = currNode.data;	// correct positions in the array
//		i++;
//		currNode = currNode.next;
//	}
//	return new String(c);	// return a new String from the array
//}
//
