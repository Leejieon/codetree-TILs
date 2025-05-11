import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.height == o2.height) return o2.weight - o1.weight;
            return o1.height - o2.height;
        });
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Person(name, height, weight));
        }

        while(!pq.isEmpty()) {
            Person p = pq.poll();
            sb.append(p.name)
            .append(" ")
            .append(p.height)
            .append(" ")
            .append(p.weight)
            .append("\n");
        }
        System.out.print(sb);
    }

    static class Person {
        String name;
        int height, weight;

        Person(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}