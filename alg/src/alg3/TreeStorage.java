package alg3;

import alg2.Datenspeicher;
import alg2.Keyable;

public class TreeStorage implements Datenspeicher {
    
    private AbstractTreeNode root;

    @Override
    public void insert(Keyable o) {
        TreeNode newNode = new TreeNode(o);
        if (root == null) root = newNode;
        else {
            AbstractTreeNode nr = root.insert(newNode);
            root = nr;
        }
    }

    
    public String toString() {
        if (root == null) return "leerer Baum";
        else return root.toString();
    }
    
    @Override
    public Keyable get(int key) {
        if (root == null) return null;
        else return root.getObjectForKey(key);
    }

    @Override
    public Keyable getMaximum() {
        if (root == null) return null;
        else return root.getMaximumNodeInSubTree().getData();
    }

    @Override
    public Keyable getMinimum() {
        if (root == null) return null;
        else return root.getMinimumNodeInSubTree().getData();
    }

    @Override
    public Keyable remove(int key) {
        if (root == null) return null;
        else {
            AbstractTreeNode[] pair =  root.delete(key);
            root = pair[0];
            if (pair[1] != null) return pair[1].getData();
            else return null;
        }
    }

    @Override
    public void remove(Keyable o) {
        if (root != null) root = root.delete(o);
    }

    @Override
    public boolean contains(Keyable o) {        
        return (root != null) && (root.search(o) != null);
    }

    @Override
    public boolean contains(int key) {
        return (root != null) && (root.search(key) != null);
    }

    @Override
    public Keyable getSuccessor(Keyable o) {
        if (root == null) return null;
        else {
            AbstractTreeNode k = root.search(o);            
            if (k != null) {
                AbstractTreeNode s = k.getSuccessor(); 
                if (s != null) return s.getData();
            } 
            return null;
        }
    }

    @Override
    public Keyable getPredecessor(Keyable o) {
        if (root == null) return null;
        else {
            AbstractTreeNode k = root.search(o);            
            if (k != null) {
                AbstractTreeNode p = k.getPredecessor(); 
                if (p != null) return p.getData();
            } 
            return null;
        }
    }

    @Override
    public int size() {
        if (root == null) return 0;
        else return root.getSubtreeSize();
    }

    @Override
    public void clear() {
        root = null;
    }

}
