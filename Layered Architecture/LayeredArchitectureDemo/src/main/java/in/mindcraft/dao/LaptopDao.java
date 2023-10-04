package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import in.mindcraft.pojos.Laptop;
import in.mindcraft.utils.DButils;

public class LaptopDao {

//	private Connection cn;

	
	public boolean addLaptop(Laptop laptop) throws SQLException {
	    try (Connection cn = DButils.openConnection();
	         PreparedStatement pst = cn.prepareStatement("INSERT INTO laptop (lid, make, cost) VALUES (?, ?, ?)")) {

	        pst.setInt(1, laptop.getLid());
	        pst.setString(2, laptop.getMake());
	        pst.setDouble(3, laptop.getCost());

	        int updateCount = pst.executeUpdate();
	        return updateCount > 0;
	    }
	}

	public List<Laptop> getLaptop() throws Exception {
	    try (Connection cn = DButils.openConnection();
	         PreparedStatement pst = cn.prepareStatement("SELECT * FROM laptop");
	         ResultSet rs = pst.executeQuery()) {

	        List<Laptop> list = new ArrayList<>();
	        while (rs.next()) {
	            list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	        }

	        return list;
	    }
	}

}
