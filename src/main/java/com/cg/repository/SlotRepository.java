package com.cg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Slot;
@Transactional
@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer>{
	
	//Returns Last Slot in Slot table
	public Slot findTopByOrderBySlotNoDesc();
	
	//Deletes Slot as per given slotNo
	@Modifying 
	@Query("delete from Slot slot where slot.slotNo=:slotNumber")
	public void deleteBySlotNo(@Param("slotNumber") String slotNumber);

	//Returns List of All Vacant/Available Slots
	@Query("SELECT s FROM Slot s WHERE s.slotStatus = 'Vacant'")
	public List<Slot> findAllAvailableSlot();
	
	//Return Slot as per SlotNo
	@Query("from Slot slot where slot.slotNo=:slotNumber") 
	public Slot findBySlotNo(@Param("slotNumber") String slotNumber);
	
	
	
}
