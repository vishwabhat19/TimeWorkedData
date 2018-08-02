package org.springframework.batch.item.excel;

import org.springframework.batch.item.excel.support.rowset.RowSet;

import hello.TimeWorked;

public class RowMapperImpl implements RowMapper<TimeWorked> {

	public RowMapperImpl() {
    }
	
	@Override
	public TimeWorked mapRow(RowSet rs) throws Exception {
		if (rs == null || rs.getCurrentRow() == null) {
            return null;
        }
		TimeWorked timeWorked = new TimeWorked();
		if(rs.getColumnValue(0).isEmpty())
			{
				timeWorked.setRestricted("");
			}
		else{
			timeWorked.setRestricted(rs.getColumnValue(0));
		}
		if(rs.getColumnValue(1).isEmpty())
		{
			timeWorked.setUser("");
		}
		else {
			timeWorked.setUser(rs.getColumnValue(1));
		}
		if(rs.getColumnValue(2).isEmpty()) {
			timeWorked.setTrackingConfigurationItem("");
		}
		else {
			timeWorked.setTrackingConfigurationItem(rs.getColumnValue(2));
		}
		if(rs.getColumnValue(3).isEmpty()){
			timeWorked.setActivity("");
		}
		else {
			timeWorked.setActivity(rs.getColumnValue(3));
		}
		if(rs.getColumnValue(4).isEmpty()){
			timeWorked.setTimeWorked("");
		}
		else {
			timeWorked.setTimeWorked(rs.getColumnValue(4).toString());
		}
		
			timeWorked.setUpdated((rs.getColumnValue(5)));
			timeWorked.setNumber(rs.getColumnValue(6));
			timeWorked.setTitle(rs.getColumnValue(7));
		
		if(rs.getColumnValue(8).isEmpty()){
			timeWorked.setSubcause("");
		}
		else {
			timeWorked.setSubcause(rs.getColumnValue(8));
		}
		if(rs.getColumnValue(9).isEmpty()){
			timeWorked.setCaller("");
		}
		else {
			timeWorked.setCaller(rs.getColumnValue(9));
		}
		if(rs.getColumnValue(10).isEmpty()){
			timeWorked.setResolvedBy("");
		}
		else {
			timeWorked.setResolvedBy(rs.getColumnValue(10));
		}
		
		if(rs.getColumnValue(11).isEmpty()){
			timeWorked.setState("");
		}
		else {
			timeWorked.setState(rs.getColumnValue(11));
		}
		
		if(rs.getColumnValue(12).isEmpty()){
			timeWorked.setConfigurationItem("");
		}
		else {
			timeWorked.setConfigurationItem(rs.getColumnValue(12));
		}
		
		if(rs.getColumnValue(13).isEmpty()){
			timeWorked.setAppleKeywords("");
		}
		else {
			timeWorked.setAppleKeywords(rs.getColumnValue(13));
		}
		
		if(rs.getColumnValue(14).isEmpty()){
			timeWorked.setCreated("");
		}
		else {
			timeWorked.setCreated(rs.getColumnValue(14));
		}
		
		if(rs.getColumnValue(15).isEmpty()){
			timeWorked.setAssignmentGroup("");
		}
		else {
			timeWorked.setAssignmentGroup(rs.getColumnValue(15));
		}
		
		if(rs.getColumnValue(16).isEmpty()){
			timeWorked.setReassignmentCount("");
		}
		else {
			timeWorked.setCreated(rs.getColumnValue(16));
		}
		
		return timeWorked;
	}
	
	

}
