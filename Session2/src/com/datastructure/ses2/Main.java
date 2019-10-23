package com.datastructure.ses2;

public class Main
{

    public static void main(String[] args)
    {
        LList<Integer> list = RandomGenerator.GenerateRandomLinkedList(10,0,20);
        PrintList(list);
        //Remove6(list);

        list.moveToPos(2);
        list.insertHere(21);
        PrintList(list);
        list.removeHere();
        PrintList(list);
    }

    public static void PrintList(LList<Integer> list)
    {
        System.out.println(list.toString());
    }

    public static void Remove6(LList<Integer> list)
    {
        //Move to 5 because remove, removes the next element
        list.moveToPos(5);
        list.remove();

        PrintList(list);
    }
}
