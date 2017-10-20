import junit.framework.TestCase;

import java.util.ArrayList;

public class MxHeapTest extends TestCase {
    public void testParent() throws Exception {
        MxHeap mH = new MxHeap();
        ArrayList<Integer> heapArr = new ArrayList<Integer>();
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        int parentOfPos0 = mH.parent(0);
        assertEquals(0, parentOfPos0);
        int parentOfPos1 = mH.parent(1);
        assertEquals(0, parentOfPos1);
        int parentOfPos2 = mH.parent(2);
        assertEquals(0, parentOfPos2);
        int parentOfPos3 = mH.parent(3);
        assertEquals(1, parentOfPos3);
        int parentOfPos4 = mH.parent(4);
        assertEquals(1, parentOfPos4);
        int parentOfPos5 = mH.parent(5);
        assertEquals(2, parentOfPos5);
        int parentOfPos6 = mH.parent(6);
        assertEquals(2, parentOfPos6);
        int parentOfPos7 = mH.parent(7);
        assertEquals(3, parentOfPos7);
        int parentOfPos8 = mH.parent(8);
        assertEquals(3, parentOfPos8);
        int parentOfPos9 = mH.parent(9);
        assertEquals(4, parentOfPos9);
    }

    public void testLeftChild() throws Exception {
        MxHeap mH = new MxHeap();
        ArrayList<Integer> heapArr = new ArrayList<Integer>();
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        int leftChildOfPos0 = mH.leftChild(0);
        assertEquals(1, leftChildOfPos0);
        int leftChildOfPos1 = mH.leftChild(1);
        assertEquals(3, leftChildOfPos1);
        int leftChildOfPos2 = mH.leftChild(2);
        assertEquals(5, leftChildOfPos2);
        int leftChildOfPos3 = mH.leftChild(3);
        assertEquals(7, leftChildOfPos3);
        int leftChildOfPos4 = mH.leftChild(4);
        assertEquals(9, leftChildOfPos4);
        // pos5, pos6, pos7, pos8 and pos9 have no leftChild.
    }

    public void testRightChild() throws Exception {
        MxHeap mH = new MxHeap();
        ArrayList<Integer> heapArr = new ArrayList<Integer>();
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        int rightChildOfPos0 = mH.rightChild(0);
        assertEquals(2, rightChildOfPos0);
        int rightChildOfPos1 = mH.rightChild(1);
        assertEquals(4, rightChildOfPos1);
        int rightChildOfPos2 = mH.rightChild(2);
        assertEquals(6, rightChildOfPos2);
        int rightChildOfPos3 = mH.rightChild(3);
        assertEquals(8, rightChildOfPos3);
        // pos4, pos5, pos6, pos7, pos8 and pos9 have no rightChild.
    }

    public void testSwap() throws Exception {
        MxHeap mH = new MxHeap();
        ArrayList<Integer> heapArr = new ArrayList<Integer>();
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        mH.swap(heapArr,3,4);
        int newPos3val = heapArr.get(3);
        int newPos4val = heapArr.get(4);
        assertEquals(2, newPos4val);
        assertEquals(16, newPos3val);
    }

    public void testBuildHeap() throws Exception {
        MxHeap mH = new MxHeap();
        ArrayList<Integer> heapArr = new ArrayList<Integer>();
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        int maxPos = (heapArr.size()-1);
        mH.buildHeap(heapArr, maxPos);
        String expectedArr = "[16, 14, 10, 8, 2, 3, 9, 1, 4, 7]";
        String actualArr = heapArr.toString();
        assertEquals(expectedArr, actualArr);
    }

    public void testSiftUp() throws Exception {
        MxHeap mH = new MxHeap();
        ArrayList<Integer> heapArr = new ArrayList<Integer>();
        heapArr.add(4);
        heapArr.add(1);
        heapArr.add(3);
        heapArr.add(2);
        heapArr.add(16);
        heapArr.add(9);
        heapArr.add(10);
        heapArr.add(14);
        heapArr.add(8);
        heapArr.add(7);
        mH.siftUp(heapArr,5);
        String expectedArr = "[9, 1, 4, 2, 16, 3, 10, 14, 8, 7]";
        String actualArr = heapArr.toString();
        assertEquals(expectedArr, actualArr);
    }
}