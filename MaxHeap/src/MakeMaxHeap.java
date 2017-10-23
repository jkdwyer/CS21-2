public class MakeMaxHeap {
    public static void main(String args[]) {
        String message;
        int val = 1;

        // tests for buildHeap, heapify, peek, isHeap, heapSort.
        MxHeap mH = new MxHeap();
        MxHelper.printHeapArray(mH.getHeapArr().toString());
        mH.buildHeap();
        MxHelper.printHeapArray(mH.getHeapArr().toString());
        if (mH.getIsHeap()) {
            System.out.println("Heap is built");
        }
        // try this on a heap.
        int newVal = 12;
        try {
            mH.heapAddNewValue(newVal);
        } catch (Exception e) {
            // e.printStackTrace();
            message = e.getMessage();
            System.out.println(message);
        }
        MxHelper.printHeapArray(mH.getHeapArr().toString());

        try {
            mH.heapSort();
        } catch (Exception e) {
            // e.printStackTrace();
            message = e.getMessage();
            System.out.println(message);
        }
        if (mH.getIsSorted()) {
            System.out.println("Heap is sorted");
        }
        MxHelper.printSortedArray(mH.getSortedArr().toString());

        MxHeap mH2 = new MxHeap();
        // this is not a heap.
        try {
            mH2.heapAddNewValue(val);
        } catch (Exception e) {
            // e.printStackTrace();
            message = e.getMessage();
            System.out.println(message);
        }

        MxHeap mH3 = new MxHeap();
        mH3.heapify(4);
        MxHelper.printHeapArray(mH3.getHeapArr().toString());
        try {
            mH3.heapInsert(8);
        } catch (Exception e) {
            // e.printStackTrace();
            message = e.getMessage();
            System.out.println(message);
        }
        MxHelper.printHeapArray(mH3.getHeapArr().toString());

        try {
            int max = mH3.peek();
            System.out.println("max: " + max);
        } catch (Exception e) {
            // e.printStackTrace();
            message = e.getMessage();
            System.out.println(message);
        }

    }   // end main.
}       // end MakeMaxHeap class.
