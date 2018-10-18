package data.structures;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {

    public static final int DFS = 1;
    public static final int BFS = 2;

    private TreeNode<T> root;

    public Tree(@NotNull TreeNode<T> root) {
        this.root = root;
    }

    public Tree(@NotNull TreeNode<T> root, @NotNull TreeNode<T>... children) {
        this(root);
        for (TreeNode child : children) {
            root.addChild(child);
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    private void printDFS(@NotNull TreeNode<T> root, @NotNull String spaces) {
        System.out.println(spaces + root.getValue());
        TreeNode<T> child;

        for (int i = 0; i < root.getChildrenCount(); i++) {
            child = root.getChild(i);
            printDFS(child, spaces + " ");
        }
    }

    private void printBFS(@NotNull TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode<T> current = queue.remove();
            System.out.println("Checked TreeNode with value = " + current.getValue());
            if (current.hasChildren()) {
                queue.addAll(current.getChildren());
            }
        }
    }

    public void print(int searchAlgorithmType) {
        switch (searchAlgorithmType) {
            case DFS:
                printDFS(root, "");
                break;
            case BFS:
                printBFS(root);
                break;
            default:
                printDFS(root, "");
        }
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
            for (TreeNode child : children) {
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

        @NotNull
        public TreeNode<T> getChild(int position) {
            if (position < 0 && position > children.size()) {
                throw new IllegalArgumentException("Child at position " + position + "does not exist");
            }
            return children.get(position);
        }

        @NotNull
        public T getValue() {
            return value;
        }

        @NotNull
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
