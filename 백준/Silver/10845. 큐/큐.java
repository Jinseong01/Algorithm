import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyQueue queue = new MyQueue();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }

    static class MyQueue {
        int[] arr = new int[10000];
        int front = 0;
        int back = -1;

        public void add(int x) {
            arr[++back] = x;
        }

        public int poll() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front++];
        }

        public int peekFirst() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int peekLast() {
            if(isEmpty()) {
                return -1;
            }
            return arr[back];
        }

        public int size() {
            return back - front + 1;
        }

        public boolean isEmpty() {
            return front > back;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        int N = Integer.parseInt(br.readLine());
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String cmd = st.nextToken();
//
//            switch (cmd) {
//                case "push":
//                    queue.add(Integer.parseInt(st.nextToken()));
//                    break;
//                case "pop":
//                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
//                    break;
//                case "size":
//                    sb.append(queue.size()).append('\n');
//                    break;
//                case "empty":
//                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
//                    break;
//                case "front":
//                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
//                    break;
//                case "back":
//                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
//                    break;
//            }
//        }
//
//        System.out.print(sb);
//    }
//}