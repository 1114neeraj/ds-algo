package leetcode.april30day.week2;

public class MiddleLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode middleNode(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast!=null && fast.next!=null) {
			slow = slow.next;
		}
		
		return slow;
	}
	
}
