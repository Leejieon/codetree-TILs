import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[50000];
        HashSet<Integer> bSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            bSet.add(i);
        }
        
        int[] aCards = new int[50000];
        int aCardIdx = 0;
        for(int i = 1; i <= 2*n; i++) {
            if(!bSet.contains(i)) {
                aCards[aCardIdx++] = i;
            }
        }

        Arrays.sort(aCards, 0, n);
        Arrays.sort(bCards, 0, n);

        int ans = 0;
        int bIdx = 0;
        for(int aIdx = 0; aIdx < n; aIdx++) {
            if(bIdx < n && aCards[aIdx] > bCards[bIdx]) {
                ans++;
                bIdx++;
            }
        }
        System.out.println(ans);
    }
}