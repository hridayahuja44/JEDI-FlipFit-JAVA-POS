package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

import java.util.*;

public interface GymOwnerFlipFitServiceInterface {

    /*
  returns the gym owner's profile
    */
    public GymOwner getProfile(String email) throws GymOwnerNotFoundException;

     /*
allows the gym owner to edit profile
     */

    public void editProfile(GymOwner gymOwnerNews) throws GymOwnerNotFoundException;

    /*
allows the gym owner to add new gym
  */
    public boolean addGym(Gym gym);

    /*
allows the gym owner to edit the gym information
  */
    public void editGym(Gym gym) throws GymNotFoundException;

    /*
   returns the list of all gyms owned by the gym owner
        */
    public List<Gym> getGymDetail(String gymOwnerEmail);

    /*
returns true if the gym owner is approved else returns false
   */
    public boolean isApproved(String email);

    /*
 returns true if the gym  is approved else returns false
    */
    public boolean isGymApproved(String gymId);
}