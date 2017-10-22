import junit.framework.TestCase;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class MxHeapTest extends TestCase {
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
        mH.buildHeap(mH.getArrMaxPos());
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
        value = mH.getArrAtPos(6);
        assertEquals(value, 10);
    }

    public void testSetArrAtPos() throws Exception {
        MxHeap mH = new MxHeap();
        int value = mH.getArrAtPos(3);
        assertEquals(value, 2);
        mH.setArrAtPos(3, 5);
        value = mH.getArrAtPos(3);
        assertEquals(value, 5);
    }

    public void testGetIsHeap() throws Exception {
        MxHeap mH = new MxHeap();
        boolean value = mH.getIsHeap();
        assertEquals(value, false);
        mH.buildHeap(9);
        value = mH.getIsHeap();
        assertEquals(value, true);
    }

    public void testGetHeapArr() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap(9);
        ArrayList<Integer> newArr = mH.getHeapArr();
        assertEquals(newArr.toString(), mH.getHeapArr().toString());
    }

    public void testGetSortedArr() throws Exception {
        MxHeap mH = new MxHeap();
        mH.heapSort();
        ArrayList<Integer> newArr = mH.getSortedArr();
        assertEquals(newArr.toString(), mH.getSortedArr().toString());
    }

    public void testGetExtractMax() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap(9);
        int top = mH.extractMax();
        assertEquals(top, 16);
    }

    public void testHeapSort() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap(9);
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

    public void testPrintSortedArr() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap(9);
        mH.heapSort();
        String expected = "sortedArr: [16, 14, 10, 9, 8, 7, 4, 3, 2, 1]\n\n";

        // assign the existing PrintStream to a variable.
        PrintStream oldStream = System.out;
        // instantiate a BAOS.
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        // give a new PrintStream the BAOS object as input.
        PrintStream ps = new PrintStream(myOut);
        // send the system output to the new PrintStream object.
        System.setOut(ps);

        // the print method goes to system out.
        mH.printSortedArr();

        // the BAOS object gets the output data.
        String actual = myOut.toString();
        assertEquals(expected, actual);

        // return the former system output to normal.
        System.out.flush();
        System.setOut(oldStream);
    }

    public void testPrintHeapArr() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap(9);
        String expected = "heapArr: [16, 14, 10, 8, 7, 3, 9, 1, 4, 2]\n\n";

        // assign the existing PrintStream to a variable.
        PrintStream oldStream = System.out;
        // instantiate a BAOS object.
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        // give a new PrintStream the BAOS object as input.
        PrintStream ps = new PrintStream(myOut);
        // send the system output to the new PrintStream object.
        System.setOut(ps);

        // the print method goes to system out.
        mH.printHeapArr();

        // the BAOS object gets the output data.
        String actual = myOut.toString();
        assertEquals(expected, actual);

        // return the former system output to normal.
        System.out.flush();
        System.setOut(oldStream);
    }
}