import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        HashSet<Integer> bSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            bSet.add(bCards[i]);
        }
        
        int[] aCards = new int[n];
        int aCardIdx = 0;
        for(int i = 1; i <= 2*n; i++) {
            if(!bSet.contains(i)) {
                aCards[aCardIdx++] = i;
            }
        }

        Arrays.sort(aCards);
        Arrays.sort(bCards);

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