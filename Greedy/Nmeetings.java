import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nmeetings {

    /***
     * Problem Statement: There is one meeting room in a firm. You are given two
     * arrays, start and end each of size N.For an index ‘i’, start[i] denotes the
     * starting time of the ith meeting while end[i] will denote the ending time of
     * the ith meeting. Find the maximum number of meetings that can be accommodated
     * if only one meeting can happen in the room at a particular time. Print the
     * order in which these meetings will be performed.
     */

    /***
     * Sort the meetings in ascending order of the time
     * Store the limit as the end time of current meeting
     * Maintain an array to store the answers
     */

    public static class Meeting {
        int start;
        int end;
        int position;

        public Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    public  static class MeetingComparator implements Comparator<Meeting> {
        public int compare(Meeting meeting1, Meeting meeting2) {

            boolean meeting1EndsEarly = meeting1.end < meeting2.end;
            boolean meeting1EndsLate = meeting1.end > meeting2.end;

            if (meeting1EndsEarly) {
                return -1;
            } else if (meeting1EndsLate) {
                return 1;
            } else if (meeting1.position < meeting2.position) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 5, 7, 9, 9 };

        List<Integer> answers = getMaxMeetings(start, end, n);

        for (int answer : answers) {
            System.out.print(answer + " ,");
        }
    }

    public static ArrayList<Integer> getMaxMeetings(int[] start, int[] end, int size) {

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meetings, new MeetingComparator());

        ArrayList<Integer> answers = new ArrayList<>();

        answers.add(meetings.get(0).position);

        int limit = meetings.get(0).end;

        for (int i = 1; i < meetings.size(); i++) {

            if (meetings.get(i).start > limit) {
                answers.add(meetings.get(i).position);
                limit = meetings.get(i).end;
            }
        }

        return answers;
    }
}
