package greedy;

import java.util.*;

class Food implements Comparable<Food> {

    // ������ �ð� & ����
    int time;
    int idx;

    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    // compareTo �޼ҵ�
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long food_sum = 0;  // ��� ���� �Դµ� �ɸ��� �� �ð�
        for (int i = 0; i < food_times.length; i++) {
            food_sum += food_times[i];
        }

        if (food_sum <= k) return -1;

        // (���� �ð�, ����) ������ �켱���� ť�� ����
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long total = 0;   // �Ա� ���� ����� �ð�
        long previous = 0;  // ������ �� ���� ���� �ð�
        long length = food_times.length;    // ���� ���� ����

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