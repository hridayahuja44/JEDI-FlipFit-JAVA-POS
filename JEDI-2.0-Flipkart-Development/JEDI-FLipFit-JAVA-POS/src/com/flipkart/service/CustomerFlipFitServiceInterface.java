package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.SlotNotFoundException;

import java.util.*;

public interface CustomerFlipFitServiceInterface {
    /*
    returns the customer profile
    */
    public Customer getProfile(Customer customer) throws CustomerNotFoundException;


    /*
   allows the customer to edit profile
   */
    public void editProfile(Customer customer)  throws CustomerNotFoundException;

    /*
    returns the customer profile
    */

    public Customer getProfile(String email) throws CustomerNotFoundException;

    /*
    returns the list of gyms in a city
    */
    public List<Gym> getGymInCity(String city) ;

    /*
   returns the list of slots in a gym
   */
    public List<Slot> getSlotInGym(String gymId) throws SlotNotFoundException;

    /*
    returns true if the slot is fully booked else returns false
    */
    public boolean isSlotBooked(String slotId, String date);

    /*
   allows the customer to cancel Booking
   */
    public boolean cancelBooking(String bookingId, String email);
}