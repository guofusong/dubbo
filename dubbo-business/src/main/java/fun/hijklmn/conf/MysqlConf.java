package fun.hijklmn.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.net.MalformedURLException;

@Configuration
@PropertySource("classpath:/jdbc.properties")
public class MysqlConf implements EnvironmentAware {

    private Environment env;

    public void setEnvironment(Environment env) {
        this.env = env;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setInitialSize(3);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(env.getRequiredProperty("mysql.url"));
        dataSource.setUsername(env.getRequiredProperty("mysql.username"));
        dataSource.setPassword(env.getRequiredProperty("mysql.password"));
        dataSource.setMaxActive(env.getRequiredProperty("mysql.maxactive", Integer.class));
        dataSource.setMinIdle(env.getRequiredProperty("mysql.minidle", Integer.class));
        dataSource.setMaxWait(env.getRequiredProperty("mysql.maxwait", Integer.class));
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws MalformedURLException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getDruidDataSource());
        bean.setTypeAliasesPackage("fun.hijklmn.*");
        return bean;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("fun.hijklmn.*");
        return configurer;
    }

}
