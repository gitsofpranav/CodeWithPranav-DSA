import java.util.*;
public class lca {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }


        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);

        if(left || right){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node LCA(Node root, int n, int m){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2= new ArrayList<>();

        getPath(root,n,path1);
        getPath(root,m,path2);

        int i=0;
        for(; i<path1.size() && i< path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left   = new Node(6);
        root.right.right = new Node(7);

        int n = 4;
        int m = 5;
        System.out.println(LCA(root, n, m).data);
    }
}
