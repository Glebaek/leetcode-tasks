package com.gorodkovgleb;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {

    /*
    "FizzBuzz" task from LeetCode.
    Given an integer n, return a string array answer (1-indexed) where:
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
     */

    public List<String> fizzBuzz(int n) {

        List<String> fizzBuzzArr = new ArrayList<String>();
        String temp = null;

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzArr.add("FizzBuzz");
            } else if(i % 3 == 0) {
                fizzBuzzArr.add("Fizz");
            } else if(i % 5 == 0) {
                fizzBuzzArr.add("Buzz");
            } else {

                temp = Integer.toString(i);
                fizzBuzzArr.add(temp);

            }

        }

        return fizzBuzzArr;
    }

    /*
    "Add two numbers" task from LeetCode.
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null && l2 != null) {

            current.val = current.val + ((l1.val + l2.val) % 10);

            if(((l1.val + l2.val) > 9) || (current.val > 9))
                current.next = new ListNode(1);
            else if (l1.next != null || l2.next != null)
                current.next = new ListNode(0);

            if(current.val > 9)
                current.val = current.val % 10;

            if(l1.next != null && l2.next == null)
                l2.next = new ListNode(0);

            if(l1.next == null && l2.next != null)
                l1.next = new ListNode(0);

            current = current.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        return result;
    }

    /*
    "Longest Substring Without Repeating Characters" task from LeetCode.
    Given a string s, find the length of the longest
    substring
    without repeating characters.

    I've implemented this solution using Sliding Window technique with HashSet as sliding window.
     */

    public static int qLengthOfLongestSubstring(String s) {

        int[] chars = new int[128];
        int result = 0;
        int size = s.length();

        int left = 0;
        int right = 0;

        while (right < size) {
            char rightCh = s.charAt(right);
            chars[rightCh]++;

            while (chars[rightCh] > 1) {
                char leftCh = s.charAt(left);
                chars[leftCh]--;
                left++;
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }


    public static void main(String[] args) {

        String str = "jklmnopoopwekkewaeprogjhaslfkpsj";

        System.out.println(qLengthOfLongestSubstring(str));

    }
}
