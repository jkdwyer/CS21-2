import java.util.ArrayList;

/**
 * MxHeap class
 * - contains an array that will be sorted in place into a heap.
 * - contains vars for stop position, array size, max pos in array and heap size.
 */
public class MxHeap {
    private int stopPosition = 0;
    private int arrSize = 0;
    private int arrMaxPos = 0;
    private int heapSize = 0;
    private ArrayList<Integer> heapArr = new ArrayList<Integer>();
    private ArrayList<Integer> sortedArr = new ArrayList<Integer>();
    private boolean isHeap = false;
    private boolean isHeapified = false;
    private boolean isSorted = false;
    private int heapifiedSize = 0;

    public MxHeap() {
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
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
    }

    public MxHeap(ArrayList<Integer> arr) {
        heapArr = arr;
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
    }

    public int getArrSize() {
        return arrSize;
    }

    public int getArrMaxPos() {
        return arrMaxPos;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int getHeapifiedSize() {
        return heapifiedSize;
    }

    public int getArrAtPos(int index) {
        return heapArr.get(index);
    }

    public void setArrAtPos(int index, int value) {
        heapArr.set(index, value);
    }

    public ArrayList<Integer> getHeapArr() {
        return heapArr;
    }

    public ArrayList<Integer> getSortedArr() {
        return sortedArr;
    }

    public boolean getIsHeap() {
        return isHeap;
    }

    public boolean getIsHeapified() {
        return isHeapified;
    }

    public boolean getIsSorted() {
        return isSorted;
    }

    public int getSortAtPos(int index) {
        return sortedArr.get(index);
    }

    /**
     * peek() method
     * - does not alter data, so it can be used on any ArrayList.
     * @return  element in first position of ArrayList.
     * @throws Exception
     */
    public int peek() throws Exception {
        return heapArr.get(0);
    }

    /**
     * parent() method
     * - parent calculation for arrays starting at position zero.
     * @param pos
     * @return int
     */
    public int parent(int pos) {
        // Math.floor() only accepts double.
        double parentCalc = ((pos-1)/2);
        // Double can be converted to an intValue.
        Double parentDbl = Math.floor(parentCalc);
        // then return an int position.
        int parentPos = parentDbl.intValue();
        return parentPos;
    }


    /**
     * leftChild() method
     * - left child calculation for arrays starting at position zero.
     * @param pos
     * @return int
     */
    public int leftChild(int pos) {
        int leftPos = ((2*pos)+1);
        return leftPos;
    }


    /**
     * rightChild() method
     * - right child calculation for arrays starting at position zero.
     * @param pos
     * @return
     */
    public int rightChild(int pos) {
        int rightPos = ((2*pos)+2);
        return rightPos;
    }


    /**
     * swap() method
     * - exchanges value in pos1 with value in pos2 of ArrayList.
     * @param pos1
     * @param pos2
     */
    public void swap(int pos1, int pos2) {
        int val1 = heapArr.get(pos1);
        int val2 = heapArr.get(pos2);
        heapArr.set(pos1, val2);
        heapArr.set(pos2, val1);
    }


    /**
     * heapify() method
     * - gets called once with any position in array, then
     *      creates a partial heap from position zero to incomingPos,
     *      leaving position incomingPos+1 through arrMaxPos untouched.
     * @param incomingPos
     */
    public void heapify(int incomingPos) {
        // initialize end position to leftChild of first element.
        int endPos = leftChild(stopPosition);
        // TODO:  make this work for partial heap.
        while (endPos <= incomingPos) {
            siftUp(endPos);
            endPos++;
        }
        isHeapified = true;
        heapifiedSize = (incomingPos+1);
    }


    /**
     * buildHeap() method
     * - gets called once and creates a complete heap from heapArr.
     */
    public void buildHeap() {
        // initialize end position to leftChild of first element.
        int endPos = leftChild(stopPosition);
        while (endPos <= arrMaxPos) {
            siftUp(endPos);
            endPos++;
        }
        isHeap = true;
        heapSize = arrSize;
    }


    /**
     * siftUp() method
     * - does a partial, recursive sort from any position in the ArrayList.
     * @param endPos
     */
    public void siftUp(int endPos) {
        // TODO:  remove this output.
        // System.out.println("siftUp - endPos: " + endPos + " heapArr: " + heapArr + "\n");
        int childPos = endPos;
        while (childPos > stopPosition) {
            int parentPos = parent(childPos);
            if (heapArr.get(childPos) > heapArr.get(parentPos)) {
                swap(parentPos, childPos);
                childPos = parentPos;
                // TODO:  remove this output.
                // System.out.println("recursive call");
                // recursive call.
                siftUp(childPos);
            } else {
                childPos = parentPos;
                // no swap needed.
            }
        }
    }


    public int extractMax() throws Exception {
        if (isHeap) {
            int max = heapArr.get(0);
            ArrayList<Integer> sortedArr = new ArrayList<Integer>();
            heapArr.remove(0);
            // reset size and max position, then re-build the heap.
            arrSize = heapArr.size();
            arrMaxPos = (arrSize-1);
            buildHeap();
            return max;
        } else {
            throw new Exception("Error: extractMax() can only be used on a completed heap.");
        }
    }


    /**
     * heapSort() method
     * - take the heap and process each element into a sorted array.
     * - method should only be allowed to work on a completed heap.
     */
    public void heapSort() throws Exception {
        if (isHeap) {
            int maxPos = arrMaxPos;
            for (int i = 0; i <= maxPos; i++) {
                int topVal = extractMax();
                sortedArr.add(i, topVal);
            }
            isSorted = true;
        } else {
            throw new Exception("Error: heapSort() can only be used on a completed heap.");
        }
    }


    /**
     * heapInsert() method
     * - method is adding elements from end of heapArr to partial heap
     *      in the same array, so it accepts a position argument.
     * - method should only be allowed to work on a partial heap.
     * @param pos
     */
    public void heapInsert(int pos) throws Exception {
        if (isHeapified) {
            if (pos == heapifiedSize) {
                // pos is next element.
                heapify(heapifiedSize);
            } else {
                // pos is any subsequent element.
                int desVal = heapArr.get(pos);
                int hsVal = heapArr.get(heapifiedSize);
                heapArr.set(heapifiedSize, desVal);
                int j = 1;
                int nextVal = hsVal;
                while ((heapifiedSize+j) <= pos) {
                    hsVal = heapArr.get(heapifiedSize+j);
                    heapArr.set((heapifiedSize+j), nextVal);
                    nextVal = hsVal;
                    j++;
                }
                // TODO:  remove this output.
                // System.out.println("heapArr: " + heapArr + "\n");
                // now that desVal is the next element...
                heapify(heapifiedSize);
            }
        } else {
            throw new Exception ("Error:  heapInsert() can only be used on a partial heap.");
        }
    }


    /**
     * heapAddNewValue() method
     * - method takes a new element value from an outside source
     *      and adds it to a completed heap.
     * - method should only be allowed to work on a completed heap.
     * @param value
     */
    public void heapAddNewValue(int value) throws Exception {
        if (isHeap) {
            // TODO:  remove this output.
            // System.out.println("value: " + value + "\n");
            heapArr.add(value);
            arrSize = heapArr.size();
            arrMaxPos = (arrSize-1);
            buildHeap();
        } else {
            throw new Exception("Error: heapAddNewValue() can only be used on a completed heap.");
        }
    }
}   // end MxHeap class.
