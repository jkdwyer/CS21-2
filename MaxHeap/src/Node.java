public class Node {
    private int payload;
    private int priority;
    private Node parent;
    private Node left;
    private Node right;

    /**
     * default no-args constructor.
     */
    public Node() {
        payload = 0;
        priority = 0;
    }

    /**
     * constructor, takes int arg for payload.
     * @param data
     */
    public Node(int data) {
        payload = data;
        priority = 0;
    }

    /**
     * setPayload() method accepts int.
     * @param data
     */
    public void setPayload(int data) {
        payload = data;
    }

    /**
     * getPayload() method returns int.
     * @return int
     */
    public int getPayload() {
        return payload;
    }

    /**
     * setPriority() method accepts int.
     * @param data
     */
    public void setPriority(int data) {
        priority = data;
    }

    /**
     * getPriority() method returns int.
     * @return int
     */
    public int getPriority() {
        return priority;
    }

    /**
     * setParent() method accepts Node.
     * @param node
     */
    public void setParent(Node node) {
        parent = node;
    }

    /**
     * getParent() method returns Node.
     * @return Node
     */
    public Node getParent() {
        return parent;
    }

    /**
     * setLeft() method accepts Node.
     * @param node
     */
    public void setLast(Node node) {
        left = node;
    }

    /**
     * getLeft() method returns Node.
     * @return left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * setRight() method accepts Node.
     * @param node
     */
    public void setRight(Node node) {
        right = node;
    }

    /**
     * getRight() method returns Node.
     * @return right
     */
    public Node getRight() {
        return right;
    }
}
