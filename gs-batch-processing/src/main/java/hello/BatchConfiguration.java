package hello;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.excel.RowMapperImpl;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.Transactional;



@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonItemProcessor.class);


    // tag::readerwriterprocessor[]
    @Bean
    public PoiItemReader<TimeWorked> reader() {
    
    	PoiItemReader<TimeWorked> reader = new PoiItemReader<TimeWorked>();
		reader.setResource(new FileSystemResource("/Users/vishwanath_bhat/Desktop/task_time_worked-3.xlsx"));
		reader.setLinesToSkip(1);
		reader.setRowMapper(new RowMapperImpl());
		
		return reader;
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    @Transactional
    public JdbcBatchItemWriter<TimeWorked> writer(DataSource dataSource,ItemPreparedStatementSetter<TimeWorked> timeWorkedJdbcSetter) {
    	
    	JdbcBatchItemWriter<TimeWorked> writer = new JdbcBatchItemWriter<TimeWorked>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TimeWorked>());
		//writer.setItemPreparedStatementSetter(outflowDataJdbcSetter);
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Date today = new Date();
		// String date="2017-01-06";
		// String date = dateFormat.format(today);
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TimeWorked>());
		writer.setItemPreparedStatementSetter(timeWorkedJdbcSetter);
		writer.setSql("INSERT INTO TIME_WORKED (RESTRICTED,USER,TRACKING_CONFIGURATION_ITEM,ACTIVITY,TIME_WORKED,UPDATED,NUMBER,TITLE,SUBCAUSE,CALLER,RESOLVED_BY,STATE,CONFIGURATION_ITEM,APPLE_KEYWORDS,CREATED,ASSIGNMENT_GROUP,REASSIGNMENT_COUNT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		writer.setDataSource(dataSource);
		return writer;
//        return new JdbcBatchItemWriterBuilder<TimeWorked>()
//            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//            .sql("INSERT INTO TIME_WORKED (USER,CONFIGURATION_ITEM,ACTIVITY,TIME_WORKED,REASSIGNMENT_COUNT) VALUES (:user,:configurationItem,:activity,:timeWorked,:reassignmentCount)")
//            .dataSource(dataSource)
//            .build();
    }
    // end::readerwriterprocessor[]
    
    @Bean
	public ItemPreparedStatementSetter<TimeWorked> timeWorkedJdbcSetter() {
		LOGGER.debug("Enter timeWorkedJdbcSetter method");

		return (item, ps) -> {
			if (item != null) {
				ps.setString(1, item.getRestricted());
				ps.setString(2, item.getUser());
				ps.setString(3, item.getTrackingConfigurationItem());
				ps.setString(4, item.getActivity());
				ps.setString(5, item.getTimeWorked());
				ps.setString(6, item.getUpdated());
				ps.setString(7, item.getNumber());
				ps.setString(8, item.getTitle());
				ps.setString(9, item.getSubcause());
				ps.setString(10, item.getCaller());
				ps.setString(11, item.getResolvedBy());
				ps.setString(12, item.getState());
				ps.setString(13, item.getConfigurationItem());
				ps.setString(14, item.getAppleKeywords());
				ps.setString(15, item.getCreated());

				ps.setString(16, item.getAssignmentGroup());
				ps.setString(17, item.getReassignmentCount());

				
			} // if
			else {
				LOGGER.debug("timeWorkedJdbcSetter : Item is null");
			}
		};
	}

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<TimeWorked> writer) {
        return stepBuilderFactory.get("step1")
            .<TimeWorked, TimeWorked> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
    // end::jobstep[]
    
    @Bean
    public DataSource dataSource() {
     final DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName("com.mysql.jdbc.Driver");
     dataSource.setUrl("jdbc:mysql://localhost/demo");
     dataSource.setUsername("root");
     dataSource.setPassword("Vish@2105");
     
     return dataSource;
    }
}
