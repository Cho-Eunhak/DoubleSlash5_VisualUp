package com.backend.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.backend.dao.GoalDAO;
import com.backend.dto.GoalVO;
@Service
public class GoalServiceImpl implements GoalService {
	
	@Inject
	private GoalDAO goal;

	@Override
	public void insertGoal(GoalVO newgoal){
		
		goal.insertGoal(newgoal);
		

	}
	
	@Override
	public String newGoalID() {
		return goal.newGoalID();
	}
	
	@Override
	public List<GoalVO> getGoalList(String userid){
		return goal.getGoalList(userid);
	}

}