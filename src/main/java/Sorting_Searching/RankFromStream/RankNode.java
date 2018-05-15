package Sorting_Searching.RankFromStream;

public class RankNode {
    final int value;
    int leftSubtreeCount;
    RankNode left;
    RankNode right;

    public RankNode(int value) {
        this.value = value;
        this.leftSubtreeCount = 1;
    }

    public void insert(int newValue){
        if(value < newValue){
            if (right == null)
                right = new RankNode(newValue);
            else{
                right.insert(newValue);
            }
        } else if(value > newValue){
            leftSubtreeCount++;
            if (left == null){
                left = new RankNode(newValue);
            }
            else{
                left.insert(newValue);
            }
        } else {
            leftSubtreeCount++;
        }
    }
}
