import java.util.ArrayList;

public class MakeMaxHeap {
    public static void main(String args[]) {
        // TODO:  remove this output. no really.
        // System.out.println("in MakeMaxHeap.main");

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
        System.out.println("heapArr: " + heapArr + "\n");

        mH.buildHeap(heapArr, maxPos);

        // mH.siftUp(heapArr,9);
        System.out.println("heapArr: " + heapArr + "\n");
        // System.out.println(heapArr.toString());
        // System.out.println("parentOfPos0: " + parentOfPos0);

    }   // end main.
}       // end MakeMaxHeap class.
