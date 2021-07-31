package lesson3;

/**
 * Нахождение интервала повторений искомого элемента в массиве [начало, окончание]
 */
public class SequenceOfElementsSearch {

    public static int search(Integer[] arr, int num) {

        int start = 0;
        int end = arr.length - 1;
        int base;
        int seqBegin;
        int seqEnd;
        int i = 0;

        while (end >= start && num >= arr[start] && num <= arr[end]) {
            i++;
            base = (start + end) / 2;
            if (arr[base] == num) {

                seqBegin = base;
                seqEnd = base;
                start = 0;
                while (end != start && seqBegin != 0 && arr[seqBegin - 1] == num) {
                    end = seqBegin - 1;
                    while (end >= start && arr[start] <= num) {
                        i++;
                        base = (start + end) / 2;
                        if (arr[base] == num) {
                            seqBegin = base;
                            break;
                        } else if (arr[base] > num) {
                            end = base - 1;
                        } else {
                            start = base + 1;
                        }
                    }
                }

                end = arr.length - 1;
                while (end != start && seqEnd != arr.length - 1 && arr[seqEnd + 1] == num) {
                    start = seqEnd + 1;
                    while (end >= start && arr[end] >= num) {
                        i++;
                        base = (start + end) / 2;
                        if (arr[base] == num) {
                            seqEnd = base;
                            break;
                        } else if (arr[base] > num) {
                            end = base - 1;
                        } else {
                            start = base + 1;
                        }
                    }
                }

                System.out.println("[" + seqBegin + ", " + seqEnd + "]");
                return i;// количество итераций

            } else if (arr[base] > num) {
                end = base - 1;
            } else {
                start = base + 1;
            }
        }


        return -1;
    }
}
