package data.structures;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree(@NotNull TreeNode<T> root) {
        this.root = root;
    }

    public Tree(@NotNull TreeNode<T> root, @NotNull TreeNode<T>... children) {
        this(root);
        for (TreeNode child: children) {
            root.addChild(child);
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    private void printDFS(TreeNode<T> root, String spaces) {
        System.out.println(spaces + root.getValue());
        TreeNode<T> child;

        for (int i = 0; i < root.getChildrenCount(); i++) {
            child = root.getChild(i);
            printDFS(child, spaces + " ");
        }
    }

    public void print() {
        this.printDFS(this.root, "");
    }

    public static class TreeNode<T> {

        private T value;
        private boolean hasParent;
        private List<TreeNode<T>> children;

        public TreeNode(@NotNull T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
        public TreeNode(@NotNull T value, @NotNull TreeNode<T>... children) {
            this(value);
            for (TreeNode child: children) {
                addChild(child);
            }
        }

        public void addChild(@NotNull TreeNode<T> child) {
            if (child.hasParent) {
                throw new IllegalArgumentException("This child already has a parent");
            }
            child.hasParent = true;
            children.add(child);
        }

        public TreeNode<T> getChild(int position) {
            if (position < 0 && position > children.size()) {
                throw new IllegalArgumentException("Child at position " +position + "does not exist");
            }
            return children.get(position);
        }

        public T getValue() {
            return value;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }

        public int getChildrenCount() {
            return children.size();
        }

        public boolean hasChildren() {
            return children.size() > 0;
        }

    }

}
