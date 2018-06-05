package Recursion;

/**
 * (CTCI Q17.16) Question:
 *  A popular masseuse receives a sequence of back2back appointments and is debating which ones to accept. She needs
 *  15 min break between appointments. Given a sequence of back2back appointments all multiples of 15 with no overlaps and
 *  unable to be moved find the optimal (highest total booked minutes).
 *  eg: {30,15,60,75,45,15,15,45}
 *      result: 180 {30,50,45,45}
 *
 * Mistakes:
 *  - In the recursive call to not propagate the sum value have it only as a return type.
 *    DO: recursiveHelper(appointments, index+1) + appointments[index]
 *    NOT: recursiveHelper(appointments, index+1, sum + appointments[index])
 *
 * Solution:
 *  In each appointment you have 2 steps accept it and do not accept the one after this
 *  or do not accept it and accept the next appointment.
 *  Recursively search both options and return the one that has the max sum.
 *
 *  To avoid computing multiple times the same step use an array to store the best sum at any given index.
 *  TIP: Always solve the recursive problems without memoization and then try to add the cache!
 */
public class Masseuse {
    public static int maxMinutesRecursively(int[] appointments) {
        int[] cache = new int[appointments.length];
        return recursiveHelper(appointments,0, cache);
    }

    private static int recursiveHelper(int[] appointments, int index, int[] cache) {

        if(index>=appointments.length)
            return 0;

        if(cache[index]==0){
            int currentAppointmentNotPicked = recursiveHelper(appointments,index+1, cache);
            int currentAppointmentPicked = recursiveHelper(appointments,index+2, cache) + appointments[index];
            cache[index] = Math.max(currentAppointmentNotPicked,currentAppointmentPicked);
        }

        return cache[index];
    }
}
