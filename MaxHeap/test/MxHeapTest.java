import junit.framework.TestCase;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class MxHeapTest extends TestCase {
    public void testMxHeap() throws Exception {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        newArr.add(5);
        newArr.add(7);
        newArr.add(18);
        newArr.add(3);
        newArr.add(20);
        String expected = "[5, 7, 18, 3, 20]";
        MxHeap mH2 = new MxHeap(newArr);
        String actual = mH2.getHeapArr().toString();
        assertEquals(expected, actual);
        mH2.buildHeap();
        expected = "[20, 18, 7, 3, 5]";
        actual = mH2.getHeapArr().toString();
        assertEquals(expected, actual);
    }

    public void testParent() throws Exception {
        MxHeap mH = new MxHeap();
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
        mH.swap(3,4);
        int newPos3val = mH.getArrAtPos(3);
        int newPos4val = mH.getArrAtPos(4);
        assertEquals(2, newPos4val);
        assertEquals(16, newPos3val);
    }

    public void testHeapify() throws Exception {
        MxHeap mH = new MxHeap();
        mH.heapify(4);
        String expectedArr = "[16, 4, 3, 1, 2, 9, 10, 14, 8, 7]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);

        MxHeap mH2 = new MxHeap();
        mH2.heapify(6);
        expectedArr = "[16, 4, 10, 1, 2, 3, 9, 14, 8, 7]";
        actualArr = mH2.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

    public void testBuildHeap() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
        String expectedArr = "[16, 14, 10, 8, 7, 3, 9, 1, 4, 2]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

    public void testSiftUp() throws Exception {
        MxHeap mH = new MxHeap();
        mH.siftUp(5);
        String expectedArr = "[9, 1, 4, 2, 16, 3, 10, 14, 8, 7]";
        String actualArr = mH.getHeapArr().toString();
        assertEquals(expectedArr, actualArr);
    }

    public void testGetHeapSize() throws Exception {
        MxHeap mH = new MxHeap();
        int size = mH.getHeapSize();
        assertEquals(size, 0);
        mH.buildHeap();
        int size2 = mH.getHeapSize();
        assertEquals(size2, 10);
    }

    public void testGetHeapifiedSize() throws Exception {
        MxHeap mH = new MxHeap();
        int size = mH.getHeapifiedSize();
        assertEquals(size, 0);
        mH.heapify(4);
        int size2 = mH.getHeapifiedSize();
        assertEquals(size2, 5);
    }

    public void testGetArrSize() throws Exception {
        MxHeap mH = new MxHeap();
        int size = mH.getArrSize();
        assertEquals(size, 10);
    }

    public void testGetArrMaxPos() throws Exception {
        MxHeap mH = new MxHeap();
        int max = mH.getArrMaxPos();
        assertEquals(max, 9);
    }

    public void testGetArrAtPos() throws Exception {
        MxHeap mH = new MxHeap();
        int value = mH.getArrAtPos(3);
        assertEquals(value, 2);
        int value2 = mH.getArrAtPos(6);
        assertEquals(value2, 10);
    }

    public void testSetArrAtPos() throws Exception {
        MxHeap mH = new MxHeap();
        int value = mH.getArrAtPos(3);
        assertEquals(value, 2);
        mH.setArrAtPos(3, 5);
        int value2 = mH.getArrAtPos(3);
        assertEquals(value2, 5);
    }

    public void testGetIsHeap() throws Exception {
        MxHeap mH = new MxHeap();
        boolean value = mH.getIsHeap();
        assertEquals(value, false);
        mH.buildHeap();
        boolean value2 = mH.getIsHeap();
        assertEquals(value2, true);
    }

    public void testGetIsHeapified() throws Exception {
        MxHeap mH = new MxHeap();
        boolean value = mH.getIsHeapified();
        assertEquals(value, false);
        mH.heapify(4);
        boolean value2 = mH.getIsHeapified();
        assertEquals(value2, true);
    }

    public void testGetHeapArr() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
        ArrayList<Integer> newArr = mH.getHeapArr();
        assertEquals(newArr.toString(), mH.getHeapArr().toString());
    }

    public void testGetSortedArr() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
        mH.heapSort();
        ArrayList<Integer> newArr = mH.getSortedArr();
        assertEquals(newArr.toString(), mH.getSortedArr().toString());
    }

    public void testExtractMax() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
        int top = mH.extractMax();
        assertEquals(top, 16);
    }

    public void testExtractMax_Exception() throws Exception {
        MxHeap mH = new MxHeap();
        String message = "";
        String expected = "Error: extractMax() can only be used on a completed heap.";
        try {
            mH.extractMax();
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }

    public void testHeapSort() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
        mH.heapSort();
        int value;
        value = mH.getSortAtPos(0);
        assertEquals(16, value);
        value = mH.getSortAtPos(1);
        assertEquals(14, value);
        value = mH.getSortAtPos(2);
        assertEquals(10, value);
        value = mH.getSortAtPos(3);
        assertEquals(9, value);
        value = mH.getSortAtPos(4);
        assertEquals(8, value);
        value = mH.getSortAtPos(5);
        assertEquals(7, value);
        value = mH.getSortAtPos(6);
        assertEquals(4, value);
        value = mH.getSortAtPos(7);
        assertEquals(3, value);
        value = mH.getSortAtPos(8);
        assertEquals(2, value);
        value = mH.getSortAtPos(9);
        assertEquals(1, value);
    }

    public void testHeapSort_Exception() throws Exception {
        MxHeap mH = new MxHeap();
        String message = "";
        String expected = "Error: heapSort() can only be used on a completed heap.";
        try {
            mH.heapSort();
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }

    public void testHeapInsert() throws Exception {
        MxHeap mH = new MxHeap();
        mH.heapify(4);
        mH.heapInsert(7);
        String expected = "[16, 4, 14, 1, 2, 3, 9, 10, 8, 7]";
        assertEquals(expected, mH.getHeapArr().toString());
        MxHeap mH2 = new MxHeap();
        mH2.heapify(4);
        mH2.heapInsert(8);
        String expected2 = "[16, 4, 8, 1, 2, 3, 9, 10, 14, 7]";
        assertEquals(expected2, mH2.getHeapArr().toString());
    }

    public void testHeapInsert_Exception() throws Exception {
        MxHeap mH = new MxHeap();
        String message = "";
        String expected = "Error:  heapInsert() can only be used on a partial heap.";
        try {
            mH.heapInsert(8);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }

    public void testHeapAddNewValue() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
        String expected = "[16, 14, 10, 8, 12, 3, 9, 1, 4, 2, 7]";
        int newVal = 12;
        mH.heapAddNewValue(newVal);
        assertEquals(expected, mH.getHeapArr().toString());
    }

    public void testHeapAddNewValue_Exception() throws Exception {
        MxHeap mH = new MxHeap();
        int newVal = 12;
        String message = "";
        String expected = "Error: heapAddNewValue() can only be used on a completed heap.";
        try {
            mH.heapAddNewValue(newVal);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(expected, message);
    }
}