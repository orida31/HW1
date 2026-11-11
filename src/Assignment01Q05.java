import java.util.Arrays;

public class Assignment01Q05 {
    public static int[] update(int [] a, int[][] m){
        int [] re = new int[m.length];
        for (int k = 0; k < m.length; k++){
            re[k] = a[k];
        }
        for (int j = 0; j < m.length; j++){
            if (a[j] == 1){
                for (int i = 0; i < m.length; i++){
                    if (m[j][i] == 1){
                    re[i] = 1; 
                    }
                }
            }
        }
        return re;
    }

    public static int findShortestPath(int[][] m, int i, int j) {
        if (i==j){
            return 0;
        }
        int cnt = 0;
        int [] visited = new int[m.length];
        visited [i] = 1;
        while (true){
            int [] updated_arr = update(visited,m);
            cnt++;
            if (updated_arr[j] == 1){
                return cnt;
            }
            if (Arrays.equals(visited, updated_arr)){
                return -1;
            }
            visited = updated_arr;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}