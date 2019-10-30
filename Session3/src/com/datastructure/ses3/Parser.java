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
        for (char c : str.toCharArray())
        {
            if(PushToStack(c))
            {
                this._stack.push(c);
            }
            else if(RemoveFromStack(c))
            {
                char reverseChar = this.GetReverseChar(c);
                char poppedChar = this._stack.pop();

                if(reverseChar != poppedChar)
                    return false;
            }
        }

        if(!this._stack.empty())
            return false;

        return true;
    }

    public boolean RemoveFromStack(char c)
    {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean PushToStack(char c)
    {
        return c == '(' || c == '[' || c == '{';
    }

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
