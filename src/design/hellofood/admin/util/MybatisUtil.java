package design.hellofood.admin.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSession getSqlSession(){
		SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
		ClassLoader loader = MybatisUtil.class.getClassLoader();
		InputStream inStream = loader.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = builder.build(inStream);
		SqlSession session = factory.openSession();
		return session;
	}
}
