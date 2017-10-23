import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MxHelperTest extends TestCase {
    public void testPrintHeapArray() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
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
        MxHelper.printHeapArray(mH.getHeapArr().toString());

        // the BAOS object gets the output data.
        String actual = myOut.toString();
        assertEquals(expected, actual);

        // return the former system output to normal.
        System.out.flush();
        System.setOut(oldStream);
    }

    public void testPrintSortedArray() throws Exception {
        MxHeap mH = new MxHeap();
        mH.buildHeap();
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
        MxHelper.printSortedArray(mH.getSortedArr().toString());

        // the BAOS object gets the output data.
        String actual = myOut.toString();
        assertEquals(expected, actual);

        // return the former system output to normal.
        System.out.flush();
        System.setOut(oldStream);
    }
}