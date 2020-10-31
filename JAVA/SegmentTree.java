package org.arpit.java2blog;
 
import java.util.Scanner;
 
public class SegmentTree {
 
	static int[] segArr;
 
	public static void main(String[] args) {
 
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
 
		// array on which operations / queries will be performed.
		for (int i = 0; i  0) {
			int check = scn.nextInt();
 
			if (check == 1) {
				int ql = scn.nextInt();
				int qr = scn.nextInt();
 
				System.out.println(getQuery(0, 0, arr.length - 1, ql, qr, arr));
			} else {
 
				int idx = scn.nextInt();
				int value = scn.nextInt();
				update(value, idx, 0, 0, arr.length - 1, arr);
 
			}
		}
 
 
	}
 
	public static int construct(int saIdx, int left, int right, int[] arr) {
		/*
		 * if the segment is of length one, then we know it will be 
		 * a left node and hence it will contain an element of the given array
		 */
		if (left == right) {
			/*
			 * element at the current index of segArr will be the element 
			 * present at index left or right in given array, 
			 * as left is equal to right so we can take either of them
			 */
			return segArr[saIdx] = arr[left];
		}
 
		/*
		 * current segment of parent node is divided into two halves, 
		 * if the segment for parent is [left, right], then 
		 * segment for left child will be [left, mid] and 
		 * segment for right child will be [mid+1, right].
		 */
		int mid = (left + right) / 2;
		int leftChild = construct(2 * saIdx + 1, left, mid, arr);
		int rightChild = construct(2 * saIdx + 2, mid + 1, right, arr);
		/*
		 * result of the current node will be calculated 
		 * in the post order after calculating
		 *  the result for its children
		 */
		segArr[saIdx] = leftChild + rightChild;
		return segArr[saIdx];
	}
 
 
	// saIdx - pointer for the segment array.
	// left - left limit of the current segment.
	// right - right limit of the current segment.
	// ql - left limit of the given query segment.
	// qr - right limit of the given query segment.
 
	public static int getQuery(int saIdx, int left, int right, int ql, int qr, int[] arr) {
 
 
		/*
		 * if the range of the query lies completely outside the range of 
		 * the current segment, we return a value which contributes nothing 
		 * to the final answer,that 0 in the case when sum is to be calculated for given range.
		 */
		if (left > qr || right = ql && right <= qr) {
			return segArr[saIdx];
		} else {
			/*
			 * if there is an overlap in the segments of the query and the node, 
			 * then we recur for both of its children, as there will be a contribution 
			 * in result from both of the sides.
			 */ 
			int mid = (left + right) / 2;
			int leftResult = getQuery(2 * saIdx + 1, left, mid, ql, qr, arr);
			int rightResult = getQuery(2 * saIdx + 2, mid + 1, right, ql, qr, arr);
			return leftResult + rightResult;
		}
 
	}
 
	public static void update(int value, int idx, int saIdx, int left, int right, int[] arr) {
		/*
		 * if the index lies outside the range of the current segment 
		 * then there is no need for an update/call at that index, 
		 * so simply return.
		 */
		if (idx  right) {
			return;
		}
		/*
		 * if we found the index to be updated, we update the given array 
		 * as well as the segment array that is the node which has the 
		 * segment equal to given index.
		 */
		if (idx == left && idx == right) {
			arr[left] = value;
			segArr[saIdx] = value;
			return;
		}
		/*
		 * now in post order we need to update all the nodes
		 *  which contains the given index in their segment
		 */
		else {
			int mid = (left + right) / 2;
			update(value, idx, 2 * saIdx + 1, left, mid, arr);
			update(value, idx, 2 * saIdx + 2, mid + 1, right, arr);
 
			segArr[saIdx] = segArr[2 * saIdx + 1] + segArr[2 * saIdx + 2];
		}
	}
 
}
 
