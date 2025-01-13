import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<PartTimeJob> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int salary = Integer.parseInt(st.nextToken());

            list.add(new PartTimeJob(start, end, salary));
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.end == o2.end) {
                return o2.salary - o1.salary;
            }
            return o1.end - o2.end;
        });

        int[] dp = new int[N];
        dp[0] = list.get(0).salary;
        for(int i = 1; i < N; i++) {
            dp[i] = list.get(i).salary;
            for(int j = 0; j < i; j++) {
                if(list.get(j).end < list.get(i).start) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).salary);
                }
            }
        }

        int rst = Arrays.stream(dp)
            .max()
            .orElse(0);
        
        System.out.println(rst);
    }
    

    static class PartTimeJob {
        int start, end, salary;

        PartTimeJob(int start, int end, int salary) {
            this.start = start;
            this.end = end;
            this.salary = salary;
        }
    }
}