package com.datastructure.ses3;

import java.util.Stack;

public class Parser
{
    private Stack<Character> _stack;

    public Parser()
    {
        _stack = new Stack<>();
    }

    public boolean Parse(String str)
    {
        this._stack.clear();

        // Foreach Character c in String str
        for (char c : str.toCharArray())
        {
            // Check is we need to push the character to the stacks
            if(PushToStack(c))
            {
                // Push to stack
                this._stack.push(c);
            }
            // Check if we need to remove/pop from the stack
            else if(RemoveFromStack(c))
            {
                // Find the char in the other direction
                char reverseChar = this.GetReverseChar(c);
                // Take/pop the last char on the stack
                char poppedChar = this._stack.pop();

                // If they are not equal the parsing has failed
                if(reverseChar != poppedChar)
                    return false;
            }
        }

        // If the stack isn't empty after parsing the parsing has failed
        if(!this._stack.empty())
            return false;

        return true;
    }

    // Check if a char should be removed from the stack
    public boolean RemoveFromStack(char c)
    {
        return c == ')' || c == ']' || c == '}';
    }

    // Check if a char should be added to the stack
    private boolean PushToStack(char c)
    {
        return c == '(' || c == '[' || c == '{';
    }

    // Find the char in the other direction
    private char GetReverseChar(char c)
    {
        switch (c)
        {
            case '(':
                return ')';
            case ')':
                return '(';
            case '[':
                return ']';
            case ']':
                return '[';
            case '{':
                return '}';
            case '}':
                return '{';
            default:
                return '\0';
        }
    }
}
