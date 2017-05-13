package ru.digdes.steammarketparser.conf;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

/**
 * TODO javadoc
 */

@Configuration
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@PropertySource({"classpath:db.properties"})
@ComponentScan("ru.digdes.steammarketparser")
@EnableJpaRepositories(basePackages = "ru.digdes.steammarketparser.model.repository")
public class SteamMarketConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource restDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/steammarket");
        dataSource.setUsername("postgres");
        dataSource.setPassword("rootroot");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan("ru.digdes.steammarketparser.model.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }


    /**
     * creating map of hibernate properties only
     *
     * @return Hibernate properties
     */
    private Properties hibernateProperties() {
        Properties props = new Properties();
        MutablePropertySources propSources = ((AbstractEnvironment) env).getPropertySources();
        Map<String, String> hibernateMap = stream(spliteratorUnknownSize(propSources.iterator(), ORDERED), false)
                .filter(ps -> ps instanceof MapPropertySource)
                .flatMap(ps -> ((MapPropertySource) ps).getSource().entrySet().stream())
                .filter(entry -> entry.getKey().contains("hibernate"))
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()));
        props.putAll(hibernateMap);
        return props;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(restDataSource());

        em.setPackagesToScan("ru.digdes.steammarketparser.model.entity");

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");

        em.setJpaVendorAdapter(jpaVendorAdapter);
        return em;
    }

}
