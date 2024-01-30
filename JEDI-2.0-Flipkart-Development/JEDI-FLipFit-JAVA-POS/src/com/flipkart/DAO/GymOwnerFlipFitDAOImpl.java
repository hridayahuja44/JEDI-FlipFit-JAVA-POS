package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.UnauthorizedAccessException;
import com.flipkart.utils.DBUtils;

public class GymOwnerFlipFitDAOImpl implements GymOwnerFlipFitDAO {

	public GymOwner getGymOwnerDetails(String gymOwnerEmailId) {
		Connection connection = null;
		GymOwner gymOwner = new GymOwner();
		try {
			connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_SELECT_GYM_OWNER_DETAILS);
			preparedStatement.setString(1, gymOwnerEmailId);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next())
				return null;
			do {
				gymOwner.setEmail(rs.getString("email"));
				gymOwner.setName(rs.getString("name"));
				gymOwner.setPhoneNumber(rs.getString("phoneNum"));
				gymOwner.setAadharNumber(rs.getString("aadharNum"));
				gymOwner.setPanNumber(rs.getString("panNum"));

			} while (rs.next());
		} catch (SQLException e) {
			printSQLException(e);
		}
		return gymOwner;
	}

	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_USER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, "GymOwner");

			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}

		System.out.println(SQLConstants.SQL_INSERT_GYM_OWNER);
		// Step 1: Establishing a Connection
		try {
			connection = DBUtils.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_GYM_OWNER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, gymOwnerDetails.getName());
			preparedStatement.setString(4, gymOwnerDetails.getPhoneNumber());
			preparedStatement.setString(5, gymOwnerDetails.getAadharNumber());
			preparedStatement.setString(6, gymOwnerDetails.getPanNumber());
			preparedStatement.setBoolean(7, gymOwnerDetails.isVerified());

			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
	}


	public int editGymOwnerDetails(GymOwner gymOwnerDetails) {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_USER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, "GymOwner");
			preparedStatement.setString(4, gymOwnerDetails.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}

		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_GYM_OWNER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getName());
			preparedStatement.setString(3, gymOwnerDetails.getPhoneNumber());
			preparedStatement.setString(4, gymOwnerDetails.getAadharNumber());
			preparedStatement.setString(5, gymOwnerDetails.getPanNumber());
			preparedStatement.setBoolean(6, gymOwnerDetails.isVerified());
			preparedStatement.setString(7, gymOwnerDetails.getEmail());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return 0;
	}

	public Gym getGym(String gymId) {
		Connection connection = null;
		Gym gym = new Gym();
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_READ_GYM);
			preparedStatement.setString(1, gymId);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next())
				return null;
			do {
				gym.setGymId(rs.getString("gymId"));
				gym.setGymName(rs.getString("gymName"));
				gym.setOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setAddress(rs.getString("address"));
				gym.setSlotCount(rs.getInt("slotCount"));
				gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlot"));
				gym.setVerified(rs.getBoolean("isVerified"));

			} while (rs.next());
		} catch (SQLException e) {
			printSQLException(e);
		}
		return gym;
	}

	public void addGym(Gym gymDetails) {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_GYM);
			preparedStatement.setString(1, gymDetails.getGymId());
			preparedStatement.setString(2, gymDetails.getGymName());
			preparedStatement.setString(3, gymDetails.getOwnerEmail());
			preparedStatement.setString(4, gymDetails.getAddress());
			preparedStatement.setInt(5, gymDetails.getSlotCount());
			preparedStatement.setInt(6, gymDetails.getSeatsPerSlotCount());
			preparedStatement.setBoolean(7, gymDetails.isVerified());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}


	public int editGym(Gym gymDetails) {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_GYM);
			preparedStatement.setString(1, gymDetails.getGymId());
			preparedStatement.setString(2, gymDetails.getGymName());
			preparedStatement.setString(3, gymDetails.getOwnerEmail());
			preparedStatement.setString(4, gymDetails.getAddress());
			preparedStatement.setInt(5, gymDetails.getSlotCount());
			preparedStatement.setInt(6, gymDetails.getSeatsPerSlotCount());
			preparedStatement.setBoolean(7, gymDetails.isVerified());
			preparedStatement.setString(8, gymDetails.getGymId());

			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return 0;
	}

	public List<Gym> getGymsOfGymOwner(String gymOwnerId) {
		Connection connection = null;
		List<Gym> gyms = new ArrayList<Gym>();
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_SELECT_ALL_GYMS);
			preparedStatement.setString(1, gymOwnerId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Gym gym = new Gym();
				gym.setGymId(rs.getString("gymId"));
				gym.setGymName(rs.getString("gymName"));
				gym.setOwnerEmail(rs.getString("ownerEmail"));
				gym.setAddress(rs.getString("address"));
				gym.setSlotCount(rs.getInt("slotCount"));
				gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlotCount"));
				gym.setVerified(rs.getBoolean("isVerified"));
				gyms.add(gym);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return gyms;
	}

	public List<Slot> getPossibleSlots(String gymId) {
		Connection connection = null;
		List<Slot> slots = new ArrayList<Slot>();
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_READ_SLOT_FROM_GYMID);
			preparedStatement.setString(1, gymId);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next())
				return null;
			do {
				Slot slot = new Slot();
				slot.setSlotId(rs.getString("slotId"));
				slot.setGymId(rs.getString("gymId"));
				slot.setStartTime(rs.getString("startTime"));
				slot.setEndTime(rs.getString("endTime"));
				slot.setTrainer(rs.getString("trainer"));
				slots.add(slot);
			} while (rs.next());
		} catch (SQLException e) {
			printSQLException(e);
		}
		return slots;
	}

	public boolean addSlot(Slot slot, String ownerEmail) throws UnauthorizedAccessException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatementAuthorize = connection.prepareStatement(SQLConstants.SQL_SELECT_GYM_WITH_OWNER);
			preparedStatementAuthorize.setString(1, slot.getGymId());
			preparedStatementAuthorize.setString(2, ownerEmail);
			ResultSet rs1 = preparedStatementAuthorize.executeQuery();
			if (!rs1.next())
				throw new UnauthorizedAccessException();

			PreparedStatement preparedStatementGym = connection.prepareStatement(SQLConstants.SQL_READ_GYM);
			preparedStatementGym.setString(1, slot.getGymId());
			ResultSet rs = preparedStatementGym.executeQuery();
			if (!rs.next())
				return false;
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_SLOT);
			preparedStatement.setString(1, slot.getSlotId());
			preparedStatement.setString(2, slot.getGymId());
			preparedStatement.setString(3, slot.getDate());
			preparedStatement.setString(4, slot.getStartTime());
			preparedStatement.setString(5, slot.getEndTime());
			preparedStatement.setString(6, slot.getTrainer());
			preparedStatement.setInt(7, slot.getNumOfSeats());
			preparedStatement.setInt(8, slot.getNumOfSeatsBooked());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {

			printSQLException(e);
		}
		return false;
	}

	public boolean checkOwnerApproval(String email) {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_SELECT_VERIFICATION_STATUS_GYM_OWNER);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}

	public boolean checkGymApproval(String gymId) {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_SELECT_VERIFICATION_STATUS_GYM);
			preparedStatement.setString(1, gymId);
			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}