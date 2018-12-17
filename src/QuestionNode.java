public class QuestionNode {

    public String data;
    public QuestionNode right; // no
    public QuestionNode left; // yes

    public QuestionNode(String data){
        this(data,null,null);
    }

    public QuestionNode(String data, QuestionNode right, QuestionNode left){
        this.data = data;
        this.right = right;
        this.left = left;
    }
}
