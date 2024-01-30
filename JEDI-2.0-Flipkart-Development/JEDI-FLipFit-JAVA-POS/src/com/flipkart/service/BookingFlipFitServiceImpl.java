/**
 *
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import java.util.*;
import java.util.Date;
/**
 *
 */public class BookingFlipFitServiceImpl implements BookingFlipFitServiceInterface {

	List<Booking> bookings=new ArrayList<>();
	Date d1=new Date();

	public BookingFlipFitServiceImpl()
	{

	}

	public boolean isConfirmed(String bookingId) {

		for(Booking b:bookings)
		{
			if(b.getBookingId().equals(bookingId))
			{
				if(b.getType()=="confirmed")
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public int getWaitingList() {
		return -1;
	}

}