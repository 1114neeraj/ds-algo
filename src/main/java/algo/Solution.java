package algo;

import java.util.Stack;

class Solution {
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		Stack<Integer> stack1 = this.createStack(l1);
		Stack<Integer> stack2 = this.createStack(l2);

		ListNode result = this.add(stack1, stack2);
		return this.reverse(result);

	}

	private Stack<Integer> createStack(ListNode list) {

		Stack<Integer> stack = new Stack<>();

		while(list != null ) {

			stack.push(list.val);
			list = list.next;

		}

		return stack;

	}

	private ListNode reverse(ListNode head) {

		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;

		while(current != null) {

			next = current.next;

			current.next = prev;

			prev = current;

			current = next;

		}

		return prev;

	}

	private ListNode add(Stack<Integer> stack1, Stack<Integer> stack2) {

		ListNode head = null;
		ListNode itr = null;

		int carry = 0;

		while(!stack1.empty() && !stack2.empty()) {
			
			int sum = carry + stack1.pop() + stack2.pop();
			
			ListNode temp = new ListNode(sum%10, null);
			
			if(head == null) {
				head = temp;
				itr = head;
			}
			else {
				itr.next = temp;
				itr = temp;
			}
			
			carry = sum/10;

		}

		while(!stack1.empty()) {
			
			int sum = carry + stack1.pop();
			
			ListNode temp = new ListNode(sum%10, null);
			
			itr.next = temp;
			itr = temp;

			carry = sum/10;

		}

		while(!stack2.empty()) {
			
			int sum = carry + stack2.pop();
			
			ListNode temp = new ListNode(sum%10, null);
			
			itr.next = temp;
			itr = temp;

			carry = sum/10;

		}
		
		if(carry > 0) {
			ListNode temp = new ListNode(carry, null);
			itr.next = temp;
			itr = temp;
		}

		return head;

	}
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		ListNode l1 = new ListNode(9, new ListNode(9, null));
		
		ListNode l2 = new ListNode(1, null);
		
		ListNode result = solution.addTwoNumbers(l1, l2);
		
		while(result != null) {
			
			System.out.println(result.val);
			result = result.next;
			
		}
		
		
		
	}
	
}