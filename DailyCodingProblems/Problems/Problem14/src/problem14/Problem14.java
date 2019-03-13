/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem14;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Aaron Schrock
 */
public class Problem14 {

    /*
    This problem was asked by Snapchat.

    Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

    For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
     */
    
    static class TimeInterval {
        int start;
        int end;
        
        TimeInterval(int x, int y) {
            start = x; 
            end = y;
        }
    }
    
    static class SortByStart implements Comparator<TimeInterval> {

        @Override
        public int compare(TimeInterval t, TimeInterval t1) {
            return t.start - t1.start;
        } 
    }
    static class SortByEnd implements Comparator<TimeInterval> {

        @Override
        public int compare(TimeInterval t, TimeInterval t1) {
            return t.end - t1.end;
        } 
    }
    
    public static int minRooms(TimeInterval[] intervals) {
        int count = 0;
        int maxCount = 0;
        int start = 0;
        int end = 0;
        Arrays.sort(intervals, new SortByStart());
        TimeInterval[] endIntervals = intervals;
        Arrays.sort(endIntervals, new SortByEnd());
        
        while(start < intervals.length && end < endIntervals.length) {
            if(start == intervals.length) {
                count--;
                end++;
            }
            else if (end == intervals.length) {
                count++;
                start++;
            }
            else if(intervals[start].start <= endIntervals[end].end) {
                count++;
                start++;
            }
            else {
                count--;
                end++;
            }
            if(count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
    
    public static void main(String[] args) {
        //[(30, 75), (0, 50), (60, 150)]
        TimeInterval t1 = new TimeInterval(30, 75);
        TimeInterval t2 = new TimeInterval(0, 50);
        TimeInterval t3 = new TimeInterval(60, 150);
        TimeInterval[] intervals = new TimeInterval[3];
        intervals[0] = t1;
        intervals[1] = t2;
        intervals[2] = t3;
        System.out.println(minRooms(intervals));
    }
    
}
