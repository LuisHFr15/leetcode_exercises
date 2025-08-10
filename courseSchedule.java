/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

    Return true if you can finish all courses. Otherwise, return false.
 */


 // I'm aware that this is not the very optimized solution, but is a solution using theory based on my university
 // studies to resolve the problem
import java.util.*;

public class courseSchedule {
    private class Courses {
        // why HashSet and HashMap?
        // the access in HashSet and HashMap are direct, i.e., O(1)
        // reduces the time execution and is better to performance
        public HashMap<Integer, Integer> visitedFlag;
        public Map<Integer, HashSet<Integer>> coursesRequisistes;

        public Courses() {
            this.visitedFlag = new HashMap<>();
            this.coursesRequisistes = new HashMap<>();
        }

        public void addRequisite(int course, int requisite) {
            // the requisite appoints to a course that have it as requisite
            this.coursesRequisistes.computeIfAbsent(requisite, k -> new HashSet<>()).add(course);
        }

        public void resetFlags(int numCourses) {
            for (int i = 0; i < numCourses; i++) {
                this.visitedFlag.put(i, 0); // 0 -> never visited
            }
        }

        private boolean hasCycle(int course) {
            if (this.visitedFlag.get(course) == 1) return true;
            if (this.visitedFlag.get(course) == 2) return false;

            this.visitedFlag.put(course, 1); // visiting
            for (int next : this.coursesRequisistes.getOrDefault(course, new HashSet<>())) {
                if (hasCycle(next)) return true;
            }
            this.visitedFlag.put(course, 2); // completed
            return false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Courses courses = new Courses();
        
        for(int index = 0; index < prerequisites.length; index++) {
            int originalCourse = prerequisites[index][0];
            int prerequisite = prerequisites[index][1];
            courses.addRequisite(originalCourse, prerequisite);
        }

        courses.resetFlags(numCourses);

        for(int course = 0; course < numCourses; course++) {
            if(courses.hasCycle(course)) return false;
        }

        return true;
    }
}
