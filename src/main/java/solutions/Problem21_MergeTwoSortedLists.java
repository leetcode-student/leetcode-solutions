package solutions;

public class Problem21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode curr = merged;
        while (list1 != null || list2 != null) {
            if (list1 == null
                || (list1 != null && list2 != null && list2.val < list1.val)) {
                ListNode list2Head = list2;
                list2 = list2.next;
                list2Head.next = null;

                curr.next = list2Head;
                curr = list2Head;
            } else {
                ListNode list1Head = list1;
                list1 = list1.next;
                list1Head.next = null;

                curr.next = list1Head;
                curr = list1Head;
            }
        }
        return merged.next;
    }
}
