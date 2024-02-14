import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the original array from the user
        System.out.print("Enter the original array (space-separated integers): ");
        String inputString = scanner.nextLine();
        String[] subStrings = inputString.split(" ");
        List<Integer> originalArray = new ArrayList<>();
        for (String subString : subStrings) {
            originalArray.add(Integer.parseInt(subString));
        }

        // Create a sorted copy of the original array
        List<Integer> sortedArray = new ArrayList<>(originalArray);
        Collections.sort(sortedArray);

        // Remove duplicates from the sorted array
        List<Integer> result = removeDuplicates(sortedArray);

        // Print the original array, sorted array, and array without duplicates
        System.out.println("Original array: " + originalArray);
        System.out.println("Sorted array: " + sortedArray);
        System.out.println("Array without duplicates: " + result);

    }

    // Function to remove duplicates from a sorted list
    public static List<Integer> removeDuplicates(List<Integer> array) {
        // If the input array is empty, return an empty list
        if (array.isEmpty()) {
            return new ArrayList<>();
        }

        // Initialize the result list with the first element of the input array
        List<Integer> result = new ArrayList<>();
        result.add(array.get(0));

        // Iterate over the input array and add elements to the result only if they are different from the previous element
        for (int i = 1; i < array.size(); i++) {
            if (!array.get(i).equals(array.get(i - 1))) {
                result.add(array.get(i));
            }
        }

        return result;
    }
}
