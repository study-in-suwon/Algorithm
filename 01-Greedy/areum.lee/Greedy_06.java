package greedy;

import java.util.*;

class Food implements Comparable<Food> {

    // 음식의 시간 & 순서
    int time;
    int idx;

    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    // compareTo 메소드
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long food_sum = 0;  // 모든 음식 먹는데 걸리는 총 시간
        for (int i = 0; i < food_times.length; i++) {
            food_sum += food_times[i];
        }

        if (food_sum <= k) return -1;

        // (음식 시간, 순서) 쌍으로 우선순위 큐에 저장
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long total = 0;   // 먹기 위해 사용한 시간
        long previous = 0;  // 직전에 다 먹은 음식 시간
        long length = food_times.length;    // 남은 음식 개수

        while (total + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            total += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.idx, b.idx);
            }
        });

        return result.get((int) ((k - total) % length)).idx;
    }
}