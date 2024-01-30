package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.exception.UnauthorizedAccessException;

public interface GymOwnerFlipFitDAO {

	public GymOwner getGymOwnerDetails(String gymOwnerEmailId);

	public void addGymOwnerDetails(GymOwner gymOwnerDetails);

	public int editGymOwnerDetails(GymOwner gymOwnerDetails);

	public Gym getGym(String gymId);

	public void addGym(Gym gymDetails);

	public int editGym(Gym gymDetails);

	public List<Gym> getGymsOfGymOwner(String gymOwnerId);

	public List<Slot> getPossibleSlots(String gymId);

	public boolean addSlot(Slot slot, String ownerEmail) throws UnauthorizedAccessException;

	public boolean checkOwnerApproval(String email);

	public boolean checkGymApproval(String gymId);
}