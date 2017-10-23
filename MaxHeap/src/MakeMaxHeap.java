import java.util.ArrayList;

public class MakeMaxHeap {
    public static void main(String args[]) {
        /*
        // tests for buildHeap, heapify, getMax, isHeap, heapSort.
        MxHeap mH = new MxHeap();
        MxHelper.printHeapArray(mH.getHeapArr().toString());
        mH.buildHeap();
        MxHelper.printHeapArray(mH.getHeapArr().toString());
        if (mH.getIsHeap()) {
            System.out.println("Heap is built\n");
        }
        mH.heapSort();
        MxHelper.printSortedArray(mH.getSortedArr().toString());
        */

        MxHeap mH3 = new MxHeap();
        mH3.heapify(4);
        MxHelper.printHeapArray(mH3.getHeapArr().toString());
        mH3.heapInsert(8);
        MxHelper.printHeapArray(mH3.getHeapArr().toString());
        /*
        try {
            int max = mH3.getMax();
            System.out.println("max: " + max);
        } catch (Exception e) {
            // e.printStackTrace();
            String message = e.getMessage();
            System.out.println(message);
        }
        */
    }   // end main.
}       // end MakeMaxHeap class.
