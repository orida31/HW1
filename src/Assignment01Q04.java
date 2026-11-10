import java.util.Arrays;

public class Assignment01Q04 {
    public static void step(int[] array, char direction){
        int move = 1;
        if (direction == 'L'){
                move = -1 * move;
            }
                int cnt = 0;
                int curr = array[0];
                int curr_idx = 0;
                while (cnt < array.length){
                    int next_idx = (curr_idx + move) % array.length;
                    while (next_idx < 0){
                        next_idx = array.length + next_idx;
                    }
                    int next = array[next_idx];
                    array[next_idx] = curr;
                    curr = next;
                    curr_idx = next_idx;
                    cnt++; 
                }
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (array.length <= 1 || move == 0){
            return array;
        }
        move = move % array.length;
        if (direction != 'L' && direction != 'R'){
            return array;
        }
        if (move < 0){
            move = -1 * move;
            direction = (direction == 'R') ? 'L' : 'R';
        }
        for (int i = 0; i < move; i++){
            step(array,direction);
        }
                
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4}, 2, 'R'))); //[3, 4, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}