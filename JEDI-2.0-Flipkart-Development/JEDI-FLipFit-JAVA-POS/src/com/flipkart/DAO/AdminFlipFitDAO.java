package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public interface AdminFlipFitDAO {

	public List<GymOwner> getAllGymOwners();

	public List<Gym> getAllGyms();

	public List<GymOwner> getPendingGymOwnerRequests();

	public List<Gym> getPendingGymRequests();

	public int approveSingleOwnerRequest(String gymOwnerEmail);

	public int approveAllOwnerRequest();

	public int approveSingleGymRequest(String gymId);

	public int approveAllGymRequest();
}