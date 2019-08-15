package LMSG.view.Clients;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;


import LMSG.view.connect.DBConnector;



public class ProposersDAO {
    public ProposersDAO() {
        super();
    }

    public List<Proposer> findProposers() 
    {
      Connection conn=null;
      CallableStatement cstmt=null;
      conn=new DBConnector().getDatabaseConn();
      List<Proposer> ProposersList=new ArrayList<Proposer>();
      String proposersQuery="BEGIN LMS_WEB_CURSOR_GRP.get_grp_proposers(?);END;";
      ResultSet rs= null;
      try 
      {
        cstmt=conn.prepareCall(proposersQuery);
        cstmt.registerOutParameter(1,OracleTypes.CURSOR);
        cstmt.execute();
        rs=(ResultSet)cstmt.getObject(1);
        while(rs.next()) 
        {
          Proposer prop=new Proposer();
          prop.setCLIENT(rs.getString(2));
          prop.setPRP_CODE(rs.getBigDecimal(1));
          prop.setPRP_SHT_DESC(rs.getString(3));
          prop.setPRP_ID_REG_NO(rs.getString(4));
          prop.setPRP_DOB(rs.getString(5));
          prop.setGCO_CODE(rs.getBigDecimal(6));
          prop.setGCO_SHT_DESC(rs.getString(7));
          prop.setGCO_DESC(rs.getString(8));
          prop.setHazard(rs.getString(9));
          prop.setLC_CODE(rs.getBigDecimal(10));
          prop.setPrp_clnt_code(rs.getBigDecimal(11));
          ProposersList.add(prop);
        }
          conn.close();
      }
      catch(Exception e) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
      }finally{
          GlobalCC.CloseConnections(rs, cstmt, conn);
        } 
      return ProposersList;
    }
}
