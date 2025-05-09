import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<Person> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            float weight = Float.parseFloat(st.nextToken());

            list.add(new Person(name, height, weight));
        }

        Collections.sort(list, (o1, o2) -> o1.name.compareTo(o2.name));
        sb.append("name").append("\n");
        for(Person p : list) {
            sb.append(p.name)
            .append(" ")
            .append(p.height)
            .append(" ")
            .append(p.weight)
            .append("\n");
        }

        Collections.sort(list, (o1, o2) -> o2.height - o1.height);
        sb.append("\n").append("height").append("\n");
        for(Person p : list) {
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
        int height;
        float weight;

        Person(String name, int height, float weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}