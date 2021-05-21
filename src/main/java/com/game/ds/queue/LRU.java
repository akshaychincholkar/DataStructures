package com.game.ds.queue;

import java.util.*;

public class LRU {
    public static void main(String[] args) {
        int[] a = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int memorySize = 4;
//        int faults = findPageFaults(a,memorySize);
        int faults = pageFaults(a,a.length,memorySize);
        System.out.println("Total page faults: "+faults);
    }

    private static int findPageFaults(int[] a,int memory) {
        int pageFaults = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i= 0; i< a.length;i++){
            if(queue.size() < memory){
                ((LinkedList<Integer>) queue).add(a[i]);
                pageFaults++;
            }else{
                if(!queue.contains(a[i])){
                    int lru = Integer.MAX_VALUE,index = Integer.MIN_VALUE;
                    Iterator<Integer> iterator = queue.iterator();
                    while(iterator.hasNext()){
                        int temp = iterator.next();
                        if(map.get(temp)<index){
                            index=map.get(temp);
                            lru = temp;
                        }
                    }
                    ((LinkedList<Integer>) queue).remove(lru);
                    map.remove(lru);
                    pageFaults++;
                }
            }

            map.put(a[i],i);
        }
        return pageFaults;
    }
    static int pageFaults(int pages[], int n, int capacity)
    {
        // To represent set of current pages. We use
        // an unordered_set so that we quickly check
        // if a page is present in set or not
        HashSet<Integer> s = new HashSet<>(capacity);

        // To store least recently used indexes
        // of pages.
        HashMap<Integer, Integer> indexes = new HashMap<>();

        // Start from initial page
        int page_faults = 0;
        for (int i=0; i<n; i++)
        {
            // Check if the set can hold more pages
            if (s.size() < capacity)
            {
                // Insert it into set if not present
                // already which represents page fault
                if (!s.contains(pages[i]))
                {
                    s.add(pages[i]);

                    // increment page fault
                    page_faults++;
                }

                // Store the recently used index of
                // each page
                indexes.put(pages[i], i);
            }

            // If the set is full then need to perform lru
            // i.e. remove the least recently used page
            // and insert the current page
            else
            {
                // Check if current page is not already
                // present in the set
                if (!s.contains(pages[i]))
                {
                    // Find the least recently used pages
                    // that is present in the set
                    int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE;

                    Iterator<Integer> itr = s.iterator();

                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru)
                        {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }

                    // Remove the indexes page
                    s.remove(val);
                    //remove lru from hashmap
                    indexes.remove(val);
                    // insert the current page
                    s.add(pages[i]);

                    // Increment page faults
                    page_faults++;
                }

                // Update the current page index
                indexes.put(pages[i], i);
            }
        }

        return page_faults;
    }
}
