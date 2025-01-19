package Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _6_Job_Seq_max_pro {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i , int d,int p){
            id =i;
            deadline =d;
            profit =p;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] ={{4,20} ,{1,10} , {1,40}, {1,30}};
        //job 1-> a(0) ,job2->b(1),c(2),d(3)

        ArrayList<Job> jobs =new ArrayList<>();
        for (int i = 0; i <jobsInfo.length ; i++) {
            jobs.add(new Job(i,jobsInfo[i][0], jobsInfo[i][1]));
        }

        //descending order of profit
        Collections.sort(jobs,(obj1,obj2)->obj2.profit -obj1.profit);

        ArrayList<Integer> seq =new ArrayList<>();
        int time =0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr =jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        //print seq
        System.out.println("max jobs = " +seq.size());
        for (int i = 0; i <seq.size() ; i++) {
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
