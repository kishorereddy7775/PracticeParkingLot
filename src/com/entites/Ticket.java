package com.entites;

import java.time.LocalDateTime;

public record Ticket(int id, LocalDateTime entryTime, int spot, Vehicle vehicle) {

}
