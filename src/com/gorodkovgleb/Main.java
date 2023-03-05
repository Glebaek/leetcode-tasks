package com.gorodkovgleb;

import com.sun.source.tree.Tree;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class Main {

    static int maxDepth = 0;

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




    /*
    "Permutations" task from LeetCode.
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.

    I perform this task using recursive method and a map of taken elements.
    */

    public static void recursiveList(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] map, int size) {

        for (int i = 0; i < size; i++) {
            if(map[i] == false) {
                temp.add(nums[i]);
                map[i] = true;
                recursiveList(result, temp, nums, map, size);
                map[i] = false;
            }

        }

        if(temp.size() == size) {
            List<Integer> copy = new ArrayList<Integer>(temp);
            result.addAll(Collections.singleton(copy));
        }

        if(temp.size() != 0)
            temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        int size = nums.length;
        boolean[] map = new boolean[size];

        recursiveList(result, temp, nums, map, size);

        return result;
    }



    /*
    "Maximum depth of binary tree" task from LeetCode.
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    */

    public static int recursiveDepth(TreeNode node, int depth) {

        depth++;

        if(maxDepth < depth)
            maxDepth = depth;

        if (node.right != null)
            recursiveDepth(node.right, depth);


        if (node.left != null)
            recursiveDepth(node.left, depth);


        return maxDepth;
    }

    public static int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        int depth = 0;

        depth = recursiveDepth(root, depth);
        maxDepth = 0;


        return depth;
    }



    public static void main(String[] args) {

        String str = "jklmnopoopwekkewaeprogjhaslfkpsj";
        int[] nums = {4, 1, 2};
        List<List<Integer>> test = new ArrayList<List<Integer>>();

        TreeNode example = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        example.right.right = new TreeNode(4);

        int maxDepth = maxDepth(example);


        System.out.println(maxDepth);
        //test = permute(nums);
        //System.out.println(qLengthOfLongestSubstring(str));

    }
}
