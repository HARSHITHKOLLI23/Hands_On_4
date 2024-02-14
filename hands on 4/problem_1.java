import java.util.*;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of arrays (K): ");
        int K = scanner.nextInt();

        System.out.print("Enter the size of each array (N): ");
        int N = scanner.nextInt();

        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            List<Integer> array = new ArrayList<>();
            System.out.print("Enter elements for array " + (i + 1) + ": ");
            for (int j = 0; j < N; j++) {
                array.add(scanner.nextInt());
            }
            arrays.add(array);
        }

        List<Integer> mergedArray = mergeSortedArrays(arrays);
        System.out.println("Merged sorted array: " + mergedArray);

        scanner.close();
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        for (int i = 0; i < arrays.size(); i++) {
            if (!arrays.get(i).isEmpty()) {
                minHeap.offer(new Element(i, 0, arrays.get(i).get(0)));
            }
        }

        while (!minHeap.isEmpty()) {
            Element element = minHeap.poll();
            result.add(element.value);
            int nextIndex = element.index + 1;
            if (nextIndex < arrays.get(element.arrayIndex).size()) {
                minHeap.offer(new Element(element.arrayIndex, nextIndex, arrays.get(element.arrayIndex).get(nextIndex)));
            }
        }

        return result;
    }

    static class Element {
        int arrayIndex;
        int index;
        int value;

        Element(int arrayIndex, int index, int value) {
            this.arrayIndex = arrayIndex;
            this.index = index;
            this.value = value;
        }
    }
}
