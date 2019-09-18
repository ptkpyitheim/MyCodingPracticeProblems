import java.util.*;

/* A linked list node but named Location instead */ 
class Location {
    Location next;
    String name;

    public Location(String name) {
        this.name = name;
        next = null;
    }
}


public class HyperLoop {
    public Location detectFault(Location start) {
        /* two slow and fast pointers */
        Location tmpLoc1 = start;
        Location tmpLoc2 = start;
        
        /* slow and fast pointers to detect a loop */
        while(tmpLoc2 != null && tmpLoc2.next != null) {
            tmpLoc2 = tmpLoc2.next.next;
            tmpLoc1 = tmpLoc1.next;
            if(tmpLoc1 == tmpLoc2) {
                break;
            }
        }
        
        /* If the location is empty, there is no loop - return null */
        if(tmpLoc2 == null || tmpLoc2.next == null) {
            return null;
        }
        
        /* Find the start of the loop */
        tmpLoc1 = start;
        while(tmpLoc1 != tmpLoc2) {
            tmpLoc1 = tmpLoc1.next;
            tmpLoc2 = tmpLoc2.next;
        }
        
        return tmpLoc2;
    }
}