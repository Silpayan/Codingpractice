package user;

import java.time.LocalDateTime;
import java.util.TreeMap;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class MeetingRoom {

    private final String meetingRoomId;

    private final TreeMap<LocalDateTime, LocalDateTime> calendar;

    public MeetingRoom(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
        calendar = new TreeMap<>();
    }

    public String scheduleMeeting(LocalDateTime start, LocalDateTime end) {
        LocalDateTime before = calendar.lowerKey(end);
        if (null != before && calendar.get(before).isAfter(start)) {
            return null;
        }
        calendar.put(start, end);
        return this.meetingRoomId;
    }
}

class MeetingSchedulerService {

    private final Set<MeetingRoom> meetingRooms;

    public MeetingSchedulerService(Integer rooms) {
        this.meetingRooms = new HashSet<>();
        for (int i = 0; i < rooms; i++) {
            meetingRooms.add(new MeetingRoom(UUID.randomUUID().toString()));
        }
    }

    public String scheduleMeeting(LocalDateTime start, LocalDateTime end) {
        String scheduledMeetingRoomId;
        for (MeetingRoom meetingRoom : meetingRooms) {
            scheduledMeetingRoomId = meetingRoom.scheduleMeeting(start, end);
            if (null != scheduledMeetingRoomId) {
                return scheduledMeetingRoomId;
            }
        }
        throw new RuntimeException("No Meeting Room available for Start Time : "
                + start + " and End Time: " + end);
    }

}