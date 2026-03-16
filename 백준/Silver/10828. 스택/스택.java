import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyStack stack = new MyStack();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }

    static class MyStack {
        private int[] arr = new int[10000];
        private int top = -1;

        public void push(int x) {
            arr[++top] = x;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return arr[top--];
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[top];
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        Stack<Integer> stack = new Stack<>();
//
//        int N = Integer.parseInt(br.readLine());
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            String cmd = st.nextToken();
//            switch(cmd) {
//                case "push" :
//                    stack.push(Integer.parseInt(st.nextToken()));
//                    break;
//                case "pop" :
//                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
//                    break;
//                case "size":
//                    sb.append(stack.size()).append('\n');
//                    break;
//                case "empty":
//                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
//                    break;
//                case "top":
//                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
//                    break;
//            }
//        }
//
//        System.out.print(sb);
//    }
//}