package com.example.demo.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.UserModel;

@Repository("userRepo")
public class UserRepo {
	  @Autowired
	   JdbcTemplate jdbcTemplate;
	    int value=0;
	   
	public boolean isAddNewUser(UserModel model)
	{
	   value=jdbcTemplate.update("insert into user values('0',?,?,?)", new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			// TODO Auto-generated method stub
			
			ps.setString(1, model.getUserName());
			ps.setString(2, model.getPassword());
			ps.setInt(3, model.getRoleID());
		}
		   
	   });
		 
		return value>0?true:false;
	}
	
	
	List<UserModel> list;
	
	public List<UserModel>  getAllUser()
	{
		List<UserModel> list = jdbcTemplate.query("SELECT * FROM user", new RowMapper<UserModel>() {
	    @Override
	    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	        UserModel user = new UserModel();
	        user.setUserID(rs.getInt(1));
	        user.setUserName(rs.getString(2));
	        user.setPassword(rs.getString(3));
	        user.setRoleID(rs.getInt(4));
	       
	        return user;
	    }
	});
   return list;
  }
	 
	public UserModel searchUserByID(int id) {
	    List<UserModel> list = jdbcTemplate.query("select * from user where userID = ?",new Object[]{id}, new RowMapper<UserModel>() {
	          
	    	  @Override
	            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	                UserModel user = new UserModel();
	                user.setUserID(rs.getInt("userID"));          
	                user.setUserName(rs.getString("userName")); 
	                user.setPassword(rs.getString("password"));
	                user.setRoleID(rs.getInt("roleID"));
	                return user;
	            }
	        }
	    );

	    return list.isEmpty() ? null : list.get(0);
	}
  

    public UserModel  updateUserByID(int id)
    {
	    return null;
    }
    
    
    public boolean isDeleteUserByID(int id)
    {
    	
    	value=jdbcTemplate.update("delete  from user where userID="+id);
    	
    	return value>0?true:false;
    }
	   
	
	
}



