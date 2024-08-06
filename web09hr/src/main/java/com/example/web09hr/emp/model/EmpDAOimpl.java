package com.example.web09hr.emp.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOimpl implements EmpDAO{

    //3-1 : 전역변수 설정
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체


    public EmpDAOimpl(){
        System.out.println("DeptDAOimpl()....");

        //1.jdbc라이브러리 세팅(경로설정)
        //C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib : ojdbc6.jar복사
        //내 프로젝트 >> lib폴더(없다면 생성)에 >> 복붙
        //상단 메뉴> File > Project Structure > Libraries > + : java 선택 > 복붙경로 > ojdbc6.jar선택


        //2.오라클 드라이버 클래스 찾아서 인식(연동)-객체 생성시 즉 생성자에서 구현
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(EmpVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "insert into emp(employee_id,first_name,last_name,email,phone_number,hire_date,salary,job_id,commission_pct,manager_id,department_id) " +
                    "values(employees_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getFirst_name());
            pstmt.setString(2, vo.getLast_name());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getPhone_number());
            pstmt.setDate(5, vo.getHire_date());
            pstmt.setInt(6, vo.getSalary());
            pstmt.setString(7, vo.getJob_id());
            pstmt.setDouble(8, vo.getCommission_pct());
            pstmt.setInt(9, vo.getManager_id());
            pstmt.setInt(10, vo.getDepartment_id());

            //5. 반환(응답)
            flag = pstmt.executeUpdate();//DML

            System.out.println("flag:"+flag);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    @Override
    public int update(EmpVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "update emp set first_name=?,last_name=?,email=?," +
                    "phone_number=?,hire_date=?,salary=?,job_id=?," +
                    "commission_pct=?,manager_id=?,department_id=? " +
                    " where employee_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getFirst_name());
            pstmt.setString(2, vo.getLast_name());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getPhone_number());
            pstmt.setDate(5, vo.getHire_date());
            pstmt.setInt(6, vo.getSalary());
            pstmt.setString(7, vo.getJob_id());
            pstmt.setDouble(8, vo.getCommission_pct());
            pstmt.setInt(9, vo.getManager_id());
            pstmt.setInt(10, vo.getDepartment_id());
            pstmt.setInt(11, vo.getEmployee_id());

            //5. 반환(응답)
            flag = pstmt.executeUpdate();//DML

            System.out.println("flag:"+flag);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    @Override
    public int delete(EmpVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "delete from emp where employee_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getEmployee_id());

            //5. 반환(응답)
            flag = pstmt.executeUpdate();//DML

            System.out.println("flag:"+flag);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    @Override
    public EmpVO selectOne(EmpVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);
        EmpVO vo2 = null;

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "select * from emp where employee_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getEmployee_id());

            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                vo2 = new EmpVO();
                vo2.setEmployee_id(rs.getInt("employee_id"));
                vo2.setFirst_name(rs.getString("first_name"));
                vo2.setLast_name(rs.getString("last_name"));
                vo2.setEmail(rs.getString("email"));
                vo2.setPhone_number(rs.getString("phone_number"));
                vo2.setHire_date(rs.getDate("hire_date"));
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setSalary(rs.getInt("salary"));
                vo2.setCommission_pct(rs.getDouble("commission_pct"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setDepartment_id(rs.getInt("department_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return vo2;
    }

    @Override
    public List<EmpVO> selectAll() {
        System.out.println("selectAll()...");
        List<EmpVO> list = new ArrayList<>();

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "select * from emp order by employee_id desc";
            pstmt = conn.prepareStatement(sql);

            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getDate("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getInt("salary"));
                vo.setCommission_pct(rs.getDouble("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return list;
    }


    @Override
    public List<EmpVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        List<EmpVO> list = new ArrayList<>();

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "";
            if(searchKey.equals("first_name")){
                sql = "select * from emp where first_name like ? order by employee_id desc";
            }else if(searchKey.equals("phone_number")){
                sql = "select * from emp where phone_number like ? order by employee_id desc";
            }else if(searchKey.equals("job_id")){
                sql = "select * from emp where job_id like ? order by employee_id desc";
            }else{
                sql = "select * from emp where employee_id=0";
            }


            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");
            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getDate("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getInt("salary"));
                vo.setCommission_pct(rs.getDouble("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return list;
    }
}
