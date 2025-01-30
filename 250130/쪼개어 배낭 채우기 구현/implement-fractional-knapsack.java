import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.perCost, o1.perCost));
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            double value = Double.parseDouble(st.nextToken());

            pq.add(new Jewelry(weight, value));
        }

        double cost = 0.0;
        while(!pq.isEmpty()) {
            Jewelry jewelry = pq.poll();

            if(jewelry.weight <= M) {
                cost += jewelry.value;
                M -= jewelry.weight;
            } else {
                cost += jewelry.perCost * M;
                break;
            }
        }

        System.out.println(String.format("%.3f", cost));
    }

    static class Jewelry {
        int weight;
        double value;
        double perCost;

        Jewelry(int weight, double value) {
            this.weight = weight;
            this.value = value;
            this.perCost = value / weight;
        }
    }
}